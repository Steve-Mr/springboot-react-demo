package com.example.demo.service

import com.example.demo.datasource.UserDataSource
import com.example.demo.model.User
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class UserService (
        @Qualifier("test") val userDataSource: UserDataSource
) {

    fun validate(user: User): Boolean{
        print(user)
        return userDataSource.validateUser(user)
    }
}