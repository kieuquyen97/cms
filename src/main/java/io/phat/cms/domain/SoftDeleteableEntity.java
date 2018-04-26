package io.phat.cms.domain;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class SoftDeleteableEntity extends AbstractEntity {

	@Column(nullable = true)
	private ZonedDateTime deleteAt;
	
	public void delete() {
		// Externalize this as global level
		this.deleteAt = ZonedDateTime.now(ZoneId.of("Greenwhich"));
	}
}
