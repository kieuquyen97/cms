package io.phat.cms.core.domain.taxonomy;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 *
 * @author phatphan
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DefaultTaxonomyValueFactory {

	public static <T extends TaxonomyValue> T create(@NotNull Taxonomy taxonomy, @NotNull String value) {
		if (taxonomy.isHierarchy()) {
			return (T) new DefaultHierarchicalTaxonomyValue(taxonomy, value);
		}
		return (T) new DefaultTaxonomyValue(taxonomy, value);
	}
}
