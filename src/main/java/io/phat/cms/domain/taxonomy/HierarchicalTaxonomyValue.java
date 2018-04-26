package io.phat.cms.domain.taxonomy;

import java.util.function.Predicate;

public interface HierarchicalTaxonomyValue extends TaxonomyValue {
	Iterable<HierarchicalTaxonomyValue> getChildren();
	void add(HierarchicalTaxonomyValue taxonomy);
	void remove(HierarchicalTaxonomyValue taxonomy);
	HierarchicalTaxonomyValue find(Predicate<HierarchicalTaxonomyValue> condition);
}