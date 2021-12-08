package com.code.darinmuellerchen.myrecipe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    String data1[];
    Bitmap images[];
    Context context;


    private RecyclerViewCLickListener listener;


    public MyAdapter(Context ct, String s1[], Bitmap img[], RecyclerViewCLickListener listener){
        context = ct;
        data1 = s1;
        images = img;
        this.listener = listener;
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
        holder.myImage.setImageBitmap(images[position]);


    }


    @Override
    public int getItemCount() {
        return images.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;
        Button delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.food_title);
            myText2 = itemView.findViewById(R.id.food_description);
            myImage = itemView.findViewById(R.id.food_picture);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            delete = itemView.findViewById(R.id.btn_delete);
            itemView.setOnClickListener(this);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAbsoluteAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAbsoluteAdapterPosition());
        }

    }

    public interface RecyclerViewCLickListener{
        void onClick(View v, int position);
        void onDeleteClick(int position);
    }
}
