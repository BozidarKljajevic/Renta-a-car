package com.microservices.authentication.service;

import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.dto.feignDTOs.UsersDTO;
import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.dto.response.UserResponse;
import com.microservices.authentication.model.Authority;
import com.microservices.authentication.model.User;
import com.microservices.authentication.repository.AuthorityRepository;
import com.microservices.authentication.repository.UserRepository;
import com.microservices.authentication.utils.RegistrationState;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);


    public User findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findOne(String mail) {
        return userRepository.findByEmail(mail);
    }

    public void save(UserRequest user) {


        User subject = new User();
        Authority auth = this.authorityRepository.findByName("USER");
        List<Authority> auths = new ArrayList<>();
        auths.add(auth);
        subject.setName(user.getName());
        subject.setEmail(user.getEmail());
        subject.setPhoneNumber(user.getPhoneNumber());
        subject.setSurname(user.getSurname());
        subject.setCountry(user.getCountry());
        subject.setTown(user.getTown());
        subject.setActive(true);
        subject.setBlocked(false);
        subject.setAuthorities(auths);
        subject.setPassword(passwordEncoder.encode(user.getPassword()));
        //   createLogFileSuccess(user);
        userRegistrationSuccessfulLog();
        subject.setRegistrationState(RegistrationState.PENDING);
        userRepository.save(subject);
    }

    public void createLogFileSuccess(UserRequest user) {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("myLog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("type: SUCCESS");
            logger.info("user" + user.getEmail());
            logger.info("messages: Register success by user");



        } catch (SecurityException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void createLogFileFailure(String regType, UserRequest user) {
        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("myLog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            if(regType.equals("password")) {
                logger.info("type: FAILURE");
                logger.info("user: " + user.getEmail());
                logger.info("messages: Register failure by user");
                logger.info("Inserted password: " + user.getPassword());
            }

            else if(regType.equals("phoneNumber")) {
                logger.info("type: FAILURE");
                logger.info("user: " + user.getEmail());
                logger.info("messages: Register failure by user");
                logger.info("Inserted phone number: " + user.getPhoneNumber());
            }


        } catch (SecurityException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void userRegistrationSuccessfulLog() {
//        if(logger.isErrorEnabled()) {
        logger.info("SUCCESS User successfully registered.");
//        }
    }


    public List<UsersDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

    private UsersDTO mapToResponse(User user) {
        UsersDTO response = new UsersDTO();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setSurname(user.getSurname());
        response.setPermissionBlocked(user.getPermissionBlocked());
        return response;
    }

}
