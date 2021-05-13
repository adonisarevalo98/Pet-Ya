package sv.edu.udb.petyaapp.models;

import com.google.gson.annotations.SerializedName;

public class Diagnosticos {
    @SerializedName("nombre_mascota")
    public String nombre_mascota;

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

    @SerializedName("motivo")
    public String motivo;

    @SerializedName("vacunas_realizadas")
    public String vacunas_realizadas;

    @SerializedName("peso")
    public String peso;

    @SerializedName("pulso")
    public String pulso;

    @SerializedName("temperatura")
    public String temperatura;

    @SerializedName("diagnostico_final")
    public String diagnostico_final;

    @SerializedName("tratamiento")
    public String tratamiento;

    @SerializedName("cliente_id")
    public int cliente_id;

    @SerializedName("empleado_id")
    public int empleado_id;

    @SerializedName("created_at")
    public String created_at;

    /*
        @SerializedName("hora")
        public String hora;
    */
    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public String getCreated_at() {
        return created_at;
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

    public String getDiagnostico_final() {
        return diagnostico_final;
    }

    public String getTratamiento() {
        return tratamiento;
    }



    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public void setDiagnostico_final(String diagnostico_final) {
        this.diagnostico_final = diagnostico_final;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVacunacion() {
        return vacunacion;
    }

    public void setVacunacion(String vacunacion) {
        this.vacunacion = vacunacion;
    }

    public String getVacunas_realizadas() {
        return vacunas_realizadas;
    }

    public void setVacunas_realizadas(String vacunas_realizadas) {
        this.vacunas_realizadas = vacunas_realizadas;
    }

    public Diagnosticos(String nombre_mascota, String especie, String raza, String edad, String sexo, String motivo, String peso, String pulso, String temperatura, String diagnostico_final, String tratamiento, int cliente_id, int empleado_id, String color, String vacunacion, String vacunas_realizadas) {
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.sexo = sexo;
        this.color = color;
        this.vacunacion = vacunacion;
        this.motivo = motivo;
        this.vacunas_realizadas = vacunas_realizadas;
        this.peso = peso;
        this.pulso = pulso;
        this.temperatura = temperatura;
        this.diagnostico_final = diagnostico_final;
        this.tratamiento = tratamiento;
        this.cliente_id =cliente_id;
        this.empleado_id = empleado_id;
    }
}
