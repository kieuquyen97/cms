package io.phat.cms.core.domain.post.event;

import io.phat.cms.core.domain.event.Event;
import io.phat.cms.core.domain.post.PostType;
import lombok.Data;

/**
 *
 * @author phatphan
 *
 */
@Data
public class PrePostTypeRegEvent implements Event {

    private PostType postType;

    public PrePostTypeRegEvent(PostType postType) {
        this.postType = postType;
    }
}
