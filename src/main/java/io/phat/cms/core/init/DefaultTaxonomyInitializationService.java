package io.phat.cms.core.init;

import io.phat.cms.core.domain.taxonomy.Taxonomy;
import io.phat.cms.core.domain.taxonomy.TaxonomyRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Order(0)
public class DefaultTaxonomyInitializationService implements InitializableService {

    private final TaxonomyRegistryService taxonomyRegistryService;

    @Autowired
    public DefaultTaxonomyInitializationService(TaxonomyRegistryService taxonomyRegistryService) {
        this.taxonomyRegistryService = taxonomyRegistryService;
    }

    @Transactional
    public void init() {
        Taxonomy catTax = new Taxonomy("cms-tx-category", true);
        Taxonomy tagTax = new Taxonomy("cms-tx-tag", false);
        taxonomyRegistryService.registerTaxonomy(catTax);
        taxonomyRegistryService.registerTaxonomy(tagTax);
    }
}