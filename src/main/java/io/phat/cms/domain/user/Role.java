package io.phat.cms.domain.user;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.phat.cms.domain.AbstractEntity;
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
public class Role extends AbstractEntity {

	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany
	private Set<Permission> permissions;
	
	public Role(@NotBlank String name) {
		this.name = name;
	}
	
	public boolean isHasPermission(@NotNull Permission permission) {
		return permissions.contains(permission);
	}
	
	public void add(@NotNull Permission permission) {
		permissions.add(permission);
	}
	
	public void remove(@NotNull Permission permission) {
		permissions.remove(permission);
	}
	
	public Iterable<Permission> getPermissions() {
		return Collections.unmodifiableSet(permissions);
	}
}
