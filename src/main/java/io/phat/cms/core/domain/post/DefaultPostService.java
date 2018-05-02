package io.phat.cms.core.domain.post;

import io.phat.cms.core.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author phatphan
 *
 */
@Service
public class DefaultPostService implements PostService {

    private PostRepository postRepository;

    @Autowired
    public DefaultPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findOne(String id) {
        // TODO: Replace with application exception for easier management purpose
        return postRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Post " + id + " not found"));
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void archive(String id) {
        Post post = this.findOne(id);

        post.delete();
        postRepository.save(post);
    }
}
