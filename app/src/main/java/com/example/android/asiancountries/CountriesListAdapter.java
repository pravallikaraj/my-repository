package com.example.android.asiancountries;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.model.StreamEncoder;
//import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CountriesListAdapter extends RecyclerView.Adapter<CountriesListAdapter.ViewHolder> {

    private static final String TAG = "CountriesListAdapter";

    ArrayList<String> bordersList;
    private Context context;
    private List<CountryInfoModel> countryInfoModelList = new ArrayList<>();
    //String flag, name, capital, region, sub_region, borders, languages;
    //int population;

    public CountriesListAdapter(Context context, List<CountryInfoModel> countryInfoModelList) {
        this.context = context;
        this.countryInfoModelList = countryInfoModelList;
    }

    @NonNull
    @Override
    public CountriesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Context context1 =parent.getContext();

                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.countries_list_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesListAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        context = holder.itemView.getContext();

        holder.name.setText(countryInfoModelList.get(position).getCountry_name());
        holder.capital.setText(countryInfoModelList.get(position).getCountry_capital());
        holder.region.setText(countryInfoModelList.get(position).getCountry_region());
        holder.sub_region.setText(countryInfoModelList.get(position).getCountry_sub_region());
        holder.population.setText(String.valueOf(countryInfoModelList.get(position).getCountry_population()));

        String flag_image_url = countryInfoModelList.get(position).getCountry_flag();

        SvgLoader.pluck()
                .with((Activity) holder.flag.getContext())
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(flag_image_url, holder.flag);

    }


    @Override
    public int getItemCount() {
        return (countryInfoModelList == null) ? 0 : countryInfoModelList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout countryInfoParent;
        ImageView flag;
        TextView name, capital, region, sub_region, languages, borders, population;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            countryInfoParent = itemView.findViewById(R.id.country_info_parent);
            flag = itemView.findViewById(R.id.country_flag_iv);
            name = itemView.findViewById(R.id.country_name_tv);
            capital = itemView.findViewById(R.id.country_capital_tv);
            region = itemView.findViewById(R.id.country_region_tv);
            sub_region = itemView.findViewById(R.id.country_sub_region_tv);
            population = itemView.findViewById(R.id.country_population_tv);
        }
    }

}
