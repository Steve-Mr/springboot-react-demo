package com.example.demo.controller

import com.example.demo.model.User
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController(
        private val userService: UserService
) {

    @GetMapping("hello")
    fun hello(): String{
        return "hello"
    }

    @PostMapping("login")
    fun login(@RequestBody user: User): String {
        return userService.validate(user)
    }
}