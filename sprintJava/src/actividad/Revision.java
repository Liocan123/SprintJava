package actividad;
import interfaz.IValidacion;
import java.util.Scanner;

/**
 * Clase dedicada a la obtención de datos específicos de la Actividad, en este caso a Revisión.
 */

public class Revision implements IValidacion {

    private int idRevision;
    private int idVisita = 0;
    private String nombreRevision ="";
    private String detalleARevisar="";
    private int estado= 0;

    public int getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public String getNombreRevision() {
        return nombreRevision;
    }

    public void setNombreRevision(String nombreRevision) {
        this.nombreRevision = nombreRevision;
    }

    public String getDetalleARevisar() {
        return detalleARevisar;
    }

    public void setDetalleARevisar(String detalleARevisar) {
        this.detalleARevisar = detalleARevisar;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Revision() {
    }

    public Revision(int idRevision, int idVisita, String nombreRevision, String detalleARevisar, int estado) {
        this.idRevision = idRevision;
        this.idVisita = idVisita;
        this.nombreRevision = nombreRevision;
        this.detalleARevisar = detalleARevisar;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "actividad.Revision{" +
                "idRevision=" + idRevision +
                ", idVisita=" + idVisita +
                ", nombreRevision='" + nombreRevision + '\'' +
                ", detalleARevisar='" + detalleARevisar + '\'' +
                ", estado=" + estado +
                '}';
    }

    @Override
    public void ingresar() {
        Scanner s = new Scanner(System.in);
        boolean verificador= true;

        //- Identificador de la revisión: obligatorio, número interno manejado por la compañía.

        idRevision = (int) Math.floor((Math.random()*9999999) + 1000000);
        System.out.println(idRevision);

        //- Identificador de la visita en terreno: obligatorio, número de la vista a la que se asócia la revisión.

        while(idVisita <= 0){
            System.out.println("Ingrese el ID de la visita a terreno");
            try {
                idVisita = s.nextInt();
            } catch (Exception e) {
                s.nextLine();
            }
            s.nextLine();
        }

        //- Nombre alusivo a la revisión: obligatorio, mínimo 10 caracteres, máximo 50

        while(nombreRevision.length() < 10 || nombreRevision.length() > 50){
            System.out.println("Ingrese el nombre de la revisión");
            nombreRevision = s.nextLine();
            if (nombreRevision.length() < 10 || nombreRevision.length() > 50){
                System.out.println("Ingrese una frase o palabra igual de entre 10 a 50 caracteres");
                nombreRevision = s.nextLine();
            }
        }

        //- Detalle para revisar: máximo 100 caracteres

        while(detalleARevisar.length() == 0 || detalleARevisar.length() > 100){
            System.out.println("Ingrese algún detalle a revisar");
            detalleARevisar = s.nextLine();
            if (detalleARevisar.length() == 0 || detalleARevisar.length() > 100){
                System.out.println("Ingrese una frase o palabra de entre 1 a 100 caracteres");
                detalleARevisar = s.nextLine();

            }
        }

        //Estado: 1 (sin problemas), 2 (con observaciones), 3 (no aprueba)

        while(estado < 1 || estado > 3){

            System.out.println("Ingrese el estado de la revisión");
            System.out.println("1 (sin problemas), 2 (con observaciones), 3 (no aprueba)");
            try {
            estado = s.nextInt();
            } catch (Exception e) {
                s.nextLine();
            }

            if (estado < 1 || estado > 3) {
                System.out.println("El numero ingresado debe estar entre 1 y 3");
            }
            s.nextLine();
        }


    }

}
