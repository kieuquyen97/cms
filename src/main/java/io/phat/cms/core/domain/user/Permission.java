package io.phat.cms.core.domain.user;

import io.phat.cms.core.domain.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true, of = "name")
@ToString(callSuper = true)
public class Permission extends AbstractEntity {

	@Column(nullable = false, unique = true)
	private String name;
	
	public Permission(@NotBlank String name) {
		this.name = name;
	}
}
