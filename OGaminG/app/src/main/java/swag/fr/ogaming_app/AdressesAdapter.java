package swag.fr.ogaming_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hornet on 30/05/2017.
 */
@SuppressWarnings("DefaultFileTemplate")
public class AdressesAdapter extends RecyclerView.Adapter<AdressesAdapter.MyViewHolder> {
    private  static List<Address> adress;
    private final Context ct;
    public AdressesAdapter(Context t) {
        adress = new ArrayList<>();
        ct=t;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adress_item_simple, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.Desc1.setText(adress.get(position).getAddressLine());
        holder.Desc2.setText(adress.get(position).getCity()+", "+adress.get(position).getCountry());



    }

    @Override
    public int getItemCount() {
        return adress.size();
    }

    public void setData(ArrayList<Address> data) {
        adress = data;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView Desc1;
        public final TextView Desc2;

            public final View v;
            public MyViewHolder(View view) {
                super(view);

                v=view;
                Desc1= (TextView) view.findViewById(R.id.Add_1);
                Desc2= (TextView) view.findViewById(R.id.Add_2);


            }
        }

}
