package io.phat.cms.core.domain.taxonomy.event;

import io.phat.cms.core.domain.event.Event;
import io.phat.cms.core.domain.taxonomy.Taxonomy;
import lombok.Data;

/**
 *
 * @author phatphan
 *
 */
@Data
public class PreTaxonomyRegEvent implements Event {

    private Taxonomy taxonomy;

    public PreTaxonomyRegEvent(Taxonomy taxonomy) {
        this.taxonomy = taxonomy;
    }
}
