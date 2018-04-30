package io.phat.cms.core.domain.post;

public interface PostTypeRegistryService {
    void registerPostType(PostType postType);
    void registerTaxonomyForPostType(String postTypeNamedId, String taxNamedId);
    boolean isPostTypeRegistered(String namedId);
    PostType findByNamedId(String namedId);
}
