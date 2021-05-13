package sv.edu.udb.petyaapp.interfaces;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sv.edu.udb.petyaapp.models.CitasSecretaria;
import sv.edu.udb.petyaapp.models.Empleados;
import sv.edu.udb.petyaapp.models.FormCitas;


public interface Citas_secretariaService {
    @GET("petya-formcita/solicitado")
    Call<ArrayList<CitasSecretaria>> getCitas();

}
