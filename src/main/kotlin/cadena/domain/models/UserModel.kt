package cadena.domain.models

import java.time.LocalDateTime
import java.util.*

data class UserModel(
    val id: UUID,
    val name: String,
    val email: String,
    val passwordHash: String,
    val role: UserRole,
    val createdAt: LocalDateTime
)

enum class UserRole {
    CITIZEN,
    ADMIN,
    COUNCILOR
}