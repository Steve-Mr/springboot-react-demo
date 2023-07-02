package com.example.demo.datasource.impl

import com.example.demo.datasource.UserDataSource
import com.example.demo.model.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Repository

@Repository("test")
class UserFromSql(
        val userRepository: UserRepository
): UserDataSource {
    override fun getUser(): User {
        TODO("Not yet implemented")
    }

    override fun validateUser(user: User): Boolean {

        val foundUser = userRepository.findUserByUsername(user.username)
        return foundUser?.password == user.password
    }
}