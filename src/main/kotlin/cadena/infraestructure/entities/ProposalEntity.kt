package cadena.infraestructure.entities

import cadena.domain.models.ProposalModel
import cadena.domain.models.ProposalStatus
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "proposals")
data class ProposalEntity(
    @Id val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val createdBy: UserEntity,
    @Enumerated(EnumType.STRING)
    val status: String = "OPEN",
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() =
        ProposalModel(
            id = id,
            title = title,
            description = description,
            createdBy = createdBy.toDomain(),
            status = ProposalStatus.valueOf(status),
            createdAt = createdAt
        )

    companion object {
        fun fromDomain(proposal: ProposalModel) = ProposalEntity(
            id = proposal.id,
            title = proposal.title,
            description = proposal.description,
            createdBy = UserEntity.fromDomain(proposal.createdBy),
            status = proposal.status.name,
            createdAt = proposal.createdAt
        )
    }
}