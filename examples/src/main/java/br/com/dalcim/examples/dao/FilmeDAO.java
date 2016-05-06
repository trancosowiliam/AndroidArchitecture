package br.com.dalcim.examples.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import br.com.dalcim.examples.global.DB;
import br.com.dalcim.examples.model.Filme;

public class FilmeDAO extends ExemploDAO<Filme> {

    public FilmeDAO(Context context) {
        super(context);
    }

    @Override
    protected Filme cursorToEntity(Cursor c) {

        Filme filme = new Filme();
        filme.setId(c.getLong(c.getColumnIndex(DB.COLUMN_ID)));
        filme.setNome(c.getString(c.getColumnIndex(DB.FILME.COLUMN_NOME)));
        filme.setAnoLancamento(c.getInt(c.getColumnIndex(DB.FILME.COLUMN_ANO_LANCAMENTO)));

        return filme;
    }

    @Override
    protected ContentValues entityToContentValues(Filme entity) {
        ContentValues cv = new ContentValues();

        cv.put(DB.FILME.COLUMN_NOME, entity.getNome());
        cv.put(DB.FILME.COLUMN_ANO_LANCAMENTO, entity.getAnoLancamento());

        return cv;
    }

    @Override
    protected String getTable() {
        return DB.FILME.TABLE_NAME;
    }
}
