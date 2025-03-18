package org.example.deepseek_api_test.database.entity

import jakarta.persistence.*


@Entity
@Table(name = "chat")
class Chat(
    @Column(nullable = false)
    val title: String,

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id", nullable = false)
    val user: User
) : AbstractEntity() {
    @OneToMany(
        mappedBy = "chat",
        cascade = [(CascadeType.ALL)],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    val messages: MutableList<Message> = mutableListOf()
}