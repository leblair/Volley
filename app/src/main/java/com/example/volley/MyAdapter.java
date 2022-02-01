package com.example.volley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private Context mContext;
    private List<Peak> mPeak;

    public MyAdapter(Context mContext, List<Peak> mPeak) {
        this.mContext = mContext;
        this.mPeak = mPeak;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(mPeak.get(position).getName());
        holder.height.setText(mPeak.get(position).getHeight());
        holder.country.setText(mPeak.get(position).getCountry());
        Picasso.get().load(mPeak.get(position).getUrl()).fit().centerCrop().into(holder.url);

    }

    @Override
    public int getItemCount() {

        return mPeak.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView height;
        ImageView url;
        TextView country;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textName);
            height = itemView.findViewById(R.id.textHeight);
            url = itemView.findViewById(R.id.image);
            country = itemView.findViewById(R.id.textCountry);
        }

    }
}
