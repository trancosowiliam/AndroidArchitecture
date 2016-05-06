package br.com.dalcim.examples.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

import br.com.dalcim.architecture.activity.BaseActivity;
import br.com.dalcim.examples.R;
import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnLongClick;
import butterknife.OnTextChanged;
import butterknife.OnTouch;

public class ButterKnife extends BaseActivity {

    @Bind(R.id.bk_txt_hora)
    TextView txtHora;

    @Bind(R.id.bk_lst_exemplo)
    ListView lstExemplo;

    String[] lista = new String[]{"Item0", "Item1", "Item2"};

    @Override
    protected int getLayoutResId() { return R.layout.activity_butter_knife; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        txtHora.setText(Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE));

        lstExemplo.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista));
    }

    @OnCheckedChanged(R.id.bk_ckb_oncheckedchanged)
    void onCheckedChanged(boolean checked) {
        showShortMessage("onCheckChanged: " + (checked ? "Checked!" : "Unchecked!"));
    }

    @OnClick(R.id.bk_btn_onclick)
    void onClick(){
        showShortMessage("OnCkick");
    }

//    @OnEditorAction(R.id.bk_edt_oneditoraction)
//    boolean onEditorAction(KeyEvent key) {
//        showShortMessage("Pressed: " + key);
//        return true;
//    }

    @OnFocusChange(R.id.bk_edt_onfocuschange)
    void onFocusChanged(boolean focused) {
        showShortMessage("onFocusChanged: " + (focused ? "Focused!" : "UnFocused!"));
    }

    @OnLongClick(R.id.bk_btn_onlongclick)
    boolean onLongClick() {
        showShortMessage("Long clicked!");
        return true;
    }

    @OnTextChanged(R.id.bk_edt_ontextchanged)
    void onTextChanged(CharSequence text) {
        showShortMessage("Texto alterado: " + text);
    }

    @OnTextChanged(value = R.id.bk_edt_ontextchanged, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void onBeforeTextChanged(CharSequence text) {
        showShortMessage("Texto anterio: " + text);
    }

    @OnTouch(R.id.bk_view_ontouch)
    boolean onTouch() {
        showShortMessage("Touched!");
        return false;
    }

    @OnItemClick(R.id.bk_lst_exemplo)
    void onItemClick(int position) {
        showShortMessage("OnItemClick: " + position + " - " + lista[position]);
    }

    @OnItemLongClick(R.id.bk_lst_exemplo)
    boolean  onItemLongClick(int position) {
        showShortMessage("OnItemLongClick: " + position + " - " + lista[position]);
        return true;
    }
}
