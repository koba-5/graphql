package apollo.api.todo

import apollo.api.todo.data.TodoDeleteRequest
import apollo.repository.TodoGraphQLHttpRepository
import autogen.graphql.type.DeleteTodoByIdInput
import org.springframework.stereotype.Service

@Service
class TodoDeleteService(private val httpRepository: TodoGraphQLHttpRepository) {

  fun execute(request: TodoDeleteRequest) {
    val input = DeleteTodoByIdInput(id = request.id)
    httpRepository.deleteTodoById(input = input)
  }
}
