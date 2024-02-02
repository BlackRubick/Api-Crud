package com.example.demo.services;

import com.example.demo.controllers.dtos.requests.CreateUserRequest;
import com.example.demo.controllers.dtos.requests.UpdateUserRequest;
import com.example.demo.controllers.dtos.responses.BaseResponse;
import com.example.demo.controllers.dtos.responses.CreateUserResponse;
import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Override
    public BaseResponse create(CreateUserRequest request) {
        User user = from(request);

        return BaseResponse.builder()
                .data(from(repository.save(user)))
                .message("User created correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public List<CreateUserResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    @Override
    public BaseResponse update(UpdateUserRequest request, String id) {
        User user = findOneAndEnsureExist(id);
        user = update(user, request);

        return BaseResponse.builder()
                .data(from(repository.save(user)))
                .message("User updated correctly")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    public User findOneAndEnsureExist(String id) {
        return repository.findUserById(id);
    }

    @Override
    public BaseResponse get(String id) {
        return BaseResponse.builder()
                .data(from(repository.save(findOneAndEnsureExist(id))))
                .message("User found")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.CREATED).build();
    }

    @Override
    public void delete(String id) {
        repository.delete(repository.findUserById(id));
    }

    private User from(CreateUserRequest request){
        User user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFechaRegistro(request.getFechaRegistro());

        return user;
    }

    private CreateUserResponse from(User user){
        CreateUserResponse response = new CreateUserResponse();

        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setFechaEliminacion(user.getFechaEliminacion());
        response.setFechaRegistro(user.getFechaRegistro());

        return response;
    }

    private User update(User user, UpdateUserRequest request){
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFechaRegistro(request.getFechaRegistro());
        user.setFechaEliminacion(request.getFechaEliminacion());

        return user;
    }
}
