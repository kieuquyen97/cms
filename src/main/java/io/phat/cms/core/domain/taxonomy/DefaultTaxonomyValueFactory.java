package io.phat.cms.core.domain.taxonomy;

import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultTaxonomyValueFactory {

	public static TaxonomyValue create(@NotNull Taxonomy taxonomy, String value) {
		if (taxonomy.isHierarchy()) {
			return new DefaultHierarchicalTaxonomyValue(taxonomy, value); 
		}
		return new DefaultTaxonomyValue(taxonomy, value);
	}
}
