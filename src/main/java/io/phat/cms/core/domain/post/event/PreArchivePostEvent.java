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
public class PreArchivePostEvent implements Event {

    private Post post;

    public PreArchivePostEvent(Post post) {
        this.post = post;
    }
}
