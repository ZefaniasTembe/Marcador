package com.onesystem.marcador.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.onesystem.marcador.R;
import com.onesystem.marcador.model.PresenceInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PresenceActivity extends AppCompatActivity {

    private ArrayList<PresenceInfo> arrayList;
    private LocalAdapter adapter;
    private ListView listView;
    private FloatingActionButton floatingActionButton;

    public static final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
    public static final SimpleDateFormat hf = new SimpleDateFormat("HH:mm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presence);

        listView = findViewById(R.id.presenceList);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        arrayList = new ArrayList<>();
        fill();
        adapter = new LocalAdapter(PresenceActivity.this, arrayList);
        listView.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date day = new Date();
                PresenceInfo p = new PresenceInfo(day);
                p.setEntrada(hf.format(day));
                arrayList.add(p);
                adapter = new LocalAdapter(PresenceActivity.this, arrayList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void fill(){
        for (int i = 0; i < 9; i++) {
            PresenceInfo p = new PresenceInfo(new Date());
            p.setAtraso("1:06");
            p.setEntrada("7:06");
            p.setSaida("18:06");
            arrayList.add(p);
        }
    }


    public class LocalAdapter extends BaseAdapter {
        private final Context context;
        private final LayoutInflater inflater;
        private final ArrayList<PresenceInfo> arrayList;
        private AlertDialog dialog;

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
            view = inflater.inflate(R.layout.presence_list_item, null);

            TextView data = view.findViewById(R.id.dia_trabalho);
            TextView entrada = view.findViewById(R.id.txtHoraEntrada);
            TextView atraso = view.findViewById(R.id.txtTempoAtraso);
            TextView saida = view.findViewById(R.id.txtHoraSaida);

            data.setText(arrayList.get(position).getFormattedDay());
            atraso.setText(arrayList.get(position).getAtraso());
            entrada.setText(arrayList.get(position).getEntrada());

            if(!arrayList.get(position).getSaida().equals(null) || !arrayList.get(position).getSaida().equalsIgnoreCase("")){
                saida.setText(arrayList.get(position).getSaida());
            }else{
                saida.setText("---");
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Registo de Saída");
            builder.setMessage("Pretende efectuar o registo ad saída agora?");
            builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    saida.setText(PresenceActivity.hf.format(new Date()));
                }
            });

            builder.setNegativeButton("Confirmar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                }
            });

            dialog = builder.create();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (saida.getText().equals("---")) dialog.show();
                }
            });

            return view;
        }

    }
}