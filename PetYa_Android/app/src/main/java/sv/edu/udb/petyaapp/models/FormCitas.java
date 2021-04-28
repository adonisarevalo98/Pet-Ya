package sv.edu.udb.petyaapp.models;

public class FormCitas {
    private int id;
    private String fecha_cita;
    private String hora;
    private String nombre_mascota;
    private String especie;
    private String raza;
    private String edad;
    private String sexo;
    private String color;
    private String vacunacion;
    private String motivo;
    private String estado;
    private int id_empleado;
    private String peso;
    private String pulso;
    private String temperatura;
    private int cliente_id;

    public FormCitas(
            String fecha_cita,
            String hora,
            String nombre_mascota,
            String especie,
            String raza,
            String edad,
            String sexo,
            String motivo,
            String estado,
            int id_empleado,
            int cliente_id){

        this.fecha_cita = fecha_cita;
        this.hora = hora;
        this.nombre_mascota = nombre_mascota;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.sexo = sexo;
        this.motivo = motivo;
        this.estado = estado;
        this.id_empleado = id_empleado;
        this.cliente_id = cliente_id;
    }


    public int getId() {
        return id;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public String getHora() {
        return hora;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
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

    public String getMotivo() {
        return motivo;
    }

    public String getEstado() {
        return estado;
    }

    public int getId_empleado() {
        return id_empleado;
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

    public int getCliente_id() {
        return cliente_id;
    }
}
