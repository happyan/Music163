package com.hap.music163demo.ui.fragments.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hap.music163demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{


    public AndroidFragment() {
        // Required empty public constructor
    }
    private SwipeRefreshLayout srlAndroid;
    private RecyclerView rvAndroid;

    private void assignViews(View view) {
        srlAndroid = (SwipeRefreshLayout) view.findViewById(R.id.srl_android);
        rvAndroid = (RecyclerView) view.findViewById(R.id.rv_android);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        assignViews(view);
        return view;
    }

    /**
     * OnRefreshListener的回调
     */
    @Override
    public void onRefresh() {

    }
}
