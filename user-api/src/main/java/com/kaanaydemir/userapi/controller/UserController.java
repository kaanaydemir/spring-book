package com.kaanaydemir.userapi.controller;

import com.kaanaydemir.userapi.dto.UserDto;
import com.kaanaydemir.userapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Long> saveUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/addBookToReadList/{userId}/{bookId}")
    public ResponseEntity<String> addBookToReadList(@PathVariable Long userId,@PathVariable Long bookId) {
        userService.addBookToReadList(userId,bookId);
        return ResponseEntity.ok("Book added to read list.");
    }

}
