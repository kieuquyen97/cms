package io.phat.cms.core.domain.event;

import java.util.function.Consumer;

public interface ChannelContainer {
    void subscribe(Class<? extends Event> eventType, Consumer<? extends Event> process);
    void emit(Event eventPayload);
    boolean isAvailableChannelFor(Class<? extends Event> eventType);
}
