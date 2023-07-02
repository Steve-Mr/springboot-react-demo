package com.example.demo.datasource

import com.example.demo.model.User

interface UserDataSource {

    fun getUser(): User

    fun validateUser(user: User): Boolean
}