package io.phat.cms.core.domain.observer;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

/**
 *
 * @author phatphan
 *
 */
public abstract class AbstractSubject<T extends Event> implements Subject<T> {

    private static final Logger LOGGER = Logger.getLogger(AbstractSubject.class.getName());
    protected final Queue<Observer<T>> observers = new LinkedBlockingQueue<>();

    @Override
    public void attach(Observer<T> observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer<T> observer) {
        boolean isRemoved = observers.remove(observer);
        if (!isRemoved) {
            LOGGER.info(String.format("%s not exist", observer.getClass()));
        }
    }

    @Override
    public void raiseEvent(T event) {
        observers.forEach(observer -> {
            observer.update(event);
        });
    }
}
