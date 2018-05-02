package io.phat.cms.core.domain.observer;

/**
 *
 * @author phatphan
 *
 */
public interface Observer<T extends Event> {
    void update(T event);
}
