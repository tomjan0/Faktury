package mypackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleTest {
    Article art;

    @Before
    public void setUp() throws Exception {
        art = new Article(1,"art", 9.99);
    }

    @Test
    public void getName() {
        assertTrue(art.getName() == "art");
    }

    @Test
    public void getPrice() {
        assertTrue(art.getPrice() == 9.99);
    }

    @Test (expected = IllegalArgumentException.class)
    public void negativeIdConstrution() {
        new Article(1, "as", -23);
    }

}