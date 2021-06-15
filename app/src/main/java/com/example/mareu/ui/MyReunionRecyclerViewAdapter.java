package com.example.mareu.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.models.Reunion;
import com.example.mareu.services.ReunionApiService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyReunionRecyclerViewAdapter extends RecyclerView.Adapter<MyReunionRecyclerViewAdapter.ViewHolder> {


    private List<Reunion> mReunions;
    Context context;

    private  ReunionApiService apiService;

    public MyReunionRecyclerViewAdapter(List<Reunion> items) { mReunions = items; }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_reunion, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder (final ViewHolder holder, int position) {
        ReunionApiService reunionApiService= DI.getReunionApiService();
        Reunion reunion = mReunions.get(position);
        holder.mReunionSubject.setText(reunion.getSubject());
        Glide.with(holder.mReunionAvatar.getContext())
                .load(reunion.getAvatarUrl())
               // .apply(RequestOptions.circleCropTransform())
                .into(holder.mReunionAvatar);
        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                reunionApiService.deleteReunion(reunion);
                setData(reunionApiService.getReunions());
            }

        });






    }

    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public void setData(List<Reunion> list) {
        this.mReunions=list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_subject)
        public TextView mReunionSubject;
        @BindView(R.id.item_delete)
        public ImageButton mDeleteButton;
        @BindView(R.id.item_list_avatar)
        public ImageView mReunionAvatar;


        public ViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

}
