package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.AbstractEntity;
import io.phat.cms.core.domain.taxonomy.Taxonomy;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author phatphan
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "namedId", callSuper = true)
@ToString(callSuper = true)
public class PostType extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String namedId;

    private String name;

    private String description;

    @OneToMany
    private Set<Taxonomy> taxonomies = new HashSet<>();

    public PostType(@NotBlank String namedId, @NotNull String name, @NotNull String description) {
        this.namedId = namedId;
        this.name = name;
        this.description = description;
    }

    void registerTaxonomy(@NotNull Taxonomy taxonomy) {
        this.taxonomies.add(taxonomy);
    }

    public boolean isTaxonomyRegistered(@NotNull Taxonomy taxonomy) { return this.taxonomies.contains(taxonomy); }

    public Collection<Taxonomy> getTaxonomies() {
        return Collections.unmodifiableSet(taxonomies);
    }
}
