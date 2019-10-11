import org.jsoup.nodes.Element;

public class HtmlElement {
    private String id;
    private String class_name;
    private String title;
    private String href;
    private String onclick;

    public HtmlElement(Element element){
        id = element.id();
        class_name = element.className();
        title = element.attr("title");
        href = element.attr("href");
        onclick = element.attr("onclick");
    }

    public String getId() {
        return id;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getTitle() {
        return title;
    }

    public String getHref() {
        return href;
    }

    public String getOnclick() {
        return onclick;
    }

}
