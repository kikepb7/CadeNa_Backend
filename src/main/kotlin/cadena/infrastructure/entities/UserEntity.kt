package cadena.infrastructure.entities

import cadena.domain.models.UserModel
import cadena.domain.models.UserRole
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id val id: UUID = UUID.randomUUID(),
    val name: String,
    val email: String,
    val passwordHash: String,
    @Enumerated(EnumType.STRING)
    val role: String = "CITIZEN",
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() =
        UserModel(
            id = id,
            name = name,
            email = email,
            passwordHash = passwordHash,
            role = UserRole.valueOf(role),
            createdAt = createdAt
        )

    companion object {
        fun fromDomain(user: UserModel) = UserEntity(
            id = user.id,
            name = user.name,
            email = user.email,
            passwordHash = user.passwordHash,
            role = user.role.name,
            createdAt = user.createdAt
        )
    }
}