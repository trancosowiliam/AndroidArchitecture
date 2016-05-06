package br.com.dalcim.exemples.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.com.dalcim.architecture.activity.BaseActivity;
import br.com.dalcim.exemples.R;
import br.com.dalcim.exemples.dao.FilmeDAO;
import br.com.dalcim.exemples.model.Filme;
import butterknife.Bind;

public class CadastroFilmeActivity extends BaseActivity {

    @Bind(R.id.cif_edt_nome) EditText edtNome;
    @Bind(R.id.cif_edt_ano) EditText edtAno;

    private Filme filme;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_cadastro_filme;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        filme = (Filme) intent.getSerializableExtra("EDITAR_FILME");

        if(filme != null){
            edtNome.setText(filme.getNome());
            edtAno.setText(filme.getAnoLancamento() + "");
        }else{
            filme = new Filme();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cfi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.cfi_itm_salvar:
                salvar();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void salvar() {
        filme.setNome(edtNome.getText().toString());
        filme.setAnoLancamento(Integer.valueOf(edtAno.getText().toString()));

        FilmeDAO dao = new FilmeDAO(this);
        dao.save(filme);
    }
}
