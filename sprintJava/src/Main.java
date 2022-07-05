import java.util.Scanner;

/**
 * Clase "Main" que es utilizada para desplegar un menú en pantalla y hacer uso del resto de clases.
 */

public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Contenedor con = new Contenedor();

        int op=0;
        boolean verificador= true;

        while (verificador){
            System.out.println("Menu");
            System.out.println("1-Almacenar cliente");
            System.out.println("2-Almacenar profesional");
            System.out.println("3-Almacenar administrativo");
            System.out.println("4-Almacenar capacitación");
            System.out.println("5-Eliminar usuario");
            System.out.println("6-Listar usuarios");
            System.out.println("7-Listar usuarios por tipo");
            System.out.println("8-Listar capacitaciones");
            System.out.println("9-Salir");

            try {
                op = leer.nextInt();
            }catch(Exception e){leer.nextLine();
            op=0;
            }

            switch(op){
                case 1:
                    System.out.println("Datos Cliente almacenado:");
                    leer.nextLine();
                    con.almacenarCliente();
                    break;
                case 2:
                    System.out.println("Datos Profesional almacenado:");
                    leer.nextLine();
                    con.almacenarProfesional();
                    break;
                case 3:
                    System.out.println("Datos Administrativo almacenado:");
                    leer.nextLine();
                    con.almacenarAdministrativo();
                    break;
                case 4:
                    System.out.println("Datos Capacitacion almacenada:");
                    leer.nextLine();
                    con.almacenarCapacitacion();
                    break;
                case 5:
                    System.out.println("RUN Usuario eliminado:");
                    leer.nextLine();
                    con.eliminarUsuario();
                    break;
                case 6:
                    System.out.println("Lista de usuarios:");
                    leer.nextLine();
                    con.listarUsuarios();
                    break;
                case 7:
                    System.out.println("Lista de usuarios por tipo:");
                    leer.nextLine();
                    con.listarUsuariosPorTipo();
                    break;
                case 8:
                    System.out.println("Lista de capacitaciones:");
                    leer.nextLine();
                    con.listarCapacitaciones();
                    break;
                case 9:
                    System.out.println("Salió");
                    verificador= false;
                    break;

                default:
                    System.out.println("Opción no valida");

            }
        }
    }
}