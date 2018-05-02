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

	private boolean hierarchy;

	public Taxonomy(@NotBlank String namedId, boolean hierarchy) {
		this.namedId = namedId;
		this.hierarchy = hierarchy;
	}
}
