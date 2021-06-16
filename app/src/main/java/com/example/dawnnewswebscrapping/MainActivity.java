package com.example.dawnnewswebscrapping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Adaptor adapter;
    RecyclerView recyclerView;
    private ArrayList<ParseItem> parseItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adaptor(parseItems,MainActivity.this);

        Content content = new Content();
        content.execute();

        recyclerView.setAdapter(adapter);
    }
    private class Content extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                String url = "https://www.dawn.com/opinion";

                Document doc = Jsoup.connect(url).get();

//                Document pageDocument;
//                Elements elements;
//                Elements articleElements;

               // elements = doc.select("article.box");
                //articleElements = pageDocument.select(".wrap .cols .col-1of2 p");
                //headline = elements.select("h1").text();

                // Elements data = doc.select("div.pic");
                Elements data= doc.select("article.box");
                int size = data.size();
                Log.d("doc", "doc: "+doc);
                Log.d("data", "data: "+data);
                Log.d("size", ""+size);
                for (int i = 0; i < 15; i++) {
                    String imgUrl = data.select("div.media__item")
                            .select("img")
                            .eq(i)
                            .attr("src");

                    String title = data.select("h2.story__title")
                            .select("a.story__link")
                            .eq(i)
                            .text();

                    String authername= data.select("span.story__byline")
                            .select("a")
                            .eq(i)
                            .text();

                    String detail = data.select("div.story__excerpt")
                            .text();


                    String time = data.select("span.story__time")
                            .select("span.timestamp--time")
                            .eq(i)
                            .text();


                    String detailUrl = data.select("h2.story__title")
                            .select("a")
                            .eq(i)
                            .attr("href");

                    parseItems.add(new ParseItem(imgUrl,authername,detail ,title, detailUrl,time));
                    Log.d("items", "img: " + imgUrl + " . title: " + title+"Detail Url: "+detailUrl);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
