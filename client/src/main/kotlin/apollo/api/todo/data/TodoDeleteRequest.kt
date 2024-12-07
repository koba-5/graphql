package apollo.api.todo.data

import com.fasterxml.jackson.annotation.JsonProperty

data class TodoDeleteRequest(@JsonProperty("id", required = true) val id: Int)
