package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.post.Post.Status;
import io.phat.cms.core.domain.taxonomy.TaxonomyValue;
import io.phat.cms.core.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author phatphan
 *
 */
public class DefaultPostBuilder implements PostBuilder {
	
	protected PostType postType;
	protected Set<MetaData> metaData = new HashSet<>();
	protected Set<TaxonomyValue> taxonomyValues = new HashSet<>();
	protected User user;
	protected String title;
	protected String excerpt;
	protected String content;
	protected Status status = Status.DRAFT;
	
	public DefaultPostBuilder(@NotNull PostType postType) {
		this.postType = postType;
	}

	@Override
	public PostBuilder addMetaData(@NotNull MetaData data) {
		metaData.add(data);
		return this;
	}
	
	@Override
	public PostBuilder addTaxonomyValue(@NotNull TaxonomyValue taxonomyValue) {
		this.taxonomyValues.add(taxonomyValue);
		return this;
	}
	
	@Autowired
	public PostBuilder createdBy(@NotNull User user) {
		this.user = user;
		return this;
	}

	@Override
	public PostBuilder setTitle(@NotNull String title) {
		this.title = title;
		return this;
	}

	@Override
	public PostBuilder setExcerpt(@NotNull String excerpt) {
		this.excerpt = excerpt;
		return this;
	}

	@Override
	public PostBuilder setContent(@NotNull String content) {
		this.content = content;
		return this;
	}
	
	@Override
	public PostBuilder setStatus(@NotNull Status status) {
		this.status = status;
		return this;
	}

	@Override
	public Post getPost() {
		Post post = new Post();
		post.setPostType(postType);
		post.setMetaData(metaData);
		post.setTaxonomyValues(taxonomyValues);
		post.setUser(user);
		post.setTitle(title);
		post.setExcerpt(excerpt);
		post.setContent(content);
		post.setStatus(status);
		return post;
	}
}
