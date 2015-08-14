package com.girls.team9.whowant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyemi on 2015-08-13.
 */
public class BestListFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FrameLayout cur_container;
    int cur_job;
    List<BestRecyclerItem> items;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        cur_container=(FrameLayout)inflater.inflate(R.layout.fragment_best, container, false);
        recyclerView=(RecyclerView)cur_container.findViewById(R.id.recyclerview);
        progressBar=(ProgressBar)cur_container.findViewById(R.id.progressbar);

        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        items=new ArrayList<>();

        return cur_container;
    }

    @Override
    public void onResume() {
        super.onResume();
        new Thread(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.VISIBLE);
                        items.clear();

                        getList();

                    }
                });
            }
        }).start();
    }

    private void getList() {
        BestRecyclerItem item;
        item = new BestRecyclerItem(R.drawable.e, "Test 에코백", "15,000 원");
        items.add(item);
        item = new BestRecyclerItem(R.drawable.p, "Test 후원 팔찌", "2,000 원");
        items.add(item);
        item = new BestRecyclerItem(R.drawable.s, "Test 스냅백", "25,000 원");
        items.add(item);
        recyclerView.setAdapter(new RecyclerAdpater(getActivity(), items, R.layout.item_best_recycler, 0));
        progressBar.setVisibility(View.GONE);
    }//getList

}//class
