package com.android_application.WebComics.WebComicCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * User: rajat
 * Date: 29/12/13
 */
public class SmbcCrawler extends WebComicCrawler{

    @Override
    protected ImageSrcAltTextPair getImageUrl(int comicIndex) throws IOException {
        String smbcUrl = "http://www.smbc-comics.com/" + (comicIndex < 0 ? "" : "?id=" + comicIndex);
        Document doc = Jsoup.connect(smbcUrl).get();
        Element image = doc.select("#comicimage img").first();
        return new ImageSrcAltTextPair(image.absUrl("src"), image.attr("alt"));
    }
}
