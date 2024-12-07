package apollo.repository

import apollo.framework.errors.SystemException
import apollo.framework.errors.TodoGraphQLException
import autogen.graphql.*
import autogen.graphql.type.*
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.ApolloResponse
import com.apollographql.apollo.api.Operation
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Repository

@Repository
@ConditionalOnProperty(prefix = "env.graphql", name = ["mock-level"], havingValue = "real")
class TodoGraphQLHttpRepositoryImpl(
    @Value("\${env.graphql.endpoint}") private val endpoint: String
) : TodoGraphQLHttpRepository {
  private val apolloClient = ApolloClient.Builder().serverUrl(endpoint).build()

  override fun getTodos(): List<GetTodosQuery.GetTodo> {
    val res = runBlocking { apolloClient.query(GetTodosQuery()).execute() }
    return handleApolloResponse(res = res).getTodos
  }

  override fun getTodoById(input: GetTodoByIdInput): GetTodoByIdQuery.GetTodoById {
    val res = runBlocking { apolloClient.query(GetTodoByIdQuery(input = input)).execute() }
    return handleApolloResponse(res = res).getTodoById
  }

  override fun addTodo(input: AddTodoInput) {
    val res = runBlocking { apolloClient.mutation(AddTodoMutation(input = input)).execute() }
    handleApolloResponse(res = res)
  }

  override fun updateTodoById(input: UpdateTodoByIdInput) {
    val res = runBlocking { apolloClient.mutation(UpdateTodoByIdMutation(input = input)).execute() }
    handleApolloResponse(res = res)
  }

  override fun deleteTodoById(input: DeleteTodoByIdInput) {
    val res = runBlocking { apolloClient.mutation(DeleteTodoByIdMutation(input = input)).execute() }
    handleApolloResponse(res = res)
  }

  private fun <T : Operation.Data> handleApolloResponse(res: ApolloResponse<T>): T {
    val data = res.data
    val exception = res.exception
    val errors = res.errors
    if (data != null) {
      return data
    } else if (exception != null) {
      throw TodoGraphQLException(message = "`exception`が発生しました${exception}`")
    } else if (!errors.isNullOrEmpty()) {
      throw TodoGraphQLException(message = "${errors.size}件の`error`が発生しました${errors}`")
    } else {
      throw SystemException(message = "予期せぬエラーが発生しました")
    }
  }
}
