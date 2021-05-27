package edu.gcit.todo_22ii;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

//to connect it to the internet
public class NetworkUtils {
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    //Base URL for book API
    private static final String BOOK_BASE_URL = "https://www.googleapis.com/books/v1/volumes?";
    //parameter for the search string
    private static final String QUERY_PARAM = "q";
    //parameter that limits search results
    private static final String MAX_RESULTS = "maxResults";
    //parameter to filter by print type.
    private static final String PRINT_TYPE = "printType";

    static String getBookInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null; // to read the data
        String bookJSONString = null; //to convert json file to string

        try{
            Uri builtURI = Uri.parse(BOOK_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(MAX_RESULTS, "10")
                    .appendQueryParameter(PRINT_TYPE, "books")
                    .build();

            URL requestURL = new URL(builtURI.toString());
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            //create a buffered reader from that input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));

            //to hold the incoming response
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line=reader.readLine())!=null){
                builder.append(line);
                builder.append("\n");
            }
            if (builder.length()==0){
                return null;
            }
            bookJSONString = builder.toString();

        }
        catch (IOException e){
            e.printStackTrace(); //to print exception
        }
        finally {
            if (urlConnection !=null){
                urlConnection.disconnect();
            }
            if (reader!=null){
                try{
                    reader.close();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
        Log.d(LOG_TAG,bookJSONString);
        return bookJSONString;
    }


}
