package io.phat.cms.core.domain.taxonomy;

import io.phat.cms.core.repository.TaxonomyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DefaultTaxonomyRegistryService implements TaxonomyRegistryService {

    private static final Logger LOGGER = Logger.getLogger(DefaultTaxonomyRegistryService.class.getName());
    private final TaxonomyRepository taxonomyRepository;

    @Autowired
    public DefaultTaxonomyRegistryService(TaxonomyRepository taxonomyRepository) {
        this.taxonomyRepository = taxonomyRepository;
    }

    @Override
    public void registerTaxonomy(final Taxonomy taxonomy) {
        taxonomyRepository.save(taxonomy);
        LOGGER.info(String.format("[%s] taxonomy registered.", taxonomy.getNamedId()));
    }

    @Override
    public boolean isTaxonomyRegistered(final String taxNamedId) {
        return taxonomyRepository.findByNamedId(taxNamedId) != null;
    }
}
