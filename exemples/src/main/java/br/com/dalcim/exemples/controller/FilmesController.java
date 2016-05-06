package br.com.dalcim.exemples.controller;

import br.com.dalcim.architecture.controller.BaseController;
import br.com.dalcim.exemples.activity.FilmesActivity;
import br.com.dalcim.exemples.dao.FilmeDAO;
import br.com.dalcim.exemples.model.Filme;

public class FilmesController extends BaseController<FilmesActivity> {

    public FilmesController(FilmesActivity activity) {
        super(activity);
    }

    public void atualizaListaFilmes() {
        FilmeDAO dao = new FilmeDAO(activity);
        activity.setFilmes(dao.getList());
        activity.atualizaLista();
    }

    public void deletaFilme(Filme filme) {
        FilmeDAO dao = new FilmeDAO(activity);
        dao.delete(filme);

        activity.removeFilmeLista(filme);
        activity.atualizaLista();
    }
}
