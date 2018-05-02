package io.phat.cms.core.domain.taxonomy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HierarchicalTaxonomyValueDataSource {

    public static Set<HierarchicalTaxonomyValue> children = new HashSet<>();
    public static Taxonomy taxonomy = new Taxonomy("node", true);
    public static HierarchicalTaxonomyValue rootNode = DefaultTaxonomyValueFactory.create(taxonomy, "I AM ROOT");

    static {
        // Level 1 children
        for (int i = 0; i < 2; i++) {
            children.add(DefaultTaxonomyValueFactory.create(taxonomy, "level-1-" + i));
        }

        // Add level 2 and 3 children
        int noOfChildLv2 = 0;
        int noOfChildLv3 = 0;
        for (HierarchicalTaxonomyValue child : children) {
            for (int i = 0; i < 3; i++) {
                HierarchicalTaxonomyValue level2Node = DefaultTaxonomyValueFactory.create(taxonomy, "level-2-" + noOfChildLv2);
                child.add(level2Node); // Created node become 2nd level of each child from children variable

                for (int j = 0; j < 2; j++) {
                    HierarchicalTaxonomyValue level3Node = DefaultTaxonomyValueFactory.create(taxonomy, "level-3-" + noOfChildLv3);
                    level2Node.add(level3Node);
                    noOfChildLv3++;
                }
                noOfChildLv2++;
            }
        }

        // Merge them into root node children
        children.forEach(val -> rootNode.add(val));
    }
}
