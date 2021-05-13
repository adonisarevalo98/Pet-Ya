package sv.edu.udb.petyaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sv.edu.udb.petyaapp.config.Config;
import sv.edu.udb.petyaapp.interfaces.DiagnosticosVetService;
import sv.edu.udb.petyaapp.interfaces.FormCitaService;
import sv.edu.udb.petyaapp.models.CitasSecretaria;
import sv.edu.udb.petyaapp.models.Diagnosticos;

public class Realiza_Diagnostico extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //Variables para almacenar datos recibidos
    int idCita = 0;
    //demas variables

    String hora="";
    String edad ="";
    String sexo="";
    String color="";
    String vacunacion="";
    String estado = "finalizado";
    int idEmpleado=0;
    String peso ="";
    String pulso="";
    String temperatura="";
    int idCLiente=0;
    String  clienteUid = "";
    String diagnostico = "";
    String tratamiento = "";

    TextInputEditText  txtEDTDiagnostico, txtEDTTratamiento,txtEDTVacu,txtEDTsexo, txtEDTHora, txtEDTCliente, txtEDTFecha, txtEDTNombre, txtEDTEdad, txtEDTEspecie, txtEDTRaza, txtEDTMotivo, textEDTPeso, textEDTPulso, textEDTTemperatura;
    Button btnRealizaDiag;

    //Llamando al servicio de formcita para actualizar el registro
    private FormCitaService formCitaservicio = Config.getRetrofit().create(FormCitaService.class);


    private DiagnosticosVetService DiagServicio = Config.getRetrofit().create(DiagnosticosVetService.class);

    //Variable para gestionar FirebaseAuth
    private FirebaseAuth mAuth;

    //Variables opcionales para desloguear de google tambien
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInOptions gso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realiza__diagnostico);

        // Inicializar Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
