package com.example.theappexperts.aee;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.theappexperts.aee.realm.RealmCustomer;

import java.util.ArrayList;

/**
 * Created by TheAppExperts on 19/11/2017.
 */

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {

    public ArrayList<RealmCustomer> realmCustomers;
    public int row_customer;
    public Context applicationContext;

    public CustomerAdapter(ArrayList<RealmCustomer> realmCustomers, int row_customer, Context applicationContext) {
        this.realmCustomers = realmCustomers;
        this.row_customer = row_customer;
        this.applicationContext = applicationContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(applicationContext).inflate(row_customer, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Bitmap bitmap = BitmapFactory.decodeByteArray(realmCustomers.get(position).getmDp(), 0 , realmCustomers.get(position).getmDp().length);
        if(realmCustomers.get(position).getmDp() != null && bitmap != null)
        {
            holder.ivDp.setImageBitmap(bitmap);
        }

        holder.tvName.setText(realmCustomers.get(position).getmName().toString());
        holder.tvNumber.setText(realmCustomers.get(position).getmUser().toString());
        holder.tvDate.setText(realmCustomers.get(position).getmDob().toString());
        holder.tvGender.setText(realmCustomers.get(position).getmGender().toString());
        holder.tvCountry.setText(realmCustomers.get(position).getmCountry().toString());
        holder.tvAddress.setText(realmCustomers.get(position).getmAddress().toString());
    }

    @Override
    public int getItemCount() {
        return realmCustomers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvNumber, tvDate, tvGender, tvCountry, tvAddress;
        ImageView ivDp;

        public MyViewHolder(View itemView) {
            super(itemView);

            ivDp = (ImageView) itemView.findViewById(R.id.imageViewDP);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            tvNumber = (TextView)itemView.findViewById(R.id.tvUser);
            tvDate = (TextView)itemView.findViewById(R.id.tvDob);
            tvGender = (TextView)itemView.findViewById(R.id.tvGen);
            tvCountry = (TextView)itemView.findViewById(R.id.tvCountry);
            tvAddress = (TextView)itemView.findViewById(R.id.tvAdd);
        }
    }
}
