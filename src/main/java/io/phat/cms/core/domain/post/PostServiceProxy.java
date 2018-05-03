package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.event.ChannelContainer;
import io.phat.cms.core.domain.post.event.PreArchivePostEvent;
import io.phat.cms.core.domain.post.event.PreCreatePostEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author phatphan
 *
 * Intercept {@link PostService} action, allow user to pre/post handle post data
 */
@Service
public class PostServiceProxy implements PostService {

    private final PostService postService;
    private final ChannelContainer channelContainer;

    @Autowired
    public PostServiceProxy(@Qualifier("defaultPostService") PostService postService,
                            ChannelContainer channelContainer) {
        this.postService = postService;
        this.channelContainer = channelContainer;
    }

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postService.findAll(pageable);
    }

    @Override
    public Post findOne(String id) {
        return postService.findOne(id);
    }

    @Override
    public void save(Post post) {
        channelContainer.emit(new PreCreatePostEvent(post));
        postService.save(post);
    }

    @Override
    public void archive(String id) {
        channelContainer.emit(new PreArchivePostEvent(id));
        postService.archive(id);
    }
}
