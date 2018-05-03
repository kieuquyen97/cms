package io.phat.cms.core.domain.event;

import lombok.Getter;

@Getter
public class DummyEvent implements Event {

    private Object data;

    public  DummyEvent(Object data) {
        this.data = data;
    }
}
