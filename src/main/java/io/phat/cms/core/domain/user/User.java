package io.phat.cms.core.domain.user;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode(of = "username", callSuper = true)
@ToString(callSuper = true)
public class User extends AbstractEntity {

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private ZonedDateTime createdAt;

	@Column(nullable = true)
	@Setter(AccessLevel.PUBLIC)
	private ZonedDateTime updateAt;

	@ManyToOne
	@Column(nullable = false)
	private User createdBy;

	@ManyToOne
	private Role role;

	public User(@NotBlank String username, @NotBlank String password, @NotNull User createdBy, @NotNull Role role) {
		super();
		this.username = username;
		this.password = password;
		this.createdBy = createdBy;
		this.role = role;

		// Externalize time-zone as system level
		this.createdAt = ZonedDateTime.now(ZoneId.systemDefault());
	}
}
