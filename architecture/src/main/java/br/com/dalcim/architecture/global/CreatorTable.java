package br.com.dalcim.architecture.global;

import java.util.ArrayList;

public abstract class CreatorTable {

    public final static int INTEGER = 1;
    public final static int TEXT = 2;
    public final static int REAL = 3;
    public final static int BLOB = 4;

    public static class Builder{
        private String table;
        private String primaryKeyName = "ID";
        private ArrayList<String[]> columns = new ArrayList<>();


        public Builder setTable(String table) {
            this.table = table;
            return this;
        }

        public Builder addColumn(String name, int type){
            columns.add(new String[]{name, getTypeValueOf(type)});
            return this;
        }

        public Builder setPrimaryKeyName(String name){
            this.primaryKeyName = name;
            return this;
        }

        public String makeCreateQuery() throws BuildException {
            if (table.trim().length() == 0 ) throw new BuildException("TABLE is empty");
            if (columns.size() == 0) throw new BuildException("No column found");

            StringBuilder stb = new StringBuilder();

            stb.append("CREATE TABLE " + table + " (");
            stb.append(primaryKeyName + " INTEGER PRIMARY KEY");

            for (String[] values : columns){
                stb.append(", ");
                stb.append(values[0]);
                stb.append(" ");
                stb.append(values[1]);
            }

            stb.append("); ");

            return stb.toString();
        }

        private String getTypeValueOf(int type) {
            switch (type){
                case INTEGER: return "INTEGER";
                case TEXT: return "TEXT";
                case REAL: return "REAL";
                case BLOB: return "BLOB";
            }

            return "";
        }


    }

}
