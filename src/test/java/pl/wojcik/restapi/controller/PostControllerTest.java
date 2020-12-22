package pl.wojcik.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.wojcik.restapi.model.Post;
import pl.wojcik.restapi.repository.PostRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PostRepository postRepository;

    @Test
    @Transactional
    void shouldGetSinglePost() throws Exception {
        // given
        Post newPost = new Post();
        newPost.setTitle("Test");
        newPost.setContent("Test content ...");
        newPost.setCreated(LocalDateTime.now());
        postRepository.save(newPost);

        // when
        MvcResult mvcResult = mockMvc.perform(get("/posts/" + newPost.getId()))
                .andDo(print())
                .andExpect(status().is(200))
                // $ means returned object - e.g. $.id means id of returned object
                // jsonPath - good for simple uri
                // jsonPath - bad due to String uses as a path
                // .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andReturn();
        // then
        Post post = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Post.class);

        assertThat(post).isNotNull();
        assertThat(post.getId()).isEqualTo(newPost.getId());
        assertThat(post.getTitle()).isEqualTo(newPost.getTitle());
    }
}