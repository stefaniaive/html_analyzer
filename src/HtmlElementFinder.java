import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Scanner;

public class HtmlElementFinder {

    private static HtmlElement getTargetElementToFind(String originalFile){
        String fileOrigin = Helpers.readFile(originalFile);
        Document htmlOrigin = Jsoup.parse(fileOrigin);

        Scanner input = new Scanner(System.in);
        System.out.println("What is the id of the element you want to find in the diff html?");
        String element_id = input.nextLine();
        Element targetElement = htmlOrigin.getElementById(element_id);

        System.out.println("Original element:");
        System.out.printf("  %s\n", targetElement.toString());

        return new HtmlElement(targetElement);
    }

    public static void main(String[] args) {
        if (args.length < 2){
            System.out.print("Not enough arguments");
            return;
        }

        String originalFile = args[0];
        String diffFile = args[1];

        HtmlElement originElement = getTargetElementToFind(originalFile);
        CoincidencesHandler coincidences = new CoincidencesHandler(originElement, diffFile);

        Element selectedElement = null;
        Integer maxCoincidences = -1;

        for (Element e : coincidences.getElementsWithCoincidences()) {
            Integer elementCoincidences = coincidences.getQuantityCoincidences(e);
            if (elementCoincidences > maxCoincidences){
                maxCoincidences = elementCoincidences;
                selectedElement = e;
            }
        }

        if (selectedElement == null){
            System.out.println("The element could not be found");
            return;
        }

        System.out.println("Target element:");
        System.out.printf("  %s\n", selectedElement.toString());

    }
}