package com.cnnradams.customcrawler;

import java.io.Serializable;

/**
 * Created by cnnr2 on 2018-06-27.
 */

public class CrawlerDataObject implements Serializable {
    public String title;
    public String url;
    public CrawlerDataObject(String title, String url) {
        this.title = title;
        this.url = url;
    }
}
