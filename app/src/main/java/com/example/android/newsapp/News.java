/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.newsapp;

/**
 * An {@link News} object contains information related to a single news.
 */
public class News {

    /**
     * Title of the news
     */
    private String mTitle;

    /**
     * Writer of the news
     */
    private String mContributor;

    /**
     * Time of the news
     */
    private String mPublicationTime;

    /**
     * Section of the news
     */
    private String mSection;

    /**
     * Website URL of the news
     */
    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param title          is the magnitude (size) of the earthquake
     * @param contributor    is the location where the earthquake happened
     * @param pulicationTime is the time in milliseconds (from the Epoch) when the
     *                       earthquake happened
     * @param section        is the section of the news
     * @param url            is the website URL to find more details about the earthquake
     */
    public News(String title, String contributor, String pulicationTime, String section, String url) {
        mTitle = title;
        mContributor = contributor;
        mPublicationTime = pulicationTime;
        mSection = section;
        mUrl = url;
    }

    /**
     * Returns the title of the news.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the contributor of the news.
     */
    public String getContributor() {
        return mContributor;
    }

    /**
     * Returns the time of the news.
     */
    public String getPublicationTime() {
        return mPublicationTime;
    }

    /**
     * Returns the section of the news.
     */
    public String getSection() {
        return mSection;
    }

    /**
     * Returns the website URL to find more information about the news.
     */
    public String getUrl() {
        return mUrl;
    }
}