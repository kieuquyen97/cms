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

public class PostManipulateTest {
	
	private static final Logger LOGGER = Logger.getLogger(PostManipulateTest.class.getName());

	@Test
	public void postManipulateTest() {
		PostType albType = new PostType("album", "Album");
		Taxonomy catTax = new Taxonomy("category", "Category", "", true);
		Taxonomy tagTax = new Taxonomy("tag", "Tag", "", true);
		HierarchicalTaxonomyValue metalCatTaxVal = new DefaultHierarchicalTaxonomyValue(catTax, "Metal");
		PostBuilder builder = new DefaultPostBuilder(albType);
		
		// Register taxonomy for specific post type
		albType.registerTaxonomy(catTax);
		albType.registerTaxonomy(tagTax);
		
		// Set title
		builder.setTitle("Socceress");
		
		// Attach custom data to post
		builder.addMetaData(new MetaData("length", "60:00"));
		builder.addMetaData(new MetaData("noOfTrack", "5"));
		builder.addMetaData(new MetaData("artist", "Opeth"));
		
		// Attach genre
		builder.addTaxonomyValue(metalCatTaxVal);
		
		Post post = builder.getPost();
		LOGGER.info(post.toString());
		
		// Assert - expect fields being set
		Set<String> expMetaKeys = new HashSet<>(Arrays.asList("length", "noOfTrack", "artist"));
		post.getMetaData().forEach(data -> {
			Assert.assertTrue(expMetaKeys.contains(data.getNamedId()));
			LOGGER.info(data.getNamedId() + ": " + data.getValue());
		});
		
		// Assert - expect category set
		Assert.assertTrue(post.getTaxonomyValues().contains(metalCatTaxVal));
		
		// Let's modify our post
		String modifiedContent = "The album released in a year ago!";
		PostModifier albModifier = new DefaultPostModifier(post);
		
		albModifier.setContent(modifiedContent);
		post = albModifier.getPost();
		LOGGER.info(post.toString());
		
		// Assert - Expect content changed
		Assert.assertTrue(post.getContent().equals(modifiedContent));	
	}
}
