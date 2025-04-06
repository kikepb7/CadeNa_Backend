package cadena.domain.models

import java.time.LocalDateTime
import java.util.UUID

data class VoteModel(
    val id: UUID,
    val proposalModel: ProposalModel,
    val userModel: UserModel,
    val voteValue: Boolean,
    val txHash: String,
    val createdAt: LocalDateTime
)