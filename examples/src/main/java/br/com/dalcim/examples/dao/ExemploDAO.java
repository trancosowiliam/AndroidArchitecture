package br.com.dalcim.examples.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.dalcim.architecture.dao.BaseDAO;
import br.com.dalcim.architecture.global.BuildException;
import br.com.dalcim.architecture.model.Entity;
import br.com.dalcim.examples.global.DB;

public abstract class ExemploDAO<E extends Entity> extends BaseDAO<E> {
    public ExemploDAO(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder createTables = new StringBuilder();

        try {
            createTables.append(DB.FILME.getCreateQuery());
        } catch (BuildException e) {
            Log.e("LOG", DB.FILME.TABLE_NAME + ": " + e.getMessage());
        }

        db.execSQL(createTables.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
