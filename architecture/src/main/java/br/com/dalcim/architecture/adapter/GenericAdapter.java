package br.com.dalcim.architecture.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;

public class GenericAdapter extends BaseAdapter {
    private List<Object> itens;
    private Activity activity;

    public GenericAdapter(Activity activity, List<Object> itens) {
        this.itens = itens;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Object obj = itens.get(position);
        View v = (view != null) ? view : activity.getLayoutInflater().inflate((obj.getClass().getAnnotation(BindListView.class)).itemLayout(), null);

        Object valueField;
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                if(field.isAnnotationPresent(BindView.class)){
                    BindView anotacao = field.getAnnotation(BindView.class);
                    View componente = v.findViewById(anotacao.value());

                    field.setAccessible(true);
                    valueField = field.get(obj);
                    field.setAccessible(false);

                    if (componente instanceof TextView) {
                        ((TextView)componente).setText(valueField.toString());
                    }
                }
            } catch (Exception e) {}
        }
        return v;
    }
}
