import actividad.Capacitacion;
import interfaz.IAsesoria;
import usuario.Administrativo;
import usuario.Cliente;
import usuario.Profesional;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * La clase "Contenedor" realiza las funciones de almacenar y desplegar para capacitación y las almacena, desplegar
 * y eliminar usuarios por medio de un vínculo asociado al menú proveniente de "Main."
 */

public class Contenedor {

    private List<IAsesoria> asesorias = new ArrayList<>();
    private List<Capacitacion> capacitaciones = new ArrayList<>();

    /**
     *Esta función almacena un nuevo Usuario Cliente.
     */
    public void almacenarCliente(){
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.ingresar();
        asesorias.add(nuevoCliente);
    }

    /**
     *Esta función almacena un nuevo Usuario Profesional.
     */
    public void almacenarProfesional(){
        Profesional nuevoProfesional = new Profesional();
        nuevoProfesional.ingresar();
        asesorias.add(nuevoProfesional);
    }

    /**
     *Esta función almacena un nuevo Usuario Administrativo.
     */
    public void almacenarAdministrativo(){
        Administrativo nuevoAdministrativo = new Administrativo();
        nuevoAdministrativo.ingresar();
        asesorias.add(nuevoAdministrativo);
    }

    /**
     *Esta función almacena una nueva Capacitación.
     */

    public void almacenarCapacitacion(){
        Capacitacion nuevaCapacitacion = new Capacitacion();
        nuevaCapacitacion.ingresar();
        capacitaciones.add(nuevaCapacitacion);
    }

    /**
     *Esta función Elimina un tipo de Usuario seleccionado por medio de su Rut.
     */

    public void eliminarUsuario(){

        Scanner s = new Scanner(System.in);
        String[] arr;
        String[] arr2;
        System.out.println("Ingrese el rut del usuario a eliminar");
        String rutEliminado = s.nextLine();

        for (IAsesoria a: asesorias) {
            arr = a.analizarUsuario().split("run=");
            arr2 = arr[1].split("}");

            System.out.println(arr2[0]);

           if (rutEliminado.equals(arr2[0])) {
               asesorias.remove(a);
               break;
           }
        }

    }

    /**
     * Función dedidacada a listar los usuarios ingresados
     */

    public void listarUsuarios(){

        for (IAsesoria a: asesorias) {
            System.out.println(a);
        }

    }

    /**
     * Lista de Usuarios ordenados por tipo.
     */

    public void listarUsuariosPorTipo(){
        int opcion = 0;
        Scanner s = new Scanner(System.in);


        while (opcion < 1 || opcion > 3) {
            System.out.println("Ingrese el tipo de Usuario a Listar");
            System.out.println("1 (Cliente) 2 (Administrativo) 3 (Profesional)");
            try{
            opcion = s.nextInt();
            } catch (Exception e){
                System.out.println("Ingrese un número entre 1 y 3");
                s.nextLine();
            }
            s.nextLine();
        }

        if (opcion == 1) {
            for (IAsesoria a : asesorias) {
                if (a instanceof Cliente) {
                    System.out.println(a.analizarUsuario());
                }
            }
        } else if (opcion == 2) {
            for (IAsesoria a : asesorias) {
                if (a instanceof Administrativo) {
                    System.out.println(a.analizarUsuario());
                }
            }
        } else {
            for (IAsesoria a : asesorias) {
                if (a instanceof Profesional) {
                    System.out.println(a.analizarUsuario());
                }
            }
        }

    }

    /**
     * Muestra una lista de Capacitaciones y los Clientes asociados.
     */

    public void listarCapacitaciones(){

        String[] arr; //separador de lo que está antes y después del "rut=" en capacitación
        String[] rutYResto; //rut del cliente en capacitación
        String[] arr3; //separador de lo que está antes y después del "rut=" en cliente
        String[] rutYResto2; //rut del cliente en cliente

        for (Capacitacion c: capacitaciones) {

            System.out.println(c);
            arr = c.toString().split("Rut= ");
            rutYResto = arr[1].split("'");

            for (IAsesoria a : asesorias) {
                arr3 = a.toString().split("rut=");
                rutYResto2 = arr3[1].split(",");

                if(rutYResto[0].equals(rutYResto2[0])){
                    System.out.println(a);
                }
            }

        }
    }

}
