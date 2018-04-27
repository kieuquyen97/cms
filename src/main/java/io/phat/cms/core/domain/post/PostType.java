package io.phat.cms.core.domain.post;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import io.phat.cms.core.domain.AbstractEntity;
import io.phat.cms.core.domain.taxonomy.Taxonomy;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author phatphan
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "namedId", callSuper = true)
@ToString(callSuper = true)
public class PostType extends AbstractEntity {

	@Column(unique = true)
	private String namedId;
	
	private String name;
	
	@OneToMany
	private Set<Taxonomy> taxonomies = new HashSet<>();
	
	public PostType(String namedId, String name) {
		this.namedId = namedId;
		this.name = name;
	}
	
	public void registerTaxonomy(Taxonomy taxonomy) {
		this.taxonomies.add(taxonomy);
	}
	
	public boolean isTaxonomyRegistered(Taxonomy taxonomy) {
		return this.taxonomies.contains(taxonomy);
	}
	
	public Iterable<Taxonomy> getTaxonomies() {
		return Collections.unmodifiableSet(taxonomies);
	}
}
