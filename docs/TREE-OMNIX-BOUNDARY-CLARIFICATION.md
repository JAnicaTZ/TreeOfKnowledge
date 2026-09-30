# TREE–OMNIX boundary clarification (proposed)

**Status:** Working note for Ana and Harold to review. It describes a proposed interface and does not claim an implemented TREE–OMNIX integration or native runtime interoperability. See the [preliminary viability assessment](../PRELIMINARY-VIABILITY-AND-SUCCESS-PROBABILITY-ASSESSMENT-1.md), especially sections 4.4, 6.1, 11 and 14.

## Logical conditions in TREE

Additional domain, authority or governance conditions can, in principle, be represented as explicit premises and rules and combined with logical conjunction (`AND`, `∧`). For example, a model could examine `reasoning_valid ∧ authority_asserted ∧ mandate_current ∧ scope_matches`. TREE may determine what follows **under those supplied premises and rules**. Adding conjuncts does not itself authenticate their real-world truth, freshness, provenance or legal effect. A condition that is missing, disputed or unresolved must not silently be treated as true. The exact logic and implementation capabilities for such a scenario remain to be specified and tested.

## Proposed responsibility boundary

| Step | Proposed responsibility | Boundary |
|---|---|---|
| Reason | TREE evaluates logical consequences within its defined scope. | A proposed interface might report `ELIGIBLE_FOR_AUTHORIZATION_REVIEW`, `NOT_ELIGIBLE` or `UNDETERMINED`; these are proposed outcome semantics, not established outputs of the current software. TREE does not issue `AUTHORIZED` as an execution grant. |
| Determine admissibility | OMNIX independently tests the proposed action against the relevant authority and governance state. | Admissibility alone does not confer the underlying authority. Harold should review OMNIX fields and decision language. |
| Authorize or deny | The designated authority or separately governed authorization mechanism records the decision. | This step is not performed by TREE merely because a logical conclusion follows. |
| Execute or remain closed | Any execution component acts only under its own validated grant and limits; otherwise the action stays closed. | A logically valid result with missing or unresolved authority is a useful `remain closed` test. |
| Anchor and verify | SignalLink may record premises, reasoning trace, proposed action, authority assertion, determination, timestamp and evidence references in a synthetic provenance example. | A matching digest establishes integrity of specified bytes, not the truth or legal sufficiency of their contents. |

The sequence `Propose → Reason → Determine Admissibility → Authorize or Deny → Execute or Remain Closed → Anchor → Verify` is a **proposed architecture**, not a report of completed integration.

## Minimum information contract

Any minimum TREE-to-OMNIX fields remain **proposed**. Before calling a contract frozen or validated, map each field and outcome to implemented capabilities, define responsibility for the source and freshness of each premise, and obtain independent review and confirmation. A synthetic example can test the boundary without demonstrating a native OMNIX or TREE runtime integration.
