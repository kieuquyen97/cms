package io.phat.cms.core.repository;

import io.phat.cms.core.domain.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, String> {
}
