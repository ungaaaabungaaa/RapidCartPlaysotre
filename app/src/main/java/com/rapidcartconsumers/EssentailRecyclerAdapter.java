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

public class EssentailRecyclerAdapter extends RecyclerView.Adapter<EssentailRecyclerAdapter.ViewHolder> {

    public List<MainModel> mainList;
    public Context context;

    public EssentailRecyclerAdapter(List<MainModel> notifList) {
        this.mainList=notifList;
    }


    @NonNull
    @Override
    public EssentailRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mainitemx, parent, false);
        context = parent.getContext();
        return new EssentailRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EssentailRecyclerAdapter.ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        String  pricex=mainList.get(position).getPrice();
        String  Storeid=mainList.get(position).getStoreid();
        String  itemnamex=mainList.get(position).getItemname();
        String  itemurl=mainList.get(position).getItemimage();
        String storename=mainList.get(position).getStorename();
        String storepin=mainList.get(position).getStorepin();
        String storephonenumber=mainList.get(position).getStorephonenumber();
        String itemname=mainList.get(position).getItemname();
        String price=mainList.get(position).getPrice();
        String delivarymessage=mainList.get(position).getDelivarymessage();
        String itemimage=mainList.get(position).getItemimage();
        String itemdesc=mainList.get(position).getItemdesc();
        holder.price.setText(pricex);
        holder.itemname.setText(itemnamex);
        Glide.with(context).load(itemurl).thumbnail(0.25f).into(holder.imageView);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (storename!=null&&storephonenumber!=null&&storepin!=null&&Storeid!=null&&itemname!=null&&itemdesc!=null&&price!=null)
                {
                    Intent Intent = new Intent(context, Essentailcart.class);
                    Intent.putExtra("1",storename);
                    Intent.putExtra("2",Storeid);
                    Intent.putExtra("3",storepin);
                    Intent.putExtra("4",storephonenumber);
                    Intent.putExtra("5",itemname);
                    Intent.putExtra("6",price);
                    Intent.putExtra("7",delivarymessage);
                    Intent.putExtra("8",itemurl);
                    Intent.putExtra("9",itemdesc);
                    context.startActivity(Intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View mView;
        ImageView imageView;
        TextView itemname;
        TextView price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
            imageView=mView.findViewById(R.id.imageView20);
            itemname=mView.findViewById(R.id.textView20);
            price=mView.findViewById(R.id.textView21);
        }

    }
}
