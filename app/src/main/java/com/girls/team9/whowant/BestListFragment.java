package com.girls.team9.whowant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

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

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

                        getListData();

//                        switch (cur_job) {
//                            case 0:
//                                getListData("plan");
//                                break;
//                            case 1:
//                                getListData("dev");
//                                break;
//                            case 2:
//                                getListData("dis");
//                                break;
//                            default:
//                                break;
//                        }
                    }
                });
            }
        }).start();
    }

    private void getListData() {

        BestRecyclerItem item;
        item = new BestRecyclerItem(R.drawable.ex, "Test 에코백", "10,000 원");
        items.add(item);items.add(item);items.add(item);items.add(item);
        recyclerView.setAdapter(new RecyclerAdpater(getActivity(), items, R.layout.item_best_recycler, 0));
        progressBar.setVisibility(View.GONE);
    }


}//class
