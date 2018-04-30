package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.SoftDeletableEntity;
import io.phat.cms.core.domain.taxonomy.DefaultTaxonomyValue;
import io.phat.cms.core.domain.taxonomy.TaxonomyValue;
import io.phat.cms.core.domain.user.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author phatphan
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Post extends SoftDeletableEntity {

	private static final Logger LOGGER = Logger.getLogger(Post.class.toString());
	
	@ManyToOne
	private PostType postType;
	
	@OneToMany
	private Set<MetaData> metaData = new HashSet<>();

	@OneToMany(targetEntity = DefaultTaxonomyValue.class)
	private Set<TaxonomyValue> taxonomyValues = new HashSet<>();
	
	@ManyToOne(optional = false)
	private User user;
	
	@Setter(AccessLevel.PRIVATE)
	@Column(nullable = false)
	private ZonedDateTime createdAt = ZonedDateTime.now(ZoneId.systemDefault());
	
	@Setter(AccessLevel.PRIVATE)
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
