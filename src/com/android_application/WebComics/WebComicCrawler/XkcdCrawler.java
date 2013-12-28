package com.android_application.WebComics.WebComicCrawler;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * User: rajat
 * Date: 28/12/13
 */
public class XkcdCrawler extends WebComicCrawler {

    protected WebComicCrawler.ImageSrcAltTextPair getImageUrl(int comicIndex) throws IOException {
        String xkcdUrl = "http://www.xkcd.com/" + (comicIndex == -1 ? "" : comicIndex);
        Document doc = Jsoup.connect(xkcdUrl).get();
        Element image = doc.select("#comic img").first();

        return new ImageSrcAltTextPair(image.absUrl("src"), image.attr("alt"));
    }
}
