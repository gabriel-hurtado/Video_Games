package swag.fr.ogaming_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hornet on 06/06/2017.
 */
public class ConsolesFragment extends Fragment {
    private RecyclerView mRecyclerView;

    private ConsolesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ConsolesFragment(){

    }

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_games, container, false);

        mAdapter=new ConsolesAdapter(populate());
        mRecyclerView = (RecyclerView) v.findViewById(R.id.items_list);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    private List<Consoles> populate() {
        List<Consoles> cons = new ArrayList<>();

        //populate list

        return cons;
    }



}
