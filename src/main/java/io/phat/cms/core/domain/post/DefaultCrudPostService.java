package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.event.ChannelContainer;
import io.phat.cms.core.domain.post.event.PreArchivePostEvent;
import io.phat.cms.core.domain.post.event.PreSavePostEvent;
import io.phat.cms.core.domain.post.event.PreQueryPostEvent;
import io.phat.cms.core.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

/**
 *
 * @author phatphan
 *
 */
@Service
public class DefaultCrudPostService implements CrudPostService {

    private static final Logger LOGGER = Logger.getLogger(DefaultCrudPostService.class.getName());
    private final ChannelContainer channelContainer;
    private final PostRepository postRepository;

    @Autowired
    public DefaultCrudPostService(ChannelContainer channelContainer, PostRepository postRepository) {
        this.channelContainer = channelContainer;
        this.postRepository = postRepository;
    }

    @Override
    // TODO: Implement this feature - input is a class containing all query data
    public Object query() {
        channelContainer.emit(new PreQueryPostEvent());
        return null;
    }

    @Override
    public void save(Post post) {
        channelContainer.emit(new PreSavePostEvent(post));
        postRepository.save(post);
        LOGGER.info(String.format("Post [%s] saved or updated", post.getGeneratedId()));
    }

    @Override
    public void archive(String id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Post [%s] not found", id)));

        channelContainer.emit(new PreArchivePostEvent(post));
        post.delete();
        postRepository.save(post);
        LOGGER.info(String.format("Post [%s] archived", post.getGeneratedId()));
    }
}
