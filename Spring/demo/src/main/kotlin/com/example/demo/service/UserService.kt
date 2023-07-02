package com.example.demo.service

import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class UserService (
        @Qualifier("user") val userRepository: UserRepository
) {

    fun validate(user: User): String{
        print(user)
        val foundUser = userRepository.findUserByUsername(user.username)
        if (foundUser?.password == user.password) return "true"
        else return "false"
    }
}