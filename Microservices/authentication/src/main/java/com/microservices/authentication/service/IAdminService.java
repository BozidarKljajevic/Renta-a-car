package com.microservices.authentication.service;

import com.microservices.authentication.dto.request.AgentRequest;
import com.microservices.authentication.dto.request.GetIdRequest;
import com.microservices.authentication.dto.response.AgentResponse;
import com.microservices.authentication.dto.response.RegistrationResponse;

import java.util.List;

public interface IAdminService {

    void approveRegistration(GetIdRequest request);

    void denyRegistration(GetIdRequest request);

    List<RegistrationResponse> getAllPendingRegistrations();

    List<RegistrationResponse> getAllApprovedRegistrations();

    AgentResponse registerAgent(AgentRequest request);

    void blockUser(GetIdRequest request);

    void unblockUser(GetIdRequest request);
}
