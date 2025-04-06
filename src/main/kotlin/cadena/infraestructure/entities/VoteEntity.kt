package cadena.infraestructure.entities

import cadena.domain.models.VoteModel
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "votes")
data class VoteEntity(
    @Id val id: UUID = UUID.randomUUID(),
    @ManyToOne
    @JoinColumn(name = "proposal_id")
    val proposalEntity: ProposalEntity,
    @ManyToOne
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,
    val voteValue: Boolean,
    val txHash: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun toDomain() =
        VoteModel(
            id = id,
            proposalModel = proposalEntity.toDomain(),
            userModel = userEntity.toDomain(),
            voteValue = voteValue,
            txHash = txHash,
            createdAt = createdAt
        )

    companion object {
        fun fromDomain(vote: VoteModel) = VoteEntity(
            id = vote.id,
            proposalEntity = ProposalEntity.fromDomain(vote.proposalModel),
            userEntity = UserEntity.fromDomain(vote.userModel),
            voteValue = vote.voteValue,
            txHash = vote.txHash,
            createdAt = vote.createdAt
        )
    }
}