package apollo.api.todos.data

import com.fasterxml.jackson.annotation.JsonProperty

data class TodosGetResponse(
    @JsonProperty("id") val id: Int,
    @JsonProperty("title") val title: String,
    @JsonProperty("content") val content: String
)
