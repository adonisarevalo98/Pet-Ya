package sv.edu.udb.petyaapp.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sv.edu.udb.petyaapp.models.FormCitas;
import sv.edu.udb.petyaapp.models.RespFormCita;

public interface FormCitaService {

    //METODO PARA INSERTAR CITAS
    @POST("petya-formcita")
    Call<RespFormCita> insertarCitas(
            @Body FormCitas formCitas
    );
}
