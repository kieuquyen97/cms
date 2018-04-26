package io.phat.cms.domain.post;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.phat.cms.domain.SoftDeleteableEntity;
import io.phat.cms.domain.taxonomy.TaxonomyValue;
import io.phat.cms.domain.taxonomy.impl.SimpleTaxonomyValue;
import io.phat.cms.domain.user.User;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author phanphat
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Post extends SoftDeleteableEntity {

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String excerpt;

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private ZonedDateTime createdAt;

	@Column(nullable = true)
	@Setter(AccessLevel.PUBLIC)
	private ZonedDateTime updatedAt;

	@ManyToOne
	private User createdBy;

	@OneToMany(targetEntity = SimpleTaxonomyValue.class)
	private Set<TaxonomyValue> taxonomies;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Post(@NotBlank String title, @NotNull String excerpt, @NotNull String content,
			@NotNull Set<TaxonomyValue> taxonomies, @NotNull User createdBy) {
		this.title = title;
		this.excerpt = excerpt;
		this.content = content;
		this.createdBy = createdBy;
		this.taxonomies = taxonomies;

		// Externalize time-zone as system level
		this.createdAt = ZonedDateTime.now(ZoneId.of("Greenwhich"));
	}
	
	public Iterable<TaxonomyValue> getTaxonomies() {
		return Collections.unmodifiableSet(taxonomies);
	}
	
	public void addTaxonomyValue(TaxonomyValue taxValue) {
		taxonomies.add(taxValue);
	}
	
	public void removeTaxonomyValue(TaxonomyValue taxValue) {
		taxonomies.remove(taxValue);
	}
	
	public enum Status {
		PUBLISHED,
		DRAFT
	}
}
