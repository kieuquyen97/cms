package io.phat.cms.core.domain.event;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Logger;

@Service
public class DefaultChannelContainer implements ChannelContainer {

    private static final Logger LOGGER = Logger.getLogger(DefaultChannelContainer.class.getName());
    private Map<Class<? extends Event>, List<Consumer>> eventProcessMap = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void subscribe(Class<? extends Event> eventType, Consumer<? extends Event> process) {
        if (!isAvailableChannelFor(eventType)) {
            eventProcessMap.put(eventType, Collections.synchronizedList(new ArrayList<>()));
            LOGGER.info(String.format("New channel for event type [%s] created", eventType));
        }
        addProcessForEventType(eventType, process);
    }

    private void addProcessForEventType(Class<? extends Event> eventType, Consumer<? extends Event> process) {
        eventProcessMap.get(eventType).add(process);
        LOGGER.info(String.format("[%s] process subscribes for event type [%s]", process, eventType));
    }

    @Override
    public boolean isAvailableChannelFor(Class<? extends Event> eventType) {
        return eventProcessMap.containsKey(eventType);
    }

    @Override
    public void emit(Event eventPayload) {
        Class<? extends Event> eventType = eventPayload.getClass();
        if (isAvailableChannelFor(eventType)) {
            eventProcessMap.get(eventType)
                    .forEach(process -> {
                        process.accept(eventPayload);
                        LOGGER.info(String.format("Event type having emitted to process [%s]", process));
                    });
        } else {
            LOGGER.info(String.format("[%s] event channel not exist", eventType));
        }
    }
}
