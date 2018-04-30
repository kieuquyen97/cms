package io.phat.cms.core.domain.taxonomy;

import io.phat.cms.core.domain.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author phanphat
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
