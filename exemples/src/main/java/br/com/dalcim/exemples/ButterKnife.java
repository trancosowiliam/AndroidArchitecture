package br.com.dalcim.exemples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.dalcim.architecture.activity.BaseActivity;

public class ButterKnife extends BaseActivity {

    @Override
    protected int getLayoutResId() { return R.layout.activity_butter_knife; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
