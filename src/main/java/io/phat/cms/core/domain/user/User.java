package io.phat.cms.core.domain.user;

import io.phat.cms.core.domain.SoftDeletableEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 
 * @author phanphat
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "username", callSuper = true)
@ToString(callSuper = true)
public class User extends SoftDeletableEntity {

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private ZonedDateTime createdAt;

	@Setter(AccessLevel.PUBLIC)
	private ZonedDateTime updateAt;

	@ManyToOne(optional = false)
	private User createdBy;

	@ManyToOne(optional = false)
	private Role role;

	public User(@NotBlank String username, @NotBlank String password, @NotNull User createdBy, @NotNull Role role) {
		super();
		this.username = username;
		this.password = password;
		this.createdBy = createdBy;
		this.role = role;
		this.createdAt = ZonedDateTime.now(ZoneId.systemDefault());
	}
}
