package br.com.dalcim.architecture.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity{

    /* CONTRACT  */
    protected abstract int getLayoutResId();

    /* LIFE CICLE */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
    }

    /* NAVIGATION */
    protected void startActivity(Class c){
        startActivity(new Intent(this, c));
    }

    /* OUTPUTS MESSAGE */
    protected void showLongMessage(String txt){
        Toast.makeText(this, txt, Toast.LENGTH_LONG).show();
    }

    protected void showShortMessage(String txt){
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }

}
