package usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase "Profesional" Encargada de recibir datos específicos de este tipo de Usuario.
 */

public class Profesional extends Usuario {
    private String titulo ="";
    private String fechaDeIngreso="";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getfechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setfechaDeIngreso(String fechadeIngreso) {
        this.fechaDeIngreso = fechadeIngreso;
    }

    public Profesional() {
    }

    public Profesional(String titulo, String fechaDeIngreso) {
        this.titulo = titulo;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Profesional(String nombres, String fechaDeNacimiento, int run, String titulo, String fechaDeIngreso) {
        super(nombres, fechaDeNacimiento, run);
        this.titulo = titulo;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    @Override
    public String toString() {
        return "Profesional{" +
                "titulo='" + titulo + '\'' +
                ", fechadeIngreso='" + fechaDeIngreso + '\'' +
                '}';
    }

    @Override
    public void ingresar() {
        Scanner leer = new Scanner(System.in);
        boolean verificador= true;

        System.out.println("Datos Usuario");

        while (super.getNombres().length()< 10 || super.getNombres().length() > 50){
            //escaner del texto
            System.out.println(" ingrese nombres ");
            super.setNombres(leer.nextLine());

        }

        while (verificador){
            try{
                System.out.println(" ingrese fecha de nacimiento formato:dd/MM/yyyy ");
                super.setFechaDeNacimiento(leer.nextLine());
                Date fecha= new SimpleDateFormat("dd/MM/yyyy").parse(super.getFechaDeNacimiento());
                String fecha2 =new SimpleDateFormat("dd/MM/yyyy").format(fecha);

                if(super.getFechaDeNacimiento().equals(fecha2)){
                    verificador= false;
                }

            } catch (Exception e) {
            }

        }

        while (super.getRun() < 1 || super.getRun()> 100000000){
            System.out.println(" Ingrese RUT del Usuario ");
            //escaner del texto
            try {
                super.setRun(leer.nextInt());
            }catch (Exception e) {
                leer.nextLine();
            }
            leer.nextLine();

        }

        System.out.println("Datos profesional");

        while (titulo.length()< 10 || titulo.length() > 50){
            //escaner del texto
            System.out.println(" ingrese titulo ");
            titulo = leer.nextLine();

        }
        verificador=true;
        while (verificador){
            try{
                System.out.println(" ingrese fecha de ingreso formato:dd/MM/yyyy ");
                fechaDeIngreso= leer.nextLine();
                Date fecha= new SimpleDateFormat("dd/MM/yyyy").parse(fechaDeIngreso);
                String fecha2 =new SimpleDateFormat("dd/MM/yyyy").format(fecha);

                if(fechaDeIngreso.equals(fecha2)){
                    verificador= false;
                }

            } catch (Exception e) {
            }

        }
    }

    /**
     *
     * "analizarUsuarios" retorna un String con el nombre y run de Usuario más los datos específicos de la clase, tales
     * como "Título" y "Fecha de Ingreso".
     */

    @Override
    public String analizarUsuario() {

        return "Usuario{" +
                "nombres='" + super.getNombres() + '\'' +
                ", run=" + super.getRun() +
                '}' + " Profesional {" +
                " Título= " + titulo + " Fecha de Ingreso= " + fechaDeIngreso + " }";
    }
}
