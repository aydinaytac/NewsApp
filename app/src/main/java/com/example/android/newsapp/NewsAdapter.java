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

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news
 * in the data source (a list of {@link News} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * The part of the date string from the Guardian service that we use for time and date
     */
    private static final String DATE_SEPARATOR = "T";

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news    is the list of earthquakes, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        News currentNews = getItem(position);

        // Find the TextView with view ID news_web_title
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.news_web_title);
        // Display the title of the current news in that TextView
        titleTextView.setText(currentNews.getTitle());

        // Find the TextView with view ID news_contributor
        TextView contributorTextView = (TextView) listItemView.findViewById(R.id.news_contributor);
        // Display the contributor of the current news in that TextView
        if (currentNews.getContributor() != null) {
            contributorTextView.setText(currentNews.getContributor());
        } else {
            contributorTextView.setText(R.string.no_contributor);
        }

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);
        // Display the section of the current news in that TextView
        sectionView.setText(currentNews.getSection());

        // Get the original date and time string from the News object,
        String publicationTime = currentNews.getPublicationTime();

        String[] parts = publicationTime.split(DATE_SEPARATOR);
        String date = parts[0];
        String time = parts[1];
        String resultTime = time.replace("Z", "");

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Display the date of the current news in that TextView
        dateView.setText(date);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Display the time of the current news in that TextView
        timeView.setText(resultTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}