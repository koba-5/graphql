package apollo.api.todo.data

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoGetResponse(
    @JsonProperty("id") val id: Int,
    @JsonProperty("title") val title: String,
    @JsonProperty("content") val content: String
)
