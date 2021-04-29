package sv.edu.udb.petyaapp.interfaces;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import sv.edu.udb.petyaapp.models.CitasVeterinario;

public interface CitasVetService {
    @GET("petya-formcita/proceso")
    Call<ArrayList<CitasVeterinario>> getcitasvet();
}
