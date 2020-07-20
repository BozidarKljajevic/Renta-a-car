package com.microservices.authentication.service;

import com.microservices.authentication.dto.feignDTOs.UserDTO;
import com.microservices.authentication.dto.request.UserRequest;
import com.microservices.authentication.dto.response.UserResponse;

import java.util.List;
import java.util.Set;

public interface IUserService {

    UserResponse getUser(long id);

    List<UserDTO> getAllUsers();

    UserResponse createUser(UserRequest request);

    UserResponse updateAd(UserRequest request, long id);

    void deleteUser(long id);
}
