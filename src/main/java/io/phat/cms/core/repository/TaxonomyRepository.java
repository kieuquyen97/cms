package io.phat.cms.core.repository;

import io.phat.cms.core.domain.taxonomy.Taxonomy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonomyRepository extends CrudRepository<Taxonomy, String> {
    Taxonomy findByNamedId(String namedId);
}
