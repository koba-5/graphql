package apollo.api.todo.data

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoAddRequest(
    @JsonProperty("title") val title: String,
    @JsonProperty("content") val content: String
)
