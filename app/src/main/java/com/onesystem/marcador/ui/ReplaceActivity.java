package com.onesystem.marcador.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.onesystem.marcador.R;
import com.onesystem.marcador.model.Missao;
import com.onesystem.marcador.model.PresenceInfo;

import java.util.ArrayList;
import java.util.Date;

public class ReplaceActivity extends AppCompatActivity {
    private ArrayList<Missao> arrayList;
    private LocalAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace);

        listView = findViewById(R.id.listview);
        arrayList = new ArrayList<>();
        fill();
        adapter = new LocalAdapter(ReplaceActivity.this, arrayList);
        listView.setAdapter(adapter);
    }

    public void fill(){

        Missao m = new Missao();
        m.setContacto("86 222 2222");
        m.setDay(new Date());
        m.setLocalizacao("Manhiça");
        m.setTipoProtecao("Moradia");
        arrayList.add(m);

        Missao m1 = new Missao();
        m1.setContacto("86 121 1212");
        m1.setDay(new Date());
        m1.setLocalizacao("Matola");
        m1.setTipoProtecao("Pessoal");
        arrayList.add(m1);

        Missao m2 = new Missao();
        m2.setContacto("86 657 7677");
        m2.setDay(new Date());
        m2.setLocalizacao("C. Maputo");
        m2.setTipoProtecao("Empresa");
        arrayList.add(m2);

        Missao mm = new Missao();
        mm.setContacto("86 090 0999");
        mm.setDay(new Date());
        mm.setLocalizacao("Marracuene");
        mm.setTipoProtecao("Empresa");
        arrayList.add(mm);

        Missao m3 = new Missao();
        m3.setContacto("86 121 1212");
        m3.setDay(new Date());
        m3.setLocalizacao("Magude");
        m3.setTipoProtecao("Propriedade");
        arrayList.add(m3);
    }

    public class LocalAdapter extends BaseAdapter {
        private final Context context;
        private final LayoutInflater inflater;
        private final ArrayList<Missao> arrayList;
        private AlertDialog dialog;

        public LocalAdapter(Context context, ArrayList<Missao> arrayList) {
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
            view = inflater.inflate(R.layout.replace_list_item, null);

            TextView data = view.findViewById(R.id.dia_trabalho);
            TextView local = view.findViewById(R.id.txtLocalizacao);
            TextView tipo = view.findViewById(R.id.txtTipoProtecao);
            TextView contacto = view.findViewById(R.id.txtContacto);

            data.setText(PresenceActivity.df.format(arrayList.get(position).getDay()));
            tipo.setText(arrayList.get(position).getTipoProtecao());
            local.setText(arrayList.get(position).getLocalizacao());
            contacto.setText(arrayList.get(position).getContacto());
            return view;
        }

    }
}