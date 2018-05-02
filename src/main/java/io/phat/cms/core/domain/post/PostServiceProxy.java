package io.phat.cms.core.domain.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author phatphan
 *
 * Intercept {@link PostService} action, allow user to pre/post handle post data
 */
@Service
public class PostServiceProxy implements PostService {

    private final PostService postService;
    private final PostServiceSubject postServiceSubject;

    @Autowired
    public PostServiceProxy(PostServiceSubject postServiceSubject,
                            @Qualifier("defaultPostService") PostService postService) {
        this.postService = postService;
        this.postServiceSubject = postServiceSubject;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postService.findAll(pageable);
    }

    @Override
    public Post findOne(String id) {
        return postService.findOne(id);
    }

    // TODO: Raise event pre/post save action
    @Override
    public void save(Post post) {
        postService.save(post);
    }

    // TODO: Raise event pre/post archive action
    @Override
    public void archive(String id) {
        postService.archive(id);
    }
}
