package sv.edu.udb.petyaapp.models;

public class Empleados {

    private String nombre;
    private String apellido;
    private String correo;
    private String foto;
    private String telefono;
    private String contraseña;
    private String categoria;

    public Empleados(
             String nombre,
             String apellido,
            String correo,
             String foto,
             String telefono,
            String contraseña,
             String categoria){

        this.nombre=nombre;
        this.apellido=apellido;
        this.correo=correo;
        this.foto=foto;
        this.telefono=telefono;
        this.contraseña=contraseña;
        this.categoria=categoria;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
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
