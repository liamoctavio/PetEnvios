package enviospet.com.enviospet;


public class Envios {
    // Definir los atributos
    private int id;
    private String destinatario;
    private String direccion;
    private double peso;
    private double costo;

    // Constructor para inicializar los atributos
    public Envios(int id, String destinatario, String direccion, double peso, double costo) {
        this.id = id;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.peso = peso;
        this.costo = costo;
    }

    // Métodos getter y setter para cada atributo
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
