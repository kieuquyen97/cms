package io.phat.cms.core.domain.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author phatphan
 *
 */
public interface PostService {
    Page<Post> findAll(Pageable pageable);
    Post findOne(String id);
    void save(Post post);
    void archive(String id); // Actually soft-delete action
}
