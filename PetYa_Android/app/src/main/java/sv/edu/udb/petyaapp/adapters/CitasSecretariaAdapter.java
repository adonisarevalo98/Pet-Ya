package sv.edu.udb.petyaapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;

import sv.edu.udb.petyaapp.Edita_citaSecretaria;
import sv.edu.udb.petyaapp.R;
import sv.edu.udb.petyaapp.models.CitasSecretaria;

public class CitasSecretariaAdapter extends ArrayAdapter<CitasSecretaria> {
    ArrayList<CitasSecretaria>citaList;
    Context context;
    int resource;
    public CitasSecretariaAdapter(Context context, int resource, ArrayList<CitasSecretaria> citaList) {
        super(context, resource, citaList);

        this.citaList =citaList;
        this.context=context;
        this.resource=resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listcitas ,null,true);
        }
        CitasSecretaria citaList=getItem(position);

        TextView textView=(TextView)convertView.findViewById(R.id.nommascota);
        TextView textView1=(TextView)convertView.findViewById(R.id.fechadecita);
        TextView textView2=(TextView)convertView.findViewById(R.id.horadecita);
        TextView textView3=(TextView)convertView.findViewById(R.id.estadodecita);
        TextView textView4=(TextView)convertView.findViewById(R.id.encargadomascota);

        String concat="";
        String concat1="";
        String concat3="";
        String concat4="";
        String concat5="";
        concat= "Mascota: " + citaList.getNombre_mascota();
        concat1= "Fecha: " + citaList.getFecha_cita();
        concat3= "Hora: " + citaList.getHora();
        concat4= "Estado: " + citaList.getEstado();
        concat5= "Encargado: " + citaList.getId_cliente();
        textView.setText(concat);
        textView1.setText(concat1);
        textView2.setText(concat3);
        textView3.setText(concat4);
        textView4.setText(concat5);

        //Cuando mantenga presionado un registro, lo mandara a la otra actividad
        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent4 = new Intent(context, Edita_citaSecretaria.class);
                intent4.putExtra("idcita",citaList.getId());
                intent4.putExtra("idCliente",citaList.getId_cliente());
                intent4.putExtra("mascota",citaList.getNombre_mascota());
                intent4.putExtra("especie",citaList.getEspecie());
                intent4.putExtra("raza",citaList.getRaza());
                intent4.putExtra("motivo",citaList.getMotivo());
                intent4.putExtra("fecha",citaList.getFecha_cita());
                intent4.putExtra("hora",citaList.getHora());
                intent4.putExtra("edad",citaList.getEdad());
                intent4.putExtra("sexo",citaList.getSexo());
                intent4.putExtra("hora",citaList.getHora());
                intent4.putExtra("color",citaList.getColor());
                intent4.putExtra("vacuna",citaList.getVacunacion());
                intent4.putExtra("id_empleado",citaList.getIdEmpleado());
                intent4.putExtra("cliente_uid",citaList.getClienteUid());
                intent4.putExtra("accion","e");
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent4);
                return true;
            }
        });

        return convertView;
    }



}
