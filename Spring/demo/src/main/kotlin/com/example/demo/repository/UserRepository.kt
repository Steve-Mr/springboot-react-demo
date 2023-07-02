package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository("user")
interface UserRepository: CrudRepository<User, Int> {

    fun findUserByUsername(username: String): User?
}