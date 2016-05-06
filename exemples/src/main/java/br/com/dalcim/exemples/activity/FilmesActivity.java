package br.com.dalcim.exemples.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.com.dalcim.architecture.activity.BaseActivity;
import br.com.dalcim.exemples.R;
import br.com.dalcim.exemples.controller.FilmesController;
import br.com.dalcim.exemples.model.Filme;
import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;

public class FilmesActivity extends BaseActivity{

    // COMPONENTES
    @Bind(R.id.fil_lst_filmes) ListView lstFilmes;

    private List<Filme> filmes;
    private ArrayAdapter<Filme> adapter;

    private FilmesController controller;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_filmes;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new FilmesController(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        controller.atualizaListaFilmes();
    }

    public void atualizaLista() {
        adapter = new ArrayAdapter<Filme>(this, android.R.layout.simple_list_item_1, filmes);
        lstFilmes.setAdapter(adapter);
    }

    @OnClick(R.id.fil_btn_novo)
    public void onClickBtnNovo(){
        startActivity(CadastroFilmeActivity.class);
    }

    @OnItemLongClick(R.id.fil_lst_filmes)
    public boolean onItemLongClick(final int position) {
        final Filme filme = filmes.get(position);

        new AlertDialog.Builder(FilmesActivity.this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Deletar")
                .setMessage("Deseja deletar '" + filme.getNome() + "'?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        controller.deletaFilme(filme);
                    }
                })
                .setNegativeButton("Não", null)
                .show();
        return true;
    }

    @OnItemClick(R.id.fil_lst_filmes)
    public void onItemClick(int position){
        Filme filmeSelecionado = filmes.get(position);
        Intent intent = new Intent(FilmesActivity.this, CadastroFilmeActivity.class);
        intent.putExtra("EDITAR_FILME", filmeSelecionado);
        startActivity(intent);
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void removeFilmeLista(Filme filme) {
        filmes.remove(filme);
    }
}
