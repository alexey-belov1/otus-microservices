package com.otus.microservices.rest;

import com.otus.microservices.rest.dto.UserDto;
import com.otus.microservices.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        UserDto result = userService.save(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getById(@PathVariable("userId") Integer userId) {
        UserDto result = userService.findById(userId);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(@PathVariable("userId") Integer userId, @RequestBody UserDto dto) {
        UserDto result = userService.update(userId, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable int userId) {
        this.userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}
