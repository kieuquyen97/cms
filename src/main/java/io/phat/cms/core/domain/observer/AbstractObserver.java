package io.phat.cms.core.domain.observer;

/**
 *
 * @author phatphan
 *
 */
public abstract class AbstractObserver<T extends Event> implements Observer<T> {

    protected final Subject subject;

    public AbstractObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
}
