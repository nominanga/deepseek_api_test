package org.example.deepseek_api_test.database.entity

import jakarta.persistence.*


@Entity
@Table(name = "`user`")
class User(
    @Column(unique = true, nullable = false, updatable = false)
    val email: String,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,

    @Column(name="password", nullable = false)
    var passwordHash: String
) : AbstractEntity() {
    @OneToMany(
        mappedBy = "user",
        cascade = [(CascadeType.ALL)],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    val chats: MutableList<Chat> = mutableListOf()
}