package io.phat.cms.domain.taxonomy.impl;

import io.phat.cms.domain.taxonomy.Taxonomy;
import io.phat.cms.domain.taxonomy.TaxonomyValue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleTaxonomyFactory {

	public static TaxonomyValue create(Taxonomy taxonomy, String value) {
		if (taxonomy.isHierarchy()) {
			return new SimpleHierarchicalTaxonomyValue(taxonomy, value); 
		}
		return new SimpleTaxonomyValue(taxonomy, value);
	}
}
