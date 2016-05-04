package br.com.dalcim.butterknifeexemple.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import br.com.dalcim.architecture.activity.BaseActivity;
import br.com.dalcim.butterknifeexemple.R;
import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity{

    @Bind(R.id.main_edt_nome) EditText edtNome;
    @Bind(R.id.main_edt_ano_nascimento) EditText edtAnoNascimento;
    @Bind(R.id.main_txt_saida) TextView txtSaida;

    @Override protected int getLayoutResId() { return R.layout.activity_main; }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.main_btn_enviar)
    public void enviarOnClick(){
        int anoCorrente = Calendar.getInstance().get(Calendar.YEAR);
        int idade = anoCorrente - Integer.valueOf(edtAnoNascimento.getText().toString());
        String nome = edtNome.getText().toString();

        txtSaida.setText(nome + ", no final deste ano você tera: " + idade + "anos");
    }
}
