package com.onesystem.marcador.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.onesystem.marcador.R;

import java.util.ArrayList;
import java.util.Collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LocalAdapter extends BaseAdapter {
    private final Context context;
    private final LayoutInflater inflater;
    private final ArrayList<PresenceInfo> arrayList;

    public LocalAdapter(Context context, ArrayList<PresenceInfo> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return arrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(context).inflate(R.layout.presence_list_item,parent);

        TextView data = view.findViewById(R.id.dia_trabalho);
        TextView entrada = view.findViewById(R.id.txtHoraEntrada);
        TextView atraso = view.findViewById(R.id.txtTempoAtraso);
        TextView saida = view.findViewById(R.id.txtHoraSaida);

        data.setText(arrayList.get(position).getFormattedDay());
        saida.setText(arrayList.get(position).getSaida());
        atraso.setText(arrayList.get(position).getAtraso());
        entrada.setText(arrayList.get(position).getEntrada());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked: "+position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
