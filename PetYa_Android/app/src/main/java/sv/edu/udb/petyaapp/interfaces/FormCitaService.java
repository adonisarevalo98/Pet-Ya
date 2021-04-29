package sv.edu.udb.petyaapp.interfaces;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import sv.edu.udb.petyaapp.models.FormCitas;

public interface FormCitaService {

    //METODO PARA INSERTAR CITAS
    @POST("petya-formcita")
    Call<FormCitas> insertarCitas(
            @Body FormCitas formCitas
    );
}
