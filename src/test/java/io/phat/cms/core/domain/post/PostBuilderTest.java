package io.phat.cms.core.domain.post;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import io.phat.cms.core.domain.taxonomy.DefaultHierarchicalTaxonomyValue;
import io.phat.cms.core.domain.taxonomy.HierarchicalTaxonomyValue;
import io.phat.cms.core.domain.taxonomy.Taxonomy;

public class PostBuilderTest {
	
	private static final Logger LOGGER = Logger.getLogger(PostBuilderTest.class.getName());

	@Test
	public void buildTest() {
		Post post = PostDataSource.get();
		LOGGER.info(post.toString());
		
		// Assert - expect fields being set
		Set<String> expMetaKeys = new HashSet<>(Arrays.asList("length", "noOfTrack", "artist"));
		post.getMetaData().forEach(data -> {
			Assert.assertTrue(expMetaKeys.contains(data.getNamedId()));
			LOGGER.info(data.getNamedId() + ": " + data.getValue());
		});
		
		// Assert - expect category set
		Assert.assertNotNull(
				post.getTaxonomyValues()
						.stream()
						.filter(val -> val.getTaxonomy()
								.getNamedId()
								.equals("category"))
						.findFirst()
						.orElse(null));
	}
}
