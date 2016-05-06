package br.com.dalcim.exemples.global;

import br.com.dalcim.architecture.global.BuildException;
import br.com.dalcim.architecture.global.CreatorTable;

public abstract class DB extends br.com.dalcim.architecture.global.DB {

    public abstract static class FILME {
        public final static String TABLE_NAME = "FILME";
        public final static String COLUMN_NOME = "NOME";
        public final static String COLUMN_ANO_LANCAMENTO = "ANO_LANCAMENTO";

        public static String getCreateQuery() throws BuildException {
            return new CreatorTable.Builder()
                    .setTable(TABLE_NAME)
                    .setPrimaryKeyName(COLUMN_ID)
                    .addColumn(COLUMN_NOME, CreatorTable.TEXT)
                    .addColumn(COLUMN_ANO_LANCAMENTO, CreatorTable.INTEGER)
                    .makeCreateQuery();
        }
    }
}
