package io.phat.cms.core.domain.taxonomy;

import javax.validation.constraints.NotNull;
import java.util.function.Predicate;

public interface HierarchicalTaxonomyValue extends TaxonomyValue {
	Iterable<HierarchicalTaxonomyValue> getChildren();
	void add(@NotNull HierarchicalTaxonomyValue taxonomy);
	void remove(@NotNull HierarchicalTaxonomyValue taxonomy);
	HierarchicalTaxonomyValue find(@NotNull Predicate<HierarchicalTaxonomyValue> condition);
}