package io.phat.cms.core.domain.taxonomy;

public interface TaxonomyRegistryService {
    void registerTaxonomy(Taxonomy taxonomy);
    boolean isTaxonomyRegistered(String taxNamedId);
}
