package apollo.repository

import autogen.graphql.*
import autogen.graphql.type.*
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository

@Repository
@ConditionalOnProperty(prefix = "env.graphql", name = ["mock-level"], havingValue = "mock")
class TodoGraphQLHttpRepositoryMock : TodoGraphQLHttpRepository {

  override fun getTodos(): List<GetTodosQuery.GetTodo> {
    return listOf()
  }

  override fun getTodoById(input: GetTodoByIdInput): GetTodoByIdQuery.GetTodoById? {
    return null
  }

  override fun addTodo(input: AddTodoInput) {}

  override fun updateTodoById(input: UpdateTodoByIdInput) {}

  override fun deleteTodoById(input: DeleteTodoByIdInput) {}
}
