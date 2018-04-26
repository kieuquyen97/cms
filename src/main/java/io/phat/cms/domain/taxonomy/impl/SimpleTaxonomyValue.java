package io.phat.cms.domain.taxonomy.impl;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import io.phat.cms.domain.AbstractEntity;
import io.phat.cms.domain.taxonomy.Taxonomy;
import io.phat.cms.domain.taxonomy.TaxonomyValue;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"taxonomy", "value"}, callSuper = true)
@ToString(callSuper = true)
public class SimpleTaxonomyValue extends AbstractEntity implements TaxonomyValue {
	
	@ManyToOne
	protected Taxonomy taxonomy;
	
	protected String value;
	
	public SimpleTaxonomyValue(@NotNull Taxonomy taxonomy, @NotNull String value) {
		this.taxonomy = taxonomy;
		this.value = value;
	}

	@Override
	public Taxonomy getTaxonomy() {
		return taxonomy;
	}

	@Override
	public String getValue() {
		return value;
	}

}
