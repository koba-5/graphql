package apollo.todos

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class TodosControllerTest {
  companion object {
    private const val ENDPOINT = "/api/todos"
  }

  @Autowired private lateinit var mockMvc: MockMvc

  @Test
  fun get() {
    /*
     * when & then
     */
    mockMvc
        .perform(MockMvcRequestBuilders.get(ENDPOINT))
        .andExpect(MockMvcResultMatchers.status().isOk)
        .andReturn()
  }
}
