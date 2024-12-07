package apollo.api.todo

import apollo.api.todo.data.TodoGetRequest
import apollo.api.todo.data.TodoGetResponse
import apollo.repository.TodoGraphQLHttpRepository
import autogen.graphql.type.GetTodoByIdInput
import org.springframework.stereotype.Service

@Service
class TodoGetService(private val httpRepository: TodoGraphQLHttpRepository) {

  fun execute(request: TodoGetRequest): TodoGetResponse? {
    val input = GetTodoByIdInput(id = request.id)
    val res = httpRepository.getTodoById(input = input)

    return res?.let { TodoGetResponse(id = it.id, title = it.title, content = it.content) }
  }
}
