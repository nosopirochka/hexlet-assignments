package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import org.springframework.http.MediaType;

import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.junit.jupiter.Container;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.print.attribute.standard.Media;

@SpringBootTest
@AutoConfigureMockMvc

// BEGIN
@Testcontainers
@Transactional
// END
public class AppTest {

    @Autowired
    private MockMvc mockMvc;

    // BEGIN
    @Container
    private static PostgreSQLContainer<?> db = new PostgreSQLContainer<>("postgres")
            .withDatabaseName("databasename")
            .withUsername("user")
            .withPassword("user")
            .withInitScript("init.sql");

    @DynamicPropertySource
    private static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", db::getJdbcUrl);
        registry.add("spring.datasource.username", db::getUsername);
        registry.add("spring.datasource.password", db::getPassword);
    }

    @Test
    void testGetPeople() throws Exception {
//        var person1 = post("/people")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"firstName\":\"Mico\", \"lastname\": \"Cico\"}");
//        var person2 = post("/people")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"firstName\":\"Poco\", \"lastname\": \"Noco\"}");
//        mockMvc.perform(person1);
//        mockMvc.perform(person2);

        var req = mockMvc.perform(get("/people")).andReturn().getResponse();
        assertThat(req.getStatus()).isEqualTo(200);
        assertThat(req.getContentAsString()).contains("John", "Jack", "Simpson", "Lock");
    }

    @Test
    void testGetPerson() throws Exception {
        var req = mockMvc.perform(get("/people/1")).andReturn().getResponse();
        assertThat(req.getContentAsString()).contains("John", "Smith");
    }

    @Test
    void testUpdatePerson() throws Exception {
        var req = mockMvc.perform(patch("/people/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"NewName\"}")).andReturn().getResponse();
        assertThat(req.getStatus()).isEqualTo(200);

        var req1 = mockMvc.perform(get("/people/1")).andReturn().getResponse();
        assertThat(req1.getContentAsString()).contains("NewName");
    }

    @Test
    void testDeletePerson() throws Exception {
        var req = mockMvc.perform(delete("/people/1")).andReturn().getResponse();
        assertThat(req.getStatus()).isEqualTo(200);

        var req1 = mockMvc.perform(get("/people")).andReturn().getResponse();
        assertThat(req1.getContentAsString()).doesNotContain("John", "Smith");
    }
    // END

    @Test
    void testCreatePerson() throws Exception {
        MockHttpServletResponse responsePost = mockMvc
            .perform(
                post("/people")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"firstName\": \"Jackson\", \"lastName\": \"Bind\"}")
            )
            .andReturn()
            .getResponse();

        assertThat(responsePost.getStatus()).isEqualTo(200);

        MockHttpServletResponse response = mockMvc
            .perform(get("/people"))
            .andReturn()
            .getResponse();

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.getContentType()).isEqualTo(MediaType.APPLICATION_JSON.toString());
        assertThat(response.getContentAsString()).contains("Jackson", "Bind");
    }
}
