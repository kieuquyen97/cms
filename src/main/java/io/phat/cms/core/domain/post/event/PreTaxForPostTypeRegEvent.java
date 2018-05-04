package io.phat.cms.core.domain.post.event;

import io.phat.cms.core.domain.event.Event;
import io.phat.cms.core.domain.post.PostType;
import io.phat.cms.core.domain.taxonomy.Taxonomy;
import lombok.Data;

/**
 *
 * @author phatphan
 *
 */
@Data
public class PreTaxForPostTypeRegEvent implements Event {

    private Taxonomy taxonomy;
    private PostType postType;

    public PreTaxForPostTypeRegEvent(Taxonomy taxonomy, PostType postType) {
        this.taxonomy = taxonomy;
        this.postType = postType;
    }
}
