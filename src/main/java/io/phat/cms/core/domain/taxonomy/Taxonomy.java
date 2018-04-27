package io.phat.cms.core.domain.taxonomy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.phat.cms.core.domain.AbstractEntity;
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
@EqualsAndHashCode(of = "namedId", callSuper = true)
@ToString(callSuper = true)
public class Taxonomy extends AbstractEntity {

	@Column(nullable = false, unique = true)
	private String namedId;

	private String name;

	private String description;

	private boolean hierarchy;

	public Taxonomy(@NotBlank String namedId, @NotNull String name, @NotNull String description, boolean hierarchy) {
		this.namedId = namedId;
		this.name = name;
		this.description = description;
		this.hierarchy = hierarchy;
	}
}
