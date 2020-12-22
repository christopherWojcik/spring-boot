package pl.wojcik.restapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import pl.wojcik.restapi.model.Post;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@WithMockUser
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void shouldGetPost() {
        // given
        // when
        Post post = postService.getSinglePost(1L);
        // then
        assertThat(post).isNotNull();
        assertThat(post.getId()).isEqualTo(1L);
    }
}