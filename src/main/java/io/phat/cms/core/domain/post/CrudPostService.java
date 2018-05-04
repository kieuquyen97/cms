package io.phat.cms.core.domain.post;

/**
 *
 * @author phatphan
 *
 */
public interface CrudPostService {
    Object query();
    void save(Post post);
    void archive(String id); // Actually soft-delete action
}
