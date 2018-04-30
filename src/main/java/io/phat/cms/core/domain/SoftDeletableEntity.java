package io.phat.cms.core.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class SoftDeletableEntity extends AbstractEntity {

	@Getter
	@Setter(AccessLevel.PRIVATE)
	private ZonedDateTime deleteAt;

	public void delete() {
		this.deleteAt = ZonedDateTime.now(ZoneId.systemDefault());
	}
}
