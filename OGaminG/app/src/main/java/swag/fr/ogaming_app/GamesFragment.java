package swag.fr.ogaming_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Hornet on 06/06/2017.
 */
@SuppressWarnings("DefaultFileTemplate")
public class GamesFragment extends Fragment {

    private GamesAdapter mAdapter;

    public GamesFragment(){

    }





    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_games, container, false);

        mAdapter=new GamesAdapter(getContext());
        populate();
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.items_list);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    private void populate() {
        final List<Game> games = new ArrayList<>();
        /**fake
        games.add(new Game(1,"Age of E",5.0));
        games.add(new Game(1,"Age of E",5.0));
        games.add(new Game(1,"Age of E",5.0));
        games.add(new Game(1,"Age of E",5.0));
        **/
        //TODO show loading

        String url="http://10.0.2.2:8080/Video_Games/VideoGamesManager";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                JSONArray json=null;

                try {
                    String response=new String(responseBody, "UTF-8");
                    json=new JSONArray(response);
                } catch (JSONException | UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //TODO

                mAdapter.setData(json);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }



}
