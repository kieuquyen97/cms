package io.phat.cms.core.domain.post.event;

import io.phat.cms.core.domain.event.Event;
import io.phat.cms.core.domain.post.Post;
import lombok.Getter;

@Getter
public class PreCreatePostEvent implements Event {

    private Post post;

    public PreCreatePostEvent(Post post) {
        this.post = post;
    }
}
