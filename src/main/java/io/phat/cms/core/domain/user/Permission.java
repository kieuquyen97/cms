package io.phat.cms.core.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import io.phat.cms.core.domain.AbstractEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true, of = "name")
@ToString(callSuper = true)
public class Permission extends AbstractEntity {

	@Column(nullable = false, unique = true)
	private String name;
	
	public Permission(@NotBlank String name) {
		this.name = name;
	}
}
