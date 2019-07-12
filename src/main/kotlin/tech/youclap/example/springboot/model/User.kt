package tech.youclap.example.springboot.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table
data class User(

    @Id
    val id: Int?,

    @Column("displayName")
    val displayName: String,

    val username: String

)

// TODO maybe we could use `inline class UserID(val id: Int)` 🤔
