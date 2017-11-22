package com.hap.music163demo.ui.activitys.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hap.music163demo.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(gerLayoutId());
        assignViews();
        onViewReady();
    }

    public void assignViews() {}
    public void onViewReady() {}
  public int gerLayoutId(){
        return R.layout.activity_base;
  }

    @Override
    public void onClick(View view) {

    }
}
