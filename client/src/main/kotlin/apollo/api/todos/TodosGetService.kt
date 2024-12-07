package apollo.api.todos

import apollo.api.todos.data.TodosGetResponse
import apollo.repository.TodoGraphQLHttpRepository
import org.springframework.stereotype.Service

@Service
class TodosGetService(private val httpRepository: TodoGraphQLHttpRepository) {

  fun execute(): List<TodosGetResponse> {
    val res = httpRepository.getTodos()

    return res.map { TodosGetResponse(id = it.id, title = it.title, content = it.content) }
  }
}
