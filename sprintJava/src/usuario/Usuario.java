package usuario;
import interfaz.IAsesoria;
import interfaz.IValidacion;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 * Super Clase "Usuario" encargada de implementar las interfaces e ingresos de datos generales para
 * las Clases dependientes (Administrativo, Cliente y Profesional).
 */

public class Usuario implements IValidacion, IAsesoria {
    private String nombres ="";
    private String fechaDeNacimiento="";
    private int run =0;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public Usuario() {
    }

    public Usuario(String nombres, String fechaDeNacimiento, int run) {
        this.nombres = nombres;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.run = run;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombres='" + nombres + '\'' +
                ", fechaDeNacimiento='" + fechaDeNacimiento + '\'' +
                ", run=" + run + //no editar
                '}';
    }

    /**
     * Validación implementada desde la Interfaz para el ingreso de datos.
     */

    @Override
    public void ingresar() {
        Scanner leer = new Scanner(System.in);
        boolean verificador= true;


        System.out.println("Datos Usuario");

        //Usuario

        while (nombres.length()< 10 || nombres.length() > 50){
            //escaner del texto
            System.out.println(" ingrese nombres ");
            nombres = leer.nextLine();

        }

        while (verificador){
            try{
                System.out.println(" ingrese fecha de nacimiento formato:dd/MM/yyyy ");
                fechaDeNacimiento= leer.nextLine();
                Date fecha= new SimpleDateFormat("dd/MM/yyyy").parse(fechaDeNacimiento);
                String fecha2 =new SimpleDateFormat("dd/MM/yyyy").format(fecha);

                if(fechaDeNacimiento.equals(fecha2)){
                    verificador= false;
                }

            } catch (Exception e) {
            }

        }

        while (run < 1 || run> 100000000){
            System.out.println(" Ingrese RUT del Usuario ");
            //escaner del texto
            try {
                run = leer.nextInt();
            } catch (Exception e){
                leer.nextLine();
                run = 0;
            }
            leer.nextLine();

        }

    }

   /* @Override
    public void validar() {

    }*/

    /**
     * "analizarUsuarios" retorna un String con el nombre y run de Usuario.
     */

    @Override
    public String analizarUsuario() {
        return "Usuario{" +
                "nombres='" + nombres + '\'' +
                ", run=" + run + //no editar
                '}';
    }
    /**
     * Comapara la fecha de nacimiento de Usuario con la fecha actual a modo de obtener la edad en años, meses y días.
     */

    public String mostrarEdad(){

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ahora = LocalDate.now();
        LocalDate nacimiento = LocalDate.parse(fechaDeNacimiento, fmt);
        Period periodo= Period.between(nacimiento, ahora);

        return "La edad del usuario es "+periodo.getYears()+ " años " + periodo.getMonths()+" meses y " +
                periodo.getDays()+" dias";


    }
}
