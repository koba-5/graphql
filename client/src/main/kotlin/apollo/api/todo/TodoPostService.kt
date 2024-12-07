package apollo.api.todo

import apollo.api.todo.data.TodoAddRequest
import apollo.repository.TodoGraphQLHttpRepository
import autogen.graphql.type.AddTodoInput
import org.springframework.stereotype.Service

@Service
class TodoPostService(private val httpRepository: TodoGraphQLHttpRepository) {

  fun execute(request: TodoAddRequest) {
    val input = AddTodoInput(title = request.title, content = request.content)
    httpRepository.addTodo(input = input)
  }
}
