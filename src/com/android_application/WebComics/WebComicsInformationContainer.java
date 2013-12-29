package com.android_application.WebComics;

/**
 * User: rajat
 * Date: 28/12/13
 */

import com.android_application.WebComics.WebComicActivity.*;
import com.android_application.WebComics.WebComicCrawler.*;

/**
 * This is a singleton class which contains names of the webcomics and the relevant crawling information.
 */
public class WebComicsInformationContainer {
    private static WebComicsInformationContainer instance = new WebComicsInformationContainer();

    public WebComicCrawler getCrawler(int comic_type) {
        return crawlers[comic_type];
    }

    enum COMIC {
        XKCD,
        ABSTRUSEGOOSE,
        SMBC,
        PHD,
    }

    private int numberOfComics = COMIC.values().length;
    private String[] comicNames = new String[numberOfComics];
    private WebComicCrawler[] crawlers = new WebComicCrawler[numberOfComics];
    private int[] imageSource = new int[numberOfComics];

    private WebComicsInformationContainer(){
        // Include names
        comicNames[COMIC.XKCD.ordinal()] = "XKCD";
        comicNames[COMIC.ABSTRUSEGOOSE.ordinal()] = "Abstruse Goose";
        comicNames[COMIC.SMBC.ordinal()] = "Saturday Morning Breakfast Cereal";
        comicNames[COMIC.PHD.ordinal()] = "Piled Higher and Deeper";

        // Include crawlers
        crawlers[COMIC.XKCD.ordinal()] = new XkcdCrawler();
        crawlers[COMIC.ABSTRUSEGOOSE.ordinal()] = new AbstruseGooseCrawler();
        crawlers[COMIC.SMBC.ordinal()] = new SmbcCrawler();
        //crawlers[COMIC.PHD.ordinal()] = new Ph

        // Include image source
        imageSource[COMIC.XKCD.ordinal()] = R.drawable.xkcd;
        imageSource[COMIC.ABSTRUSEGOOSE.ordinal()] = R.drawable.abstrusegoose;
        imageSource[COMIC.SMBC.ordinal()] = R.drawable.smbc;
        imageSource[COMIC.PHD.ordinal()] = R.drawable.phd_logo;
    }

    public int getNumberOfComics(){
        return numberOfComics;
    }

    public String getComicName(COMIC comic){
        return comicNames[comic.ordinal()];
    }

    public int getImageSource(COMIC comic){
        return imageSource[comic.ordinal()];
    }

    public static WebComicsInformationContainer getInstance(){
        return instance;
    }
}
