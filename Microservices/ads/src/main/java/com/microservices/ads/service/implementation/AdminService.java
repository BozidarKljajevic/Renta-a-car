package com.microservices.ads.service.implementation;

import com.microservices.ads.dto.request.CreateAdminRequest;
import com.microservices.ads.dto.request.DenyCommentRequest;
import com.microservices.ads.dto.request.UpdateAdminRequest;
import com.microservices.ads.dto.response.AdminResponse;
import com.microservices.ads.dto.response.CommentResponse;
import com.microservices.ads.model.Comment;
import com.microservices.ads.model.User;
import com.microservices.ads.repository.IAdminRepository;
import com.microservices.ads.repository.ICommentRepository;
import com.microservices.ads.repository.IUserRepository;
import com.microservices.ads.service.IAdminService;
import com.microservices.ads.utils.CommentRequestState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService implements IAdminService {

    private final IUserRepository _userRepository;

    private final IAdminRepository _adminRepository;

    private final ICommentRepository _commentRepository;

    public AdminService(IUserRepository userRepository, IAdminRepository adminRepository, ICommentRepository commentRepository) {
        _userRepository = userRepository;
        _adminRepository = adminRepository;
        _commentRepository = commentRepository;
    }

    @Override
    public AdminResponse getAdmin(long id) {
        return null;
    }

    @Override
    public List<AdminResponse> getAllAdmins() {
        return null;
    }

    @Override
    public AdminResponse createAdmin(CreateAdminRequest request) {
        return null;
    }

    @Override
    public AdminResponse updateAdmin(UpdateAdminRequest request, long id) {
        return null;
    }

    @Override
    public void deleteAdmin(long id) {

    }

    @Override
    public void blockUser(long id) {
        User user = _userRepository.findOneById(id);
        user.setBlocked(true);
        _userRepository.save(user);
    }

    @Override
    public void unblockUser(long id) {
        User user = _userRepository.findOneById(id);
        user.setBlocked(false);
        _userRepository.save(user);
    }

    @Override
    public void activateUser(long id) {
        User user = _userRepository.findOneById(id);
        user.setActive(true);
        _userRepository.save(user);
    }

    @Override
    public void deactivateUser(long id) {
        User user = _userRepository.findOneById(id);
        user.setActive(false);
        _userRepository.save(user);
    }

    @Override
    public List<CommentResponse> getAllPendingComments() {
        List<Comment> allComments = _commentRepository.findAll();
        List<Comment> pendingComments = new ArrayList<>();
        for(Comment c: allComments){
            if(c.getState().equals(CommentRequestState.PENDING)){
                pendingComments.add(c);
            }
        }
        List<CommentResponse> commentResponses = new ArrayList<>();
        for(Comment c: pendingComments){
            CommentResponse response = new CommentResponse();
            response.setCommId(c.getId());
            response.setComment(c.getComment());
            commentResponses.add(response);
        }
        return commentResponses;
    }

    @Override
    public CommentResponse approveComment(Long id) {
        Comment comment = _commentRepository.findOneById(id);
        comment.setState(CommentRequestState.APPROVED);
        _commentRepository.save(comment);
        CommentResponse response = new CommentResponse();
        response.setCommId(comment.getId());
        response.setComment(comment.getComment());
        return response;
    }

    @Override
    public CommentResponse denyComment(DenyCommentRequest request) {
        Comment comment = _commentRepository.findOneById(request.getId());
        comment.setState(CommentRequestState.DENIED);
        _commentRepository.save(comment);
        CommentResponse response = new CommentResponse();
        response.setCommId(comment.getId());
        response.setComment(comment.getComment());
        return response;
    }
}
