package io.phat.cms.core.domain;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * 
 * @author phanphat
 *
 */
@MappedSuperclass
@EqualsAndHashCode(of = "generatedId")
@ToString
public abstract class AbstractEntity {
	
	@Id
	@Getter
	@Setter(AccessLevel.PRIVATE)
	private String generatedId = UUID.randomUUID().toString();
}
