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

    @SerializedName("color")
    public String color;

    @SerializedName("vacunacion")
    public String vacunacion;

    @SerializedName("id_empleado")
    public int idEmpleado;

    @SerializedName("cliente_uid")
    public String clienteUid;

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

    public void setColor(String color) {
        this.color = color;
    }

    public void setVacunacion(String vacunacion) {
        this.vacunacion = vacunacion;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setClienteUid(String clienteUid) {
        this.clienteUid = clienteUid;
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


    public CitasSecretaria(int id, String especie, String raza, String edad, String sexo, String motivo, String peso, String pulso, String temperatura, String nombre_mascota, String fecha_cita, String hora, String estado, int cliente_id, String color, String vacunacion, int idEmpleado, String clienteUid) {
        this.id = id;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.sexo = sexo;
        this.motivo = motivo;
        this.peso = peso;
        this.pulso = pulso;
        this.temperatura = temperatura;
        this.nombre_mascota = nombre_mascota;
        this.fecha_cita = fecha_cita;
        this.hora = hora;
        this.estado = estado;
        this.cliente_id = cliente_id;
        this.color = color;
        this.vacunacion = vacunacion;
        this.idEmpleado = idEmpleado;
        this.clienteUid = clienteUid;
    }
}
