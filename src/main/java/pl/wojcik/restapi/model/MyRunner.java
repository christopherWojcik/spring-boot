package pl.wojcik.restapi.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.wojcik.restapi.repository.CommentRepository;
import pl.wojcik.restapi.repository.PostRepository;


@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Init posts in DB.");
        logger.info("Init comments in DB.");
        logger.info("RUNNER :: Runner is working.");
    }
}
