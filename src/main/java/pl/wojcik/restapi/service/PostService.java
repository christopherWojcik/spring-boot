package pl.wojcik.restapi.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.wojcik.restapi.model.Post;
import pl.wojcik.restapi.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    public static final int PAGE_SIZE = 5;
    private final PostRepository postRepository;

    public List<Post> getPosts(int page){
        return postRepository.findAllPosts(PageRequest.of(page, PAGE_SIZE));
    }

    public Post getSinglePost(long id) {
        return postRepository.findById(id).orElseThrow();
    }
}
