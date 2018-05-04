package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.event.ChannelContainer;
import io.phat.cms.core.domain.post.event.PrePostTypeRegEvent;
import io.phat.cms.core.domain.post.event.PreTaxForPostTypeRegEvent;
import io.phat.cms.core.domain.taxonomy.Taxonomy;
import io.phat.cms.core.repository.PostTypeRepository;
import io.phat.cms.core.repository.TaxonomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DefaultPostTypeRegistryService implements PostTypeRegistryService {

    private static final Logger LOGGER = Logger.getLogger(DefaultPostTypeRegistryService.class.getName());
    private final ChannelContainer channelContainer;
    private final PostTypeRepository postTypeRepository;
    private final TaxonomyRepository taxonomyRepository;

    @Autowired
    public DefaultPostTypeRegistryService(ChannelContainer channelContainer,
                                          PostTypeRepository postTypeRepository,
                                          TaxonomyRepository taxonomyRepository) {
        this.channelContainer = channelContainer;
        this.postTypeRepository = postTypeRepository;
        this.taxonomyRepository = taxonomyRepository;
    }

    @Override
    public void registerPostType(final PostType postType) {
        channelContainer.emit(new PrePostTypeRegEvent(postType));
        postTypeRepository.save(postType);
        LOGGER.info(String.format("Post type [%s] registered.", postType.getNamedId()));
    }

    @Override
    public void registerTaxonomyForPostType(String postTypeNamedId, String taxNamedId) {
        Taxonomy tax = taxonomyRepository.findByNamedId(taxNamedId);
        PostType postType = postTypeRepository.findByNamedId(postTypeNamedId);

        if (tax != null && postType != null) {
            channelContainer.emit(new PreTaxForPostTypeRegEvent(tax, postType));
            postType.registerTaxonomy(tax);
            postTypeRepository.save(postType);
            LOGGER.info(String.format("Taxonomy [%s] added into post type [%s].", postTypeNamedId, taxNamedId));
        }
    }

    @Override
    public boolean isPostTypeRegistered(String namedId) {
        return postTypeRepository.findByNamedId(namedId) != null;
    }

    @Override
    public PostType findByNamedId(String namedId) {
        return postTypeRepository.findByNamedId(namedId);
    }
}
