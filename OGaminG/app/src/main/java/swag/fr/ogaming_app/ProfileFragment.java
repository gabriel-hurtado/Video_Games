package swag.fr.ogaming_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Hornet on 06/06/2017.
 */
@SuppressWarnings("DefaultFileTemplate")
public class ProfileFragment extends Fragment {
    private TextView name;
    private TextView desc;
    private ImageView back;
    private AdressesAdapter mAdapter;
    private ImageView profile;

    public ProfileFragment(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        name= (TextView) v.findViewById(R.id.user_profile_name);
        desc= (TextView) v.findViewById(R.id.user_profile_short_bio);
        back= (ImageView) v.findViewById(R.id.header_cover_image);
        profile= (ImageView) v.findViewById(R.id.user_profile_photo);


        mAdapter=new AdressesAdapter(getContext());
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.AddressList);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);


        populate();
        return v;
    }


    private void populate() {

        //TODO show loading

        String url="http://10.0.2.2:8080/Video_Games/ClientsManager?";
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getContext());
        String id = pref.getString("id", "");
        String urlWithParam=url+"id="+id;
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(urlWithParam, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                JSONObject json;

                String response ;
                try {
                    response = new String(responseBody, "UTF-8");
                    json = new JSONObject(response);
                    upateView(json);
                } catch (JSONException | UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    private void upateView(JSONObject json) throws JSONException {
        String nameToPrint=json.getString("username")+" / "+json.getString("name")+" "+json.getString("surname");
        String des= json.getString("description");
        desc.setText(des);
        name.setText(nameToPrint);
        String backgroupLink=json.getString("backgroundPicture");
        String profileLink=json.getString("picture");

        Picasso.with(getContext())
                .load(backgroupLink)
                .placeholder(R.drawable.ic_cached_black_48dp) //optional
                .resize(1000, 1000)         //optional
                .centerCrop()                        //optional
                .into( back);

        Picasso.with(getContext())
                .load(profileLink)
                .placeholder(R.drawable.ic_cached_black_48dp) //optional
                .resize(1000, 1000)         //optional
                .centerCrop()                        //optional
                .transform(new CircleTransform())
                .into( profile);


        JSONArray ad=json.getJSONArray("address");
        ArrayList<Address> addresses =new ArrayList<>();
        for (int j=0;j<ad.length();j++){
            //(String address_line, String city, String country
            addresses.add(new Address(ad.getJSONObject(j).getString("address_line"),ad.getJSONObject(j).getString("city"),ad.getJSONObject(j).getString("country")));
        }
        mAdapter.setData(addresses);
        mAdapter.notifyDataSetChanged();
    }


}
