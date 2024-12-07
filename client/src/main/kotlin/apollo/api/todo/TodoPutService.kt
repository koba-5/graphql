package apollo.api.todo

import apollo.api.todo.data.TodoUpdateRequest
import apollo.repository.TodoGraphQLHttpRepository
import autogen.graphql.type.UpdateTodoByIdInput
import org.springframework.stereotype.Service

@Service
class TodoPutService(private val httpRepository: TodoGraphQLHttpRepository) {

  fun execute(request: TodoUpdateRequest) {
    val input =
        UpdateTodoByIdInput(id = request.id, title = request.title, content = request.content)
    httpRepository.updateTodoById(input = input)
  }
}
