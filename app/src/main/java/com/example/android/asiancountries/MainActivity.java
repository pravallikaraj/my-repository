package com.example.android.asiancountries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private CountryViewModel countryViewModel;
//    ImageView flag;
    String asian_countries_url = "https://restcountries.eu/rest/v2/region/Asia";
    Context context;
    private final List<CountryInfoModel> countryInfoModelList = new ArrayList<>();
    RecyclerView recyclerView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 //btn = findViewById(R.id.btn);
        //flag = findViewById(R.id.country_flag_iv);
        recyclerView = findViewById(R.id.country_list_rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
       showCountriesList();

       countryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
    }


    public void showCountriesList()
    {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://restcountries.eu/rest/v2/region/Asia";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String countryName = "", countryCapital = "", countryRegion = "", countrySubRegion = "", countryFlag = "";
                int countryPopulation = 0;
               List<String> allBorders = new ArrayList<String>();

                try {
                    for (int i = 0; i < response.length(); i++)
                    {
                    JSONObject countryInfo = response.getJSONObject(i);

                    //for (int j=0; i<countryInfo.length(); i++) {
                        countryName = countryInfo.getString("name");
                        countryCapital = countryInfo.getString("capital");
                        countryRegion = countryInfo.getString("region");
                        countrySubRegion = countryInfo.getString("subregion");
                        countryPopulation = countryInfo.getInt("population");
                        countryFlag = countryInfo.getString("flag");

                        String border = "";
                        JSONArray countryBorders = countryInfo.getJSONArray("borders");

                            for (int j=0; j<countryBorders.length(); j++)
                            {
                                border = countryBorders.getString(j);
                                Log.d("BORDERS", border) ;

                            }

                            allBorders.add(border);

                        countryInfoModelList.add(new CountryInfoModel(countryFlag, countryName, countryCapital, countryRegion,
                                countrySubRegion, countryPopulation, allBorders));

                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }


                CountriesListAdapter countriesListAdapter = new CountriesListAdapter(context, countryInfoModelList);
                recyclerView.setAdapter(countriesListAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_LONG).show();
            }
        });


// Add the request to the RequestQueue.
        queue.add(request);
    }


}