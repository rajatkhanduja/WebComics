package com.android_application.WebComics;

/**
 * User: rajat
 * Date: 28/12/13
 */

import com.android_application.WebComics.WebComicActivity.*;
import com.android_application.WebComics.WebComicCrawler.AbstruseGooseCrawler;
import com.android_application.WebComics.WebComicCrawler.WebComicCrawler;
import com.android_application.WebComics.WebComicCrawler.XkcdCrawler;

/**
 * This is a singleton class which contains names of the webcomics and the relevant crawling information.
 */
public class WebComicsInformationContainer {
    private static WebComicsInformationContainer instance = new WebComicsInformationContainer();

    public Class getComicActivityClass(COMIC comic) {
        return comicActivityClass[comic.ordinal()];
    }

    enum COMIC {
        XKCD,
        ABSTRUSEGOOSE,
        SMBC,
        PHD,
    }

    private int numberOfComics = COMIC.values().length;
    private String[] comicNames = new String[numberOfComics];
    private int[] imageSource = new int[numberOfComics];
    private Class[] comicActivityClass = new Class[numberOfComics];

    private WebComicsInformationContainer(){
        // Include names
        comicNames[COMIC.XKCD.ordinal()] = "XKCD";
        comicNames[COMIC.ABSTRUSEGOOSE.ordinal()] = "Abstruse Goose";
        comicNames[COMIC.SMBC.ordinal()] = "Saturday Morning Breakfast Cereal";
        comicNames[COMIC.PHD.ordinal()] = "Piled Higher and Deeper";

        // Include image source
        imageSource[COMIC.XKCD.ordinal()] = R.drawable.xkcd;
        imageSource[COMIC.ABSTRUSEGOOSE.ordinal()] = R.drawable.abstrusegoose;
        imageSource[COMIC.SMBC.ordinal()] = R.drawable.smbc;
        imageSource[COMIC.PHD.ordinal()] = R.drawable.phd_logo;

        // Declare activities
        comicActivityClass[COMIC.XKCD.ordinal()] = XkcdActivity.class;
        comicActivityClass[COMIC.ABSTRUSEGOOSE.ordinal()] = AGActivity.class;
        comicActivityClass[COMIC.SMBC.ordinal()] = SmbcActivity.class;
        comicActivityClass[COMIC.PHD.ordinal()]  = PhdActivity.class;
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
