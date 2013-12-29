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
public class PhDCrawler extends WebComicCrawler{

    @Override
    protected ImageSrcAltTextPair getImageUrl(int comicIndex) throws IOException {
        String phdUrl;
        if (comicIndex < 0){
            phdUrl = "http://www.phdcomics.com/comic.php";
        }
        else
            phdUrl = "http://www.phdcomics.com/comics/archive.php?comicid=" + comicIndex;

        Log.d("webcomic_fetch_url", "Got url");
        Document doc = Jsoup.connect(phdUrl).get();
        Element image = doc.select("#comic").first();
        return new ImageSrcAltTextPair(image.absUrl("src"), image.attr("alt"));
    }
}
