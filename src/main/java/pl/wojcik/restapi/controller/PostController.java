package pl.wojcik.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.wojcik.restapi.model.Post;
import pl.wojcik.restapi.model.dto.PostDto;
import pl.wojcik.restapi.model.mapper.PostDtoMapper;
import pl.wojcik.restapi.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPosts(@RequestParam(required = false) int page) {
        int pageNumber = page >= 0 ? page : 0;
        return PostDtoMapper.mapToPostDtos(postService.getPosts(pageNumber));
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id) {
        return postService.getSinglePost(id);
    }
}
