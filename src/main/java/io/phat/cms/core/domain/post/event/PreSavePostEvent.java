package io.phat.cms.core.domain.post.event;

import io.phat.cms.core.domain.event.Event;
import io.phat.cms.core.domain.post.Post;
import lombok.Data;

/**
 *
 * @author phatphan
 *
 */
@Data
public class PreSavePostEvent implements Event {

    private Post post;

    public PreSavePostEvent(Post post) {
        this.post = post;
    }
}
