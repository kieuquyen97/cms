package io.phat.cms.core.domain.taxonomy;

import org.junit.Test;
import org.junit.Assert;

import java.util.logging.Logger;

public class HierarchicalTaxonomyValueTest {

    private static final Logger LOGGER = Logger.getLogger(HierarchicalTaxonomyValueTest.class.getName());

    @Test
    public void findNode() {
        HierarchicalTaxonomyValue rootNode = HierarchicalTaxonomyValueDataSource.rootNode;
        LOGGER.info(rootNode.toString());

        // Assert
        HierarchicalTaxonomyValue foundNode = rootNode.find(node -> node.getValue().equals("level-3-11"));
        Assert.assertNotNull(foundNode);
    }
}
