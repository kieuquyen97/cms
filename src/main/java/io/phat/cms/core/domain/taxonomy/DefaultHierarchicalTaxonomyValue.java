package io.phat.cms.core.domain.taxonomy;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter(AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DefaultHierarchicalTaxonomyValue extends DefaultTaxonomyValue implements HierarchicalTaxonomyValue {

	@OneToMany(targetEntity = DefaultHierarchicalTaxonomyValue.class)
	private Set<HierarchicalTaxonomyValue> children = new HashSet<>();

	public DefaultHierarchicalTaxonomyValue(@NotNull Taxonomy taxonomy, @NotNull String value) {
		super(taxonomy, value);
	}

	@Override
	public Collection<HierarchicalTaxonomyValue> getChildren() {
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
