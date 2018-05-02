package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.observer.AbstractSubject;
import io.phat.cms.core.domain.observer.Event;
import io.phat.cms.core.domain.observer.Subject;
import org.springframework.stereotype.Component;

/**
 *
 * @author phatphan
 *
 * TODO: Each action should have specific event
 */
@Component
public class PostServiceSubject<T extends Event> extends AbstractSubject<T> implements Subject<T> {

}
