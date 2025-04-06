package cadena.domain.models

import java.time.LocalDateTime
import java.util.UUID

data class ProposalModel(
    val id: UUID,
    val title: String,
    val description: String,
    val createdBy: UserModel,
    val status: ProposalStatus,
    val createdAt: LocalDateTime
)

enum class ProposalStatus {
    OPEN,
    CLOSED,
    PENDING_VERIFICATION,
    APPROVED,
    REJECTED
}