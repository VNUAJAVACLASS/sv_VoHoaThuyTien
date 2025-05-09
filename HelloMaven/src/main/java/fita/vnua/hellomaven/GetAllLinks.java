package fita.vnua.hellomaven;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetAllLinks {
	public static void main(String[] args) throws IOException {
	       Document doc = Jsoup.connect("http://o7planning.org").get();
	       // Elements extends ArrayList<Element>.
	       Elements aElements = doc.getElementsByTag("a");
	       for (Element aElement : aElements) {
	           String href = aElement.attr("href");
	           String text = aElement.text();
	           System.out.println(text);
	           System.out.println("\t" + href);
	       }
	   }

}
