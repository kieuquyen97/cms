package io.phat.cms.core.config;

import io.phat.cms.core.domain.post.PostType;
import io.phat.cms.core.domain.post.PostTypeRegistryService;
import io.phat.cms.core.domain.taxonomy.Taxonomy;
import io.phat.cms.core.domain.taxonomy.TaxonomyRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultCmsSetup {

    private final PostTypeRegistryService postTypeRegistryService;
    private final TaxonomyRegistryService taxonomyRegistryService;

    @Autowired
    public DefaultCmsSetup(PostTypeRegistryService postTypeRegistryService,
                           TaxonomyRegistryService taxonomyRegistryService) {
        this.postTypeRegistryService = postTypeRegistryService;
        this.taxonomyRegistryService = taxonomyRegistryService;
    }

    public void init() {
        initTaxonomy();
        initPostType();
    }

    private void initPostType() {
        PostType ptPost = new PostType("cms-pt-post", "Post", "Default post provided by your lovely cms");
        postTypeRegistryService.registerPostType(ptPost);
        postTypeRegistryService.registerTaxonomyForPostType("cms-pt-post", "cms-tax-category");
        postTypeRegistryService.registerTaxonomyForPostType("cms-pt-post", "cms-tax-tag");
    }

    private void initTaxonomy() {
        Taxonomy taxCategory = new Taxonomy("cms-tax-category", "Category",
                "Categorize your post with love.", true);
        Taxonomy taxTag = new Taxonomy("cms-tax-tag", "Tag",
                "Tag your post for easier organizing your content.", false);

        taxonomyRegistryService.registerTaxonomy(taxTag);
        taxonomyRegistryService.registerTaxonomy(taxCategory);
    }
}
