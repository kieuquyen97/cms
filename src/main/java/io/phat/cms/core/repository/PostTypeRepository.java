package io.phat.cms.core.repository;

import io.phat.cms.core.domain.post.PostType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTypeRepository extends CrudRepository<PostType, String> {
    PostType findByNamedId(String namedId);
}
