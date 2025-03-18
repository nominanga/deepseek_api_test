package org.example.deepseek_api_test.database.entity

import jakarta.persistence.*

@Entity
@Table(name = "message")
class Message(
    @Column(name = "is_ai")
    val isAi: Boolean = false,

    @Column(nullable = false)
    val body: String,

    @ManyToOne(optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    val chat: Chat,

    @OneToOne
    @JoinColumn(name="response_to", unique = true, referencedColumnName = "id")
    val responseTo: Message? = null
) : AbstractEntity() {

}