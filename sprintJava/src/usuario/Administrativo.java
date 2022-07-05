package usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase "Administrativo" Encargada de recibir datos específicos de este tipo de Usuario.
 */


public class Administrativo extends Usuario {
    private String area = "";
    private String experiencia = "";

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public Administrativo() {
    }

    public Administrativo(String nombres, String fechaDeNacimiento, int run) {
        super(nombres, fechaDeNacimiento, run);
    }

    public Administrativo(String area, String experiencia) {
        this.area = area;
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Administrativo{" +
                "Área = " + area + '\'' +
                ", Experiencia= " + experiencia + '\'' +
                '}';
    }

    @Override
    public void ingresar() {
        Scanner ent = new Scanner(System.in);
        boolean verificador = true;

        System.out.println("Datos Usuario");
        while (super.getNombres().length()< 10 || super.getNombres().length() > 50){
            //escaner del texto
            System.out.println(" ingrese nombres ");
            super.setNombres(ent.nextLine());

        }

        while (verificador){
            try{
                System.out.println(" ingrese fecha de nacimiento formato:dd/MM/yyyy ");
                super.setFechaDeNacimiento(ent.nextLine());
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
                super.setRun(ent.nextInt());
            }catch (Exception e) {
                ent.nextLine();
            }
            ent.nextLine();

        }


        System.out.println("Datos administrativo");
        //VALIDANDO ÁREA DE ADMINISTRATIVO.

        while(area.length() < 5 || area.length() > 20){
            System.out.println("Ingrese área del Administrativo");
            area = ent.nextLine();
            if (area.length() < 5){
                System.out.println("Ingrese una frase o palabra igual de entre 5 a 20 caracteres");
                area = ent.nextLine();
            }
            else
            if (area.length() > 50){
                System.out.println("Ingrese una frase o palabra de entre 5 a 20 caracteres");
                area = ent.nextLine();
            }
        }
        //VALIDACIÓN DE EXPERIENCIA DEL ADMINISTRATIVO.
        while(experiencia.length() == 0 || experiencia.length() > 100){
            System.out.println("Ingrese la Experiencia del Administrativo");
            experiencia = ent.nextLine();
            if (experiencia.length() == 0 || experiencia.length() > 100){
                System.out.println("Ingrese una frase o palabra de entre 1 a 100 caracteres");
                experiencia = ent.nextLine();

            }
        }

    }

    /**
     *
     * "analizarUsuarios" retorna un String con el nombre y run de Usuario más los datos específicos de la clase, tales
     * como "área" y "experiencia".
     */
    @Override
    public String analizarUsuario() {


        return "Usuario{" +
                "nombres='" + super.getNombres() + '\'' +
                ", run=" + super.getRun() +
                "} Administrativo {" +
                "Área= "+ area + " Experiencia= "+ experiencia + " }";
    }
}