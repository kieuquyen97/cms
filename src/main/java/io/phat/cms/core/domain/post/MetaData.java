package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author phatphan
 *
 */
@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "namedId", callSuper = true)
@ToString(callSuper = true)
public class MetaData extends AbstractEntity {

	@Column(nullable = false, unique = true)
	private String namedId;

	private String value;
	
	public MetaData(@NotNull String namedId, String value) {
		this.namedId = namedId;
		this.value = value;
	}
}
