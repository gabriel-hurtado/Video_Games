package swag.fr.ogaming_app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hornet on 30/05/2017.
 */
public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.MyViewHolder> {
    private  static List<Game> games;
    public GamesAdapter(List<Game> g) {
        this.games = g;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.Nom.setText(games.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public final TextView Nom;

            public final View v;
            public MyViewHolder(View view) {
                super(view);

                v=view;
                Nom= (TextView) view.findViewById(R.id.Nom);
            }
        }

}
