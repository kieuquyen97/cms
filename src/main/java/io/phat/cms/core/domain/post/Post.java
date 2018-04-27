package io.phat.cms.core.domain.post;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import io.phat.cms.core.domain.SoftDeleteableEntity;
import io.phat.cms.core.domain.taxonomy.DefaultTaxonomyValue;
import io.phat.cms.core.domain.taxonomy.TaxonomyValue;
import io.phat.cms.core.domain.user.User;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author phatphan
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PACKAGE)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@ToString(callSuper = true)
public class Post extends SoftDeleteableEntity {

	private static final Logger LOGGER = Logger.getLogger(Post.class.toString());
	
	@ManyToOne
	private PostType postType;
	
	@OneToMany
	private Set<MetaData> metaData = new HashSet<>();

	@OneToMany(targetEntity = DefaultTaxonomyValue.class)
	private Set<TaxonomyValue> taxonomyValues = new HashSet<>();
	
	@ManyToOne
	private User user;
	
	@Setter(AccessLevel.PRIVATE)
	@Column(nullable = false)
	private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.systemDefault());
	
	@Setter(AccessLevel.PRIVATE)
	@Column(nullable = true)
	private ZonedDateTime updatedAt;
	
	private String title;
	
	private String excerpt;
	
	private String content;
	
	private Status status = Status.DRAFT;
	
	void setTaxonomyValues(Collection<TaxonomyValue> taxonomyValues) {
		for (TaxonomyValue val : taxonomyValues) {
			if (postType.isTaxonomyRegistered(val.getTaxonomy())) {
				this.taxonomyValues.add(val);
			} else {
				String message = String.format("Taxonomy [%s] not registered yet!", val.getTaxonomy());
				LOGGER.log(Level.INFO, message);
			}
		}
	}
	
	void setUpdateAt() {
		this.updatedAt = ZonedDateTime.now(ZoneId.systemDefault());
	}
	
	public Collection<MetaData> getMetaData() {
		return Collections.unmodifiableSet(metaData);
	}
	
	public Collection<TaxonomyValue> getTaxonomyValues() {
		return Collections.unmodifiableSet(taxonomyValues);
	}
	
	public enum Status {
		PUBLISHED,
		DRAFT
	}
}
