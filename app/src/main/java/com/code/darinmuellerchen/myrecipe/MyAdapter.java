package com.code.darinmuellerchen.myrecipe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    String data1[], data2[];
    Bitmap images[];
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[], Bitmap img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {


        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageBitmap(images[position]);
        //holder.myImage.setImageResource(images[position]);

        /*holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, PopupActivity.class);
                intent.putExtra("data1",data1[holder.getAdapterPosition()]);
                intent.putExtra("data2",data2[holder.getAdapterPosition()]);
                intent.putExtra("myImage",images[holder.getAdapterPosition()]);
                context.startActivity(intent);
            }
        });*/


    }


    @Override
    public int getItemCount() {
        return images.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.food_title);
            myText2 = itemView.findViewById(R.id.food_description);
            myImage = itemView.findViewById(R.id.food_picture);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
