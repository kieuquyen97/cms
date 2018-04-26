package io.phat.cms.domain.taxonomy.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import io.phat.cms.domain.taxonomy.HierarchicalTaxonomyValue;
import io.phat.cms.domain.taxonomy.Taxonomy;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter(AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SimpleHierarchicalTaxonomyValue extends SimpleTaxonomyValue implements HierarchicalTaxonomyValue {

	@OneToMany(targetEntity = SimpleHierarchicalTaxonomyValue.class)
	private Set<HierarchicalTaxonomyValue> children = new HashSet<>();

	public SimpleHierarchicalTaxonomyValue(@NotNull Taxonomy taxonomy, @NotNull String value) {
		super(taxonomy, value);
	}

	@Override
	public Iterable<HierarchicalTaxonomyValue> getChildren() {
		return Collections.unmodifiableSet(children);
	}

	@Override
	public void add(@NotNull HierarchicalTaxonomyValue taxonomy) {
		if (this.equals(taxonomy) || isExistAsSubchild(taxonomy)) {
			return;
		}
		children.add(taxonomy);
	}

	private boolean isExistAsSubchild(HierarchicalTaxonomyValue taxonomy) {
		HierarchicalTaxonomyValue result = this.find(value -> {
			return value.equals(taxonomy);
		});
		return result == null ? false : true;
	}

	@Override
	public void remove(@NotNull HierarchicalTaxonomyValue taxonomy) {
		children.remove(taxonomy);
	}

	@Override
	public HierarchicalTaxonomyValue find(@NotNull Predicate<HierarchicalTaxonomyValue> condition) {
		HierarchicalTaxonomyValue result = null;

		for (HierarchicalTaxonomyValue child : children) {
			if (!condition.test(child)) {
				result = child.find(condition);
			} else {
				return result;
			}
		}
		return result;
	}
}
