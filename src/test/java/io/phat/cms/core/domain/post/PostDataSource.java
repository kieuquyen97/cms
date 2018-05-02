package io.phat.cms.core.domain.post;

import io.phat.cms.core.domain.taxonomy.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PostDataSource {

    public static PostType postType;
    public static Set<Taxonomy> taxonomies = new HashSet<>();
    public static Set<TaxonomyValue> taxonomyVals = new HashSet<>();
    public static Set<MetaData> metaDataSet = new HashSet<>();

    static {
        Taxonomy catTax = new Taxonomy("category", true);
        Taxonomy tagTax = new Taxonomy("tag", true);
        HierarchicalTaxonomyValue metalCatTaxVal = DefaultTaxonomyValueFactory.create(catTax, "Metal");

        postType = new PostType("album");
        taxonomies.addAll(Arrays.asList(catTax, tagTax));
        taxonomyVals.add(metalCatTaxVal);

        // Register taxonomy for specific post type
        postType.registerTaxonomy(catTax);
        postType.registerTaxonomy(tagTax);

        // Metadata
        metaDataSet.addAll(Arrays.asList(
                new MetaData("length", "60:00"),
                new MetaData("noOfTrack", "5"),
                new MetaData("artist", "Opeth")));
    }

    public static Post get() {
        PostBuilder builder = new DefaultPostBuilder(postType);

        // Set title
        builder.setTitle("Socceress");

        // Attach custom data to post
        metaDataSet.forEach(val -> builder.addMetaData(val));

        // Attach genre
        taxonomyVals.forEach(val -> builder.addTaxonomyValue(val));

        return builder.getPost();
    }
}
