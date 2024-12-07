package apollo.api.todos

import apollo.api.todos.data.TodosGetResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/todos")
class TodosController(private val getService: TodosGetService) {

  @GetMapping
  fun get(): List<TodosGetResponse> {
    return getService.execute()
  }
}
