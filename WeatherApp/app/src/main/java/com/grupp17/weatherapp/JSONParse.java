package com.grupp17.weatherapp;

import java.net.*;
import java.io.*;

/**
 * A complete Java class that demonstrates how to read content (text) from a URL
 * using the Java URL and URLConnection classes.
 * @author alvin alexander, alvinalexander.com
 */
public class JSONParse
{
    public static void main(String[] args)
    {
        String output  = getUrlContents("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/16.158/lat/58.5812/data.json");
        System.out.println(output);
    }

    private static String getUrlContents(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}