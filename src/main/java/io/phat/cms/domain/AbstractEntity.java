package io.phat.cms.domain;

import java.util.UUID;

import javax.persistence.Id;

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
@Getter
@EqualsAndHashCode(of = "generatedId")
@ToString
public abstract class AbstractEntity {
	
	@Id
	@Setter(AccessLevel.PRIVATE)
	private String generatedId;
	
	public AbstractEntity() {
		this.generatedId = getGeneratedIdentifier();
	}
	
	private String getGeneratedIdentifier() {
		return UUID.randomUUID().toString();
	}
}
