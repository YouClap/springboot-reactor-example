package tech.youclap.example.springboot.repository

import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import tech.youclap.example.springboot.model.User

@Repository
interface UserRepository : R2dbcRepository<User, Int>
