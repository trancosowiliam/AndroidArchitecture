package br.com.dalcim.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.dalcim.architecture.activity.BaseActivity;

public class EventBusActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() { return R.layout.activity_event_bus;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
