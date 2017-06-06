package swag.fr.ogaming_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hornet on 30/05/2017.
 */
public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.MyViewHolder> {
    private  static List<Game> games;
    Context ct;
    public GamesAdapter(Context t) {
        games = new ArrayList<>();
        ct=t;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.Nom.setText(games.get(position).getTitle());
        holder.prix.setText(String.format("%s€", String.valueOf(games.get(position).getPrice())));
        Picasso.with(ct)
                .load(games.get(position).getPicture())
                .placeholder(R.drawable.knights_1920x1200) //optional
                .resize(1000, 1000)         //optional
                .centerCrop()                        //optional
                .into( holder.pi);
        ArrayList<Gametype> g= (ArrayList<Gametype>) games.get(position).getGametype();
        ArrayList<Consoles> v = (ArrayList<Consoles>) games.get(position).getConsole();
        String msg="A ";
        for (Gametype ga:g
                ) {
            msg=msg+ga.getName()+", ";
        }
        msg=msg+"played on ";
        for (Consoles x:v
                ) {
            msg=msg+x.getName()+", ";
        }
        msg=msg+"enjoy it !";
        holder.txt.setText(msg);

    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public void setData(JSONArray data) {

        this.games =new ArrayList<>();
        if (data != null) {
            for (int i=0;i<data.length();i++){
                //int id,String title,String picture,Double price,List<Consoles> v,List<Gametype> g
            //{"id":6,"title":"The Legend of Zelda","picture":"http:\/\/img.cwol.fr\/2015\/03\/Zelda-DFT.jpg","price":88,"consoles":[{"name":"PC"},{"name":"PS4"}],"gameTypes":[{"name":"RTS"},{"name":"FPS"}]}
                try {
                    JSONObject itm=data.getJSONObject(i);
                    JSONArray v=itm.getJSONArray("consoles");
                    ArrayList<Consoles> consoles =new ArrayList<>();
                    for (int j=0;j<v.length();j++){
                        consoles.add(new Consoles(v.getJSONObject(j).getString("name") ));
                    }

                    JSONArray g=itm.getJSONArray("gameTypes");
                    ArrayList<Gametype> gam =new ArrayList<>();
                    for (int j=0;j<g.length();j++){
                        gam.add(new Gametype(g.getJSONObject(j).getString("name") ));
                    }
                    this.games.add(new Game(itm.getInt("id"),itm.getString("title"),itm.getString("picture"),itm.getDouble("price"),consoles,gam));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView Nom;
        public final TextView txt;
        public final ImageView pi;
        public final TextView prix;

            public final View v;
            public MyViewHolder(View view) {
                super(view);

                v=view;
                Nom= (TextView) view.findViewById(R.id.Nom);
                prix= (TextView) view.findViewById(R.id.prix);
                txt= (TextView) view.findViewById(R.id.Desc);
                pi=(ImageView) view.findViewById(R.id.thumbnail);


            }
        }

}
