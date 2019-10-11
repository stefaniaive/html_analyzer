import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;

public class HtmlElementFinderTest {

    @Test
    public void testMain() throws FileNotFoundException {
        System.out.println("Testing HtmlElementFinder main method");
        String[] args = {"examples/sample-0-origin.html", "examples/sample-4-the-mash.html"};
        String idToTest = "make-everything-ok-button";
        System.setIn(new ByteArrayInputStream(idToTest.getBytes()));
        HtmlElementFinder.main(args);

    }
}
