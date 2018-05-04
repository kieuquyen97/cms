package io.phat.cms.core.domain.taxonomy;

import io.phat.cms.core.domain.event.ChannelContainer;
import io.phat.cms.core.domain.taxonomy.event.PreTaxonomyRegEvent;
import io.phat.cms.core.repository.TaxonomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DefaultTaxonomyRegistryService implements TaxonomyRegistryService {

    private static final Logger LOGGER = Logger.getLogger(DefaultTaxonomyRegistryService.class.getName());
    private final ChannelContainer channelContainer;
    private final TaxonomyRepository taxonomyRepository;

    @Autowired
    public DefaultTaxonomyRegistryService(ChannelContainer channelContainer, TaxonomyRepository taxonomyRepository) {
        this.channelContainer = channelContainer;
        this.taxonomyRepository = taxonomyRepository;
    }

    @Override
    public void registerTaxonomy(final Taxonomy taxonomy) {
        channelContainer.emit(new PreTaxonomyRegEvent(taxonomy));
        taxonomyRepository.save(taxonomy);
        LOGGER.info(String.format("Taxonomy [%s] registered.", taxonomy.getNamedId()));
    }

    @Override
    public boolean isTaxonomyRegistered(final String taxNamedId) {
        return taxonomyRepository.findByNamedId(taxNamedId) != null;
    }
}
