package io.phat.cms.core.domain.post;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

public class PostModifierTest {

    private static final Logger LOGGER = Logger.getLogger(PostModifierTest.class.getName());

    @Test
    public void modifyTest() {
        Post post = PostDataSource.get();
        LOGGER.info(post.toString());
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
