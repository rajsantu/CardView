package com.mainpackage.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // 1- Data
    private final Context context;
    private final ArrayList<GameModel> gamesList;

    // 2- Constructor
    public MyAdapter(Context context, ArrayList<GameModel> gamesList) {
        this.context = context;
        this.gamesList = gamesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GameModel model = gamesList.get(position);
        holder.gameTitle.setText(model.getGameName());
        holder.gameImg.setImageResource(model.getGameImg());


        // Handle the click events
        holder.itemView.setOnClickListener(view -> Toast.makeText(context, String.format("You choose: %s", gamesList.get(position).getGameName()), Toast.LENGTH_SHORT).show());

    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    // 3- View Holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView gameImg;
        private final TextView gameTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gameImg = itemView.findViewById(R.id.cardviewImg);
            gameTitle = itemView.findViewById(R.id.textviewCard);
        }
    }


}
