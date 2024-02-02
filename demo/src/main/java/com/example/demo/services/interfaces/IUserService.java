package com.example.demo.services.interfaces;

import com.example.demo.controllers.dtos.requests.CreateUserRequest;
import com.example.demo.controllers.dtos.requests.UpdateUserRequest;
import com.example.demo.controllers.dtos.responses.BaseResponse;
import com.example.demo.controllers.dtos.responses.CreateUserResponse;

import java.util.List;

public interface IUserService {
    BaseResponse create(CreateUserRequest request);

    List<CreateUserResponse> list();

    BaseResponse update(UpdateUserRequest request, String id);

    BaseResponse get(String id);

    void delete(String id);
}
