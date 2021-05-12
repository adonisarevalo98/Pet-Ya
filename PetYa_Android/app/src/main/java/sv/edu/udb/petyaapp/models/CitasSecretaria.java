package sv.edu.udb.petyaapp.models;

import com.google.gson.annotations.SerializedName;

public class CitasSecretaria {

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
    @SerializedName("motivo")
    public String motivo;
    @SerializedName("peso")
    public String peso;
    @SerializedName("pulso")
    public String pulso;
    @SerializedName("temperatura")
    public String temperatura;


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

    public int getId_cliente() {
        return cliente_id;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
