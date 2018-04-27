package io.phat.cms.core.domain.post;

import java.util.HashSet;

import javax.validation.constraints.NotNull;

import io.phat.cms.core.domain.taxonomy.TaxonomyValue;

public class DefaultPostModifier extends DefaultPostBuilder implements PostModifier {

	private Post post;
	
	public DefaultPostModifier(@NotNull Post post) {
		super(post.getPostType());
		this.post = post;
		this.metaData = new HashSet<MetaData>(post.getMetaData());
		this.taxonomyValues = new HashSet<TaxonomyValue>(post.getTaxonomyValues());
	}

	@Override
	public DefaultPostModifier removeTaxonomyValue(TaxonomyValue taxonomyVal) {
		if (this.taxonomyValues.contains(taxonomyVal)) {
			this.taxonomyValues.remove(taxonomyVal);
		}
		return this;
	}
	
	@Override
	public DefaultPostModifier removeMetaData(MetaData data) {
		if (this.metaData.contains(data)) {
			this.metaData.remove(data);
		}
		return this;
	}
	
	@Override
	public Post getPost() {
		post.setUpdateAt();
		post.setTitle(title);
		post.setExcerpt(excerpt);
		post.setContent(content);
		post.setStatus(status);
		post.setTaxonomyValues(taxonomyValues);
		post.setMetaData(metaData);
		return post;
	}
}
