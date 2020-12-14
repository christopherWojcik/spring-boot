package pl.wojcik.restapi.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.wojcik.restapi.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comment")
    // INNER JOIN will cause situation where we get only posts which have comments
    // above query gets all data and cuts in app memory - unwanted scenario
    // log from hibernate:
    //               e.g.: HHH000104: firstResult/maxResults specified with collection fetch; applying in memory!
    // N + 1 problem doesn't occur but memory efficiency/performance is unacceptable
    // fetch is keyword to get related entity in spring data
    @Query("SELECT p FROM Post p")
    List<Post> findAllPosts(Pageable page);

}
