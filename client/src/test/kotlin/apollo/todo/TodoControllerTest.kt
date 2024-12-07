package apollo.todo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {
  companion object {
    private const val ENDPOINT = "/api/todo"
  }

  @Autowired private lateinit var mockMvc: MockMvc

  @Test
  fun get() {
    /*
     * given
     */
    val request = """{"id": 1}""".trimIndent()

    /*
     * when & then
     */
    mockMvc
        .perform(
            MockMvcRequestBuilders.get(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andReturn()
  }

  @Test
  fun post() {
    /*
     * given
     */
    val request = """{"title": "test", "content": "test"}""".trimIndent()

    /*
     * when & then
     */
    mockMvc
        .perform(
            MockMvcRequestBuilders.post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
        .andExpect(MockMvcResultMatchers.status().isCreated)
        .andReturn()
  }

  @Test
  fun put() {
    /*
     * given
     */
    val request = """{"id": 1, "title": "test", "content": "test"}""".trimIndent()

    /*
     * when & then
     */
    mockMvc
        .perform(
            MockMvcRequestBuilders.put(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
        .andExpect(MockMvcResultMatchers.status().isNoContent)
        .andReturn()
  }

  @Test
  fun delete() {
    /*
     * given
     */
    val request = """{"id": 3}""".trimIndent()

    /*
     * when & then
     */
    mockMvc
        .perform(
            MockMvcRequestBuilders.delete(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
        .andExpect(MockMvcResultMatchers.status().isNoContent)
        .andReturn()
  }
}
