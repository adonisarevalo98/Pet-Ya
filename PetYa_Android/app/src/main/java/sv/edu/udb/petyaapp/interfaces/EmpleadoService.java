package sv.edu.udb.petyaapp.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Url;
import sv.edu.udb.petyaapp.models.Clientes;
import sv.edu.udb.petyaapp.models.Empleados;

public interface EmpleadoService {
    //metodo get para listar todos los empleados
    @GET("petya-empleados")
    Call<List<Empleados>> getEmpleados();



    //metodo post para insertar
    @POST("petya-empleados")
    Call<Empleados> insertEmpleados(
            @Body Empleados empleados

    );

    //metodo put para actualizar
    @PUT("petya-empleados")
    Call<Empleados> updateEmpleados(
            @Url String url, @Body Clientes clientes
    );

    //metodo delete para eliminar
    @DELETE("petya-empleados")
    Call<Empleados> deleteEmpleados(@Url String url);
}
