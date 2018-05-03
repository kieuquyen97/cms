package io.phat.cms.core.domain.event;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class EventChannelTest {

    private static final Logger LOGGER = Logger.getLogger(EventChannelTest.class.getName());
    private ChannelContainer eventChannel = new DefaultChannelContainer();

    @Test
    public void subscribeAndEmitTest() {
        eventChannel.subscribe(DummyEvent.class, e -> {
            if (!(e instanceof DummyEvent)) {
                return;
            }

            DummyEvent dummyEvent = (DummyEvent)e;
            String output = dummyEvent.getData().toString();

            Assert.assertEquals("data", output);
            LOGGER.info("Event output = " + output);
        });

        Assert.assertTrue(eventChannel.isAvailableChannelFor(DummyEvent.class));
        eventChannel.emit(new DummyEvent("data"));
    }
}
