package apollo.repository

import autogen.graphql.GetTodoByIdQuery
import autogen.graphql.GetTodosQuery
import autogen.graphql.type.*

interface TodoGraphQLHttpRepository {
  fun getTodos(): List<GetTodosQuery.GetTodo>

  fun getTodoById(input: GetTodoByIdInput): GetTodoByIdQuery.GetTodoById?

  fun addTodo(input: AddTodoInput)

  fun updateTodoById(input: UpdateTodoByIdInput)

  fun deleteTodoById(input: DeleteTodoByIdInput)
}
