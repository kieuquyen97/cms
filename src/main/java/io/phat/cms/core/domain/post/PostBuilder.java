package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.post.Post.Status;
import io.phat.cms.core.domain.taxonomy.TaxonomyValue;
import io.phat.cms.core.domain.user.User;

import javax.validation.constraints.NotNull;

/**
 * 
 * @author phatphan
 *
 */
public interface PostBuilder {
	PostBuilder addMetaData(@NotNull MetaData data);
	PostBuilder addTaxonomyValue(@NotNull TaxonomyValue taxonomyValue);
	PostBuilder createdBy(@NotNull User user);
	PostBuilder setTitle(@NotNull String title);
	PostBuilder setExcerpt(@NotNull String excerpt);
	PostBuilder setContent(@NotNull String content);
	PostBuilder setStatus(@NotNull Status status);
	Post getPost();
}
