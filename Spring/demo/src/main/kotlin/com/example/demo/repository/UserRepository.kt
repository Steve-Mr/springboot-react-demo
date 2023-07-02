package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Int> {

    fun findUserByUsername(username: String): User?
}