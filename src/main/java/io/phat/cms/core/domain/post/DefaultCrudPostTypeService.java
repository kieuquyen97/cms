package io.phat.cms.core.domain.post;

import io.phat.cms.core.repository.PostTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author phatphan
 *
 */
@Service
public class DefaultCrudPostTypeService implements CrudPostTypeService {

    private final PostTypeRepository postTypeRepository;

    @Autowired
    public DefaultCrudPostTypeService(PostTypeRepository postTypeRepository) {
        this.postTypeRepository = postTypeRepository;
    }

    @Override
    public Iterable<PostType> findAll() {
        return postTypeRepository.findAll();
    }
}
