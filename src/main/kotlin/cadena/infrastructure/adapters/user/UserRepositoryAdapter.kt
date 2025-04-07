package cadena.infrastructure.adapters.user

import cadena.domain.models.UserModel
import cadena.domain.ports.out.UserRepositoryPort
import cadena.infrastructure.repositories.user.UserJpaRepository
import java.util.*

class UserRepositoryAdapter(
    private val userJpaRepository: UserJpaRepository
): UserRepositoryPort {

    override fun saveUser(user: UserModel): UserModel {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: String): UserModel? {
        val userEntity = userJpaRepository.findByEmail(email)
        return userEntity?.toDomain()
    }

    override fun findById(id: UUID): UserModel? {
        val userEntity = userJpaRepository.findById(id).orElse(null)
        return userEntity?.toDomain()
    }
}