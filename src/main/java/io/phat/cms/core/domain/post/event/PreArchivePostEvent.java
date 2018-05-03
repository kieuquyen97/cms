package io.phat.cms.core.domain.post.event;

import io.phat.cms.core.domain.event.Event;
import lombok.Getter;

@Getter
public class PreArchivePostEvent implements Event {

    private String postId;

    public PreArchivePostEvent(String postId) {
        this.postId = postId;
    }
}
