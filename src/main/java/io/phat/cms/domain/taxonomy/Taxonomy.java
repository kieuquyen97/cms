package io.phat.cms.domain.taxonomy;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.phat.cms.domain.AbstractEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author phanphat
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "namedId", callSuper = true)
public class Taxonomy extends AbstractEntity {

	// As user-registrated id
	@Column(nullable = false, unique = true)
	private String namedId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	private boolean hierarchy;
	
	Taxonomy(String namedId, String name, String description, boolean hierarchy) {
		this.namedId = namedId;
		this.name = name;
		this.description = description;
		this.hierarchy = hierarchy;
	}
}
