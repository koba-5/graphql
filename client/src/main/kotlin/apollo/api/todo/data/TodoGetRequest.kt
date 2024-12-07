package apollo.api.todo.data

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoGetRequest(@JsonProperty("id") val id: Int)
