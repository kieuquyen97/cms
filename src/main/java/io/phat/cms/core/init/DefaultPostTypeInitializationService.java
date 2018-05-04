package io.phat.cms.core.init;

import io.phat.cms.core.domain.post.PostType;
import io.phat.cms.core.domain.post.PostTypeRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Order(1)
public class DefaultPostTypeInitializationService implements InitializableService {

    private final PostTypeRegistryService postTypeRegistryService;

    @Autowired
    public DefaultPostTypeInitializationService(PostTypeRegistryService postTypeRegistryService) {
        this.postTypeRegistryService = postTypeRegistryService;
    }

    @Transactional
    public void init() {
        PostType postType = new PostType("cms-pt-post");
        postTypeRegistryService.registerPostType(postType);
        postTypeRegistryService.registerTaxonomyForPostType("cms-pt-post", "cms-tx-category");
        postTypeRegistryService.registerTaxonomyForPostType("cms-pt-post", "cms-tx-tag");
    }
}