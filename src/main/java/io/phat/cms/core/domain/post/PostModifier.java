package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.taxonomy.TaxonomyValue;

public interface PostModifier extends PostBuilder {
	DefaultPostModifier removeTaxonomyValue(TaxonomyValue taxonomyVal);
	DefaultPostModifier removeMetaData(MetaData data);
}
