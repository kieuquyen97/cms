package io.phat.cms.core.domain.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import io.phat.cms.core.domain.AbstractEntity;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author phatphan
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "namedId", callSuper = true)
@ToString(callSuper = true)
public class MetaData extends AbstractEntity {

	@Column(nullable = false, unique = true)
	private String namedId;
	
	@Column(nullable = true)
	private String value;
	
	public MetaData(@NotNull String namedId, String value) {
		this.namedId = namedId;
		this.value = value;
	}
}