//Configurar las gso para google signIn con el fin de luego desloguear de google
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        /*******Menu********/
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //Colocando correo e imagen en el header del perfil:
        View header = navigationView.getHeaderView(0);
        TextView txtemail = (TextView) header.findViewById(R.id.txtCorreo);
        txtemail.setText(currentUser.getEmail());

        // cargar imágen con glide:
        ImageView imagenUser = (ImageView) header.findViewById(R.id.imagenUser);
        if (currentUser.getPhotoUrl() != null) {
            Glide.with(this).load(currentUser.getPhotoUrl()).into(imagenUser);
        }


        txtEDTCliente = findViewById(R.id.idCliente);
        txtEDTFecha = findViewById(R.id.fecha_cita);
        txtEDTNombre = findViewById(R.id.nombre_mascota);
        txtEDTsexo = findViewById(R.id.sexo);
        txtEDTEspecie = findViewById(R.id.especie);
        txtEDTRaza = findViewById(R.id.raza);
        txtEDTMotivo = findViewById(R.id.motivo_cita);
        textEDTPeso = findViewById(R.id.edtpeso);
        textEDTPulso = findViewById(R.id.edtpulso);
        textEDTTemperatura = findViewById(R.id.edttemperatura);
        txtEDTHora = findViewById(R.id.hora);
        txtEDTDiagnostico = findViewById(R.id.diagnostico);
        txtEDTTratamiento = findViewById(R.id.tratamiento);
        txtEDTVacu = findViewById(R.id.vacunacion);
        txtEDTEdad = findViewById(R.id.edad);

        btnRealizaDiag = findViewById(R.id.actualizarBTN);

        //obtenemos los valores que fueron enviados
        inicializaInterface();

        //toolbar
        setSupportActionBar(toolbar);

        //Navigation Drawer Menu

        //ocultar o mostrar items
        Menu menu = navigationView.getMenu();

        //end ocultar o mostrar items

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        /*******End Menu********/

        /***accion del boton Actualizar **/
        btnRealizaDiag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                realizarDiag();
            }
        });


    }

    private void inicializaInterface(){
        Bundle datosParam = getIntent().getExtras();
        txtEDTCliente.setText(datosParam.getString("idCliente"));
        txtEDTNombre.setText(datosParam.getString("mascota"));
        txtEDTEspecie.setText(datosParam.getString("especie"));
        txtEDTRaza.setText(datosParam.getString("raza"));
        txtEDTMotivo.setText(datosParam.getString("motivo"));
        txtEDTFecha.setText(datosParam.getString("fecha"));
        txtEDTsexo.setText(datosParam.getString("sexo"));
        textEDTPeso.setText(datosParam.getString("peso"));
        textEDTPulso.setText(datosParam.getString("pulso"));
        textEDTTemperatura.setText(datosParam.getString("temperatura"));
        txtEDTHora.setText(datosParam.getString("hora"));
        txtEDTVacu.setText(datosParam.getString("vacuna"));
        txtEDTEdad.setText(datosParam.getString("edad"));

        //llenando variables
        idCita = datosParam.getInt("idcita");
        hora = datosParam.getString("hora");
        edad = datosParam.getString("edad");
        sexo = datosParam.getString("sexo");
        color = "";
        vacunacion = txtEDTVacu.getText().toString();
        idEmpleado = datosParam.getInt("id_empleado");
        idCLiente = datosParam.getInt("idCliente");
        clienteUid = datosParam.getString("cliente_uid");

    }

    /*******Menu********/
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.cita:
                break;


            case R.id.diagnosticos:
                Intent intent1 = new Intent(Realiza_Diagnostico.this, DiagnosticosVet.class);
                startActivity(intent1);
                break;
            case R.id.logoutBTN:
                cerrarSesion();
                break;
            case R.id.editcuenta:
                Intent intent2 = new Intent(Realiza_Diagnostico.this,actualizar_perfil_vet.class);
                startActivity(intent2);

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /*******End Menu********/


    //metodo para cerrar sesion con email y google tras hacer click en el boton
    public void cerrarSesion() {
        FirebaseAuth.getInstance().signOut();

        //Cerrar sesión con google tambien: Google sign out
        mGoogleSignInClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //Abrir MainActivity con SigIn button
                if (task.isSuccessful()) {
                    Intent intent = new Intent(Realiza_Diagnostico.this, Login.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Hasta Luego!", Toast.LENGTH_LONG).show();
                    Realiza_Diagnostico.this.finish();
                } else {
                    Toast.makeText(getApplicationContext(), "No se pudo cerrar sesión con google", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //El metodo onStart nos permitirá saber si el usuario no esta logeado, impidiendole estar en esta activity
    @Override
    protected void onStart() {
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            //si es null el usuario no esta logueado
            // mover al usuario al login
            Intent perfilusuario = new Intent(Realiza_Diagnostico.this, Login.class);
            startActivity(perfilusuario);
        }
        super.onStart();
    }

    //metodo para actualizar cita por un usuario secretaria
    private void realizarDiag(){
        tratamiento =txtEDTTratamiento.getText().toString();
        diagnostico=txtEDTDiagnostico.getText().toString();


        //validando que los campos no esten vacios
        if (TextUtils.isEmpty(tratamiento)){
            Toast.makeText(getApplicationContext(), "Debe ingresar el tratamient.", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(diagnostico)){
            Toast.makeText(getApplicationContext(), "Debe ingresar el diagnostico.", Toast.LENGTH_LONG).show();
            return;
        }


        //realizando actualizacion
        CitasSecretaria datos_cita = new CitasSecretaria(idCita,txtEDTEspecie.getText().toString(),txtEDTRaza.getText().toString(),edad,sexo,txtEDTMotivo.getText().toString(),textEDTPeso.getText().toString(),textEDTPulso.getText().toString(),textEDTTemperatura.getText().toString(),txtEDTNombre.getText().toString(),txtEDTFecha.getText().toString(), hora,estado,idCLiente,color,vacunacion,idEmpleado,clienteUid);
        Call<CitasSecretaria> call = formCitaservicio.updateCitas(datos_cita);
        call.enqueue(new Callback<CitasSecretaria>() {
            @Override
            public void onResponse(Call<CitasSecretaria> call, Response<CitasSecretaria> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(getBaseContext(),"Error:"+response.code(),Toast.LENGTH_LONG).show();

                }else{

                }

            }

            @Override
            public void onFailure(Call<CitasSecretaria> call, Throwable t) {
                Toast.makeText(getBaseContext(),"Error:"+t.getMessage(),Toast.LENGTH_LONG).show();
                System.out.println(t.getMessage());
                System.out.println(String.valueOf(idCita));
            }
        });


        ///Hacemos insert en la tabla de diagnostico
        Diagnosticos datos_diag = new Diagnosticos(txtEDTNombre.getText().toString(),txtEDTEspecie.getText().toString(),txtEDTRaza.getText().toString(),edad,sexo,txtEDTMotivo.getText().toString(),textEDTPeso.getText().toString(),textEDTPulso.getText().toString(),textEDTTemperatura.getText().toString(),diagnostico,tratamiento,idCLiente,idEmpleado,color,"","");
        Call<Diagnosticos> call2 = DiagServicio.insertarDiagnosticos(datos_diag);
        call2.enqueue(new Callback<Diagnosticos>() {
            @Override
            public void onResponse(Call<Diagnosticos> call2, Response<Diagnosticos> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(getBaseContext(),"Error:"+response.code(),Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getBaseContext(),"Diagnostico generado.",Toast.LENGTH_LONG).show();
                   Intent intent = new Intent(Realiza_Diagnostico.this,MainActivity.class);
                   startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<Diagnosticos> call2, Throwable t) {
                Toast.makeText(getBaseContext(),"Error:"+t.getMessage(),Toast.LENGTH_LONG).show();
                System.out.println(t.getMessage());
                System.out.println(String.valueOf(idCita));
            }
        });

    }
}