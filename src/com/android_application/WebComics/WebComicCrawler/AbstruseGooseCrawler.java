package com.android_application.WebComics.WebComicCrawler;

import android.util.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * User: rajat
 * Date: 29/12/13
 */
public class AbstruseGooseCrawler extends WebComicCrawler {
    @Override
    protected ImageSrcAltTextPair getImageUrl(int comicIndex) throws IOException {
        String abstruseGooseUrl = "http://www.abstrusegoose.com/" + (comicIndex <= 0 ? "" : comicIndex);
        Log.d("webcomic_fetch_url", "Got url");
        Document doc = Jsoup.connect(abstruseGooseUrl).get();
        Element image = doc.select("section img").first();
        return new ImageSrcAltTextPair(image.absUrl("src"), image.attr("alt"));
    }
}
