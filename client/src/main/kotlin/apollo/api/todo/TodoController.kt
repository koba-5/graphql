package apollo.api.todo

import apollo.api.todo.data.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todo")
class TodoController(
    private val getService: TodoGetService,
    private val postService: TodoPostService,
    private val putService: TodoPutService,
    private val deleteService: TodoDeleteService
) {

  @GetMapping
  fun get(@RequestBody request: TodoGetRequest): TodoGetResponse? {
    return getService.execute(request = request)
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  fun post(@RequestBody request: TodoAddRequest) {
    postService.execute(request = request)
  }

  @PutMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun put(@RequestBody request: TodoUpdateRequest) {
    putService.execute(request = request)
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun delete(@RequestBody request: TodoDeleteRequest) {
    deleteService.execute(request = request)
  }
}
