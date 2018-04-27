package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.post.Post.Status;
import io.phat.cms.core.domain.taxonomy.TaxonomyValue;
import io.phat.cms.core.domain.user.User;

/**
 * 
 * @author phatphan
 *
 */
public interface PostBuilder {
	PostBuilder addMetaData(MetaData data);
	PostBuilder addTaxonomyValue(TaxonomyValue taxonomyValue);
	PostBuilder createdBy(User user);
	PostBuilder setTitle(String title);
	PostBuilder setExcerpt(String excerpt);
	PostBuilder setContent(String content);
	PostBuilder setStatus(Status status);
	Post getPost();
}
