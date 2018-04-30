package io.phat.cms.core.domain.taxonomy;

import io.phat.cms.core.domain.AbstractEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"taxonomy", "value"}, callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class DefaultTaxonomyValue extends AbstractEntity implements TaxonomyValue {

    @ManyToOne
    protected Taxonomy taxonomy;

    protected String value;

    DefaultTaxonomyValue(@NotNull Taxonomy taxonomy, @NotNull String value) {
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
