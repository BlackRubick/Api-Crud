package com.example.demo.controllers;

import com.example.demo.controllers.dtos.requests.CreateUserRequest;
import com.example.demo.controllers.dtos.requests.UpdateUserRequest;
import com.example.demo.controllers.dtos.responses.BaseResponse;
import com.example.demo.controllers.dtos.responses.CreateUserResponse;
import com.example.demo.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping
    public List<CreateUserResponse> list() {
        return service.list();
    }

    @GetMapping("{id}")
    public BaseResponse get(@PathVariable String id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CreateUserRequest request) {
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @PutMapping("{id}")
    public BaseResponse update(@RequestBody UpdateUserRequest request, @PathVariable String id){
        return service.update(request, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
