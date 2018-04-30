package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.taxonomy.TaxonomyValue;

import javax.validation.constraints.NotNull;

/**
 *
 * @author phatphan
 *
 */
public interface PostModifier extends PostBuilder {
	DefaultPostModifier removeTaxonomyValue(@NotNull TaxonomyValue taxonomyVal);
	DefaultPostModifier removeMetaData(@NotNull MetaData data);
}
