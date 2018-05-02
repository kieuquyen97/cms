package io.phat.cms.core.domain.observer;

import javax.validation.constraints.NotNull;

/**
 *
 * @author phatphan
 *
 */
public interface Subject<T extends Event> {
    void attach(@NotNull Observer<T> observer);
    void remove(@NotNull Observer<T> observer);
    void raiseEvent(T event);
}
