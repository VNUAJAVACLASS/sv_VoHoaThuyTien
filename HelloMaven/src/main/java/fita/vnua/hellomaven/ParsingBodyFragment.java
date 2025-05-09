package fita.vnua.hellomaven;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParsingBodyFragment {
	public static void main(String[] args) throws IOException {
	      String htmlFragment = "<h1>Hi you!</h1><p>What is this?</p>";
	      Document doc = Jsoup.parseBodyFragment(htmlFragment);
	      String fullHtml = doc.html();
	      System.out.println(fullHtml);
	  }

}
