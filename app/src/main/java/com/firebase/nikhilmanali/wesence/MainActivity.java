package com.firebase.nikhilmanali.wesence;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.login.LoginManager;
import com.firebase.nikhilmanali.wesence.jsonSchema.Feed;
import com.firebase.nikhilmanali.wesence.jsonSchema.jsonData;
import com.firebase.nikhilmanali.wesence.retrofit.ApiClient;
import com.firebase.nikhilmanali.wesence.retrofit.urlInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    jsonData json;  // Json data from Api
    List<Feed> feed; // Feed list fetch from Api
    dataAdapter adapter;
    int page=1;
    boolean hasmore=false; // this hold the boolean value of hasmore page parameter

    Call<jsonData> call;  // This is used to call retrofit 2.0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();  // initialize all views

    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);// Intialize recycler view
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadFeed();
    }

    private void loadFeed(){
        final urlInterface apiService = ApiClient.getClient().create(urlInterface.class);
        call = apiService.getJson(page+""); // call the Json data of the given page
        call.enqueue(new Callback<jsonData>() {
            @Override
            public void onResponse(Call<jsonData> call, Response<jsonData> response) {

                json=response.body(); // getting response from api and server
                feed=json.getData().getFeed(); // getting feeds
                hasmore=json.getData().getHasMore(); // checking the value of hasmore pages
                adapter = new dataAdapter(feed,MainActivity.this);
                recyclerView.setAdapter(adapter); // attaching the adapter to recycler view
                page++;


            }

            @Override
            public void onFailure(Call<jsonData> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });


        // making recycler view to notify about scroll and to fetch the new feeds with incrementing page number in each scroll.

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (hasmore) { // this if condition check if there are more pages available or not . If yes then enter else stop calling Api.


                    call = apiService.getJson(page + "");
                    call.enqueue(new Callback<jsonData>() {
                        @Override
                        public void onResponse(Call<jsonData> call, Response<jsonData> response) {


                            json = response.body();
                            if(hasmore){ // if there are more pages add getFeed() to feeds list
                            feed.addAll(json.getData().getFeed());
                            }
                            hasmore = json.getData().getHasMore();
                            adapter.notifyDataSetChanged(); // It notify the adapter about the changes
                            if (hasmore) { // This is to check if there are no more pages stop incrementing the page.
                                page++;
                            }
                        }

                        @Override
                        public void onFailure(Call<jsonData> call, Throwable t) {

                        }
                    });

                }
            }

        });

    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id ==R.id.action_settings) {  // This menu is for logout option
            LoginManager.getInstance().logOut();
            startActivity(new Intent(MainActivity.this,Login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
