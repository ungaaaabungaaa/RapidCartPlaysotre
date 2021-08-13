package com.rapidcartconsumers;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ShopSelectAdapter extends RecyclerView.Adapter<ShopSelectAdapter.ViewHolder> {



    public List<Shoppickmodel> mainList;
    public Context context;

    public ShopSelectAdapter(List<Shoppickmodel> notifList) {
        this.mainList=notifList;
    }


    @NonNull
    @Override
    public ShopSelectAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopselect, parent, false);
        context = parent.getContext();
        return new ShopSelectAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopSelectAdapter.ViewHolder holder, int position) {
        String Shopid=mainList.get(position).getShopid();
        String Shopname=mainList.get(position).getShopname();
        String Shopimageurl=mainList.get(position).getShopimageurl();
        String minimumorder=mainList.get(position).getMinmumorder();
        if (Shopid!=null&&Shopname!=null&&Shopimageurl!=null&&minimumorder!=null)
        {
            holder.Shopname.setText(Shopname);
            Glide.with(context).load(Shopimageurl).thumbnail(0.25f).into(holder.shopimage);
            holder.minimumorder.setText(minimumorder);
        }
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(context, HomeActivity.class);
                Intent.putExtra("shopid",Shopid);
                context.startActivity(Intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        ImageView shopimage;
        TextView Shopname;
        TextView minimumorder;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
            shopimage=mView.findViewById(R.id.shopimage);
            minimumorder=mView.findViewById(R.id.textView28);
            Shopname=mView.findViewById(R.id.textView6);
        }
    }
}
