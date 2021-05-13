package sv.edu.udb.petyaapp.models;

import com.google.gson.annotations.SerializedName;

public class CitasVeterinario {
    @SerializedName("nombre_mascota")
    public String nombre_mascota;

    @SerializedName("fecha_cita")
    public String fecha_cita;

    @SerializedName("hora")
    public String hora;

    @SerializedName("estado")
    public String estado;

    @SerializedName("cliente_id")
    public int cliente_id;

    //Atributos agregado por quevedo para hacer diagnostico
    @SerializedName("id")
    public int id;

    @SerializedName("especie")
    public String especie;

    @SerializedName("raza")
    public String raza;

    @SerializedName("edad")
    public String edad;

    @SerializedName("sexo")
    public String sexo;

    @SerializedName("color")
    public String color;

    @SerializedName("vacunacion")
    public String vacunacion;

    @SerializedName("id_empleado")
    public int idEmpleado;

    @SerializedName("cliente_uid")
    public String clienteUid;

    @SerializedName("motivo")
    public String motivo;

    @SerializedName("peso")
    public String peso;

    @SerializedName("pulso")
    public String pulso;

    @SerializedName("temperatura")
    public String temperatura;



    //@SerializedName("id_empleado")
    //public int id_empleado;

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public String getHora() {
        return hora;
    }

    public String getEstado() {
        return estado;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public int getId() {
        return id;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public String getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getColor() {
        return color;
    }

    public String getVacunacion() {
        return vacunacion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getClienteUid() {
        return clienteUid;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getPeso() {
        return peso;
    }

    public String getPulso() {
        return pulso;
    }

    public String getTemperatura() {
        return temperatura;
    }

    // public int getId_empleado() {
      //  return id_empleado;
    //}

}
