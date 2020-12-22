package pl.wojcik.restapi.model;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.wojcik.restapi.repository.CommentRepository;
import pl.wojcik.restapi.repository.PostRepository;


@Component
@AllArgsConstructor
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    PostRepository postRepository;
    CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
