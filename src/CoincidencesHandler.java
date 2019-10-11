import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

public class CoincidencesHandler {

    private Element sameIdElement;
    private Elements sameClassElements;
    private Elements sameTitleElements;
    private Elements sameHrefElements;
    private Elements sameOnclickElements;
    private Set<Element> elementsWithCoincidences;

    public CoincidencesHandler(HtmlElement elementToFind, String htmlFileName) {
        String htmlFile = Helpers.readFile(htmlFileName);
        Document fileDiff = Jsoup.parse(htmlFile);
        sameIdElement = fileDiff.getElementById(elementToFind.getId());
        sameClassElements = fileDiff.getElementsByClass(elementToFind.getClass_name());
        sameTitleElements = fileDiff.getElementsByAttributeValue("title", elementToFind.getTitle());
        sameHrefElements = fileDiff.getElementsByAttributeValue("href",elementToFind.getHref());
        sameOnclickElements = fileDiff.getElementsByAttributeValue("onclick",elementToFind.getOnclick());
        elementsWithCoincidences = this.unionCoincidences();
    }

    public Integer getQuantityCoincidences(Element element){
        Integer coincidences = 0;
        if (this.sameIdElement == element) coincidences ++;
        if (this.sameClassElements.contains(element)) coincidences ++;
        if (this.sameTitleElements.contains(element)) coincidences ++;
        if (this.sameHrefElements.contains(element)) coincidences ++;
        if (this.sameOnclickElements.contains(element)) coincidences ++;

        return coincidences;
    }

    public Set<Element> getElementsWithCoincidences() {
        return elementsWithCoincidences;
    }

    public Set<Element> unionCoincidences() {
        Set<Element> set = new HashSet<>();

        if (this.sameIdElement != null){
            set.add(this.sameIdElement);
        }
        set.addAll(this.sameClassElements);
        set.addAll(this.sameTitleElements);
        set.addAll(this.sameHrefElements);
        set.addAll(this.sameOnclickElements);

        return set;
    }
}
