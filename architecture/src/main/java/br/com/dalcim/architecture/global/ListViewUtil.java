package br.com.dalcim.architecture.global;

import android.app.Activity;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.dalcim.architecture.adapter.GenericAdapter;
import br.com.dalcim.architecture.adapter.BindListView;

public abstract class ListViewUtil{

    public static ListView geraListView(ArrayList obj, Activity activity){
        int idListView = (obj.get(0).getClass().getAnnotation(BindListView.class)).idListView();
        ListView listView = (ListView) activity.findViewById(idListView);
        GenericAdapter adapter = new GenericAdapter(activity, obj);
        listView.setAdapter(adapter);

        return listView;
    }
}
