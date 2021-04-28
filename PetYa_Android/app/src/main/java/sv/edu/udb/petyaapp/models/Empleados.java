package sv.edu.udb.petyaapp.models;

public class Empleados {
    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String foto;
    private String telefono;
    private String contraseña;
    private String categoria;

    public Empleados(
             int id,
             String nombres,
             String apellidos,
             String correo,
             String foto,
             String telefono,
             String contraseña,
             String categoria){

        this.id = id;
        this.nombres=nombres;
        this.apellidos=apellidos;
        this.correo=correo;
        this.foto=foto;
        this.telefono=telefono;
        this.contraseña=contraseña;
        this.categoria=categoria;
    }

    public int getId(){ return id; }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFoto() {
        return foto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCategoria() {
        return categoria;
    }
}
