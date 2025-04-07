package cadena.domain.ports.out

import cadena.domain.models.UserModel
import java.util.*

interface UserRepositoryPort {
    fun saveUser(user: UserModel): UserModel
    fun findByEmail(email: String): UserModel?
    fun findById(id: UUID): UserModel?
}