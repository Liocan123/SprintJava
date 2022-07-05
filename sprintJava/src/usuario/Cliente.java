package usuario;
import accidente.Accidente;
import actividad.Capacitacion;
import actividad.VisitaEnTerreno;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Clase "Cliente" Encargada de recibir datos específicos de este tipo de Usuario.
 */


public class Cliente extends Usuario {
    private int rut = 0;
    private String nombres ="";
    private String apellidos ="";
    private String telefono ="";
    private String afp ="";
    private int sistemaDeSalud = 0;
    private String direccion = "";
    private String comuna = "";
    private int edad = 0;
    private List<Accidente> accidentes = new ArrayList<>();
    private List<Capacitacion> capacitaciones = new ArrayList<>();
    private List<VisitaEnTerreno> visitasTerreno = new ArrayList<>();

    public List<Accidente> getAccidentes() {
        return accidentes;
    }

    public void setAccidentes(List<Accidente> accidentes) {
        this.accidentes = accidentes;
    }

    public List<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public void setCapacitaciones(List<Capacitacion> capacitaciones) {
        this.capacitaciones = capacitaciones;
    }

    public List<VisitaEnTerreno> getVisitasTerreno() {
        return visitasTerreno;
    }

    public void setVisitasTerreno(List<VisitaEnTerreno> visitasTerreno) {
        this.visitasTerreno = visitasTerreno;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public int getSistemaDeSalud() {
        return sistemaDeSalud;
    }

    public void setSistemaDeSalud(int sistemaDeSalud) {
        this.sistemaDeSalud = sistemaDeSalud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Cliente() {
    }

    public Cliente(int rut, String nombres, String apellidos, String telefono, String afp, int sistemaDeSalud, String direccion, String comuna, int edad) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaDeSalud = sistemaDeSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public Cliente(String nombres, String fechaDeNacimiento, int run, int rut, String nombres1, String apellidos, String telefono, String afp, int sistemaDeSalud, String direccion, String comuna, int edad) {
        super(nombres, fechaDeNacimiento, run);
        this.rut = rut;
        this.nombres = nombres1;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaDeSalud = sistemaDeSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public Cliente(int rut, String nombres, String apellidos, String telefono, String afp, int sistemaDeSalud, String direccion, String comuna, int edad, List<Accidente> accidentes, List<Capacitacion> capacitaciones, List<VisitaEnTerreno> visitasTerreno) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaDeSalud = sistemaDeSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
        this.accidentes = accidentes;
        this.capacitaciones = capacitaciones;
        this.visitasTerreno = visitasTerreno;
    }



    @Override
    public String toString() {
        return "Cliente{" +
                "rut=" + rut + //no editar
                ", nombres='" + nombres + '\'' + //no editar
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", afp='" + afp + '\'' +
                ", sistemaDeSalud=" + sistemaDeSalud +
                ", direccion='" + direccion + '\'' +
                ", comuna='" + comuna + '\'' +
                ", edad=" + edad +
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

        System.out.println("Datos cliente");
        rut=0;
        while (rut < 1 || rut> 100000000){
            System.out.println(" Ingrese RUn del Cliente ");
            //escaner del texto
            try {
                rut = leer.nextInt();
            }catch (Exception e) {
                leer.nextLine();
            }
            leer.nextLine();

        }
        nombres ="";
        while (nombres.length()< 5 || nombres.length() > 30){
            //escaner del texto
            System.out.println(" ingrese nombres ");
            nombres = leer.nextLine();

        }

        while (apellidos.length()< 5 || apellidos.length() > 30){
            //escaner del texto
            System.out.println(" ingrese apellidos ");
            apellidos = leer.nextLine();

        }

        while (telefono.length()< 1){
            //escaner del texto
            System.out.println(" ingrese telefono ");
            telefono = leer.nextLine();

        }

        while (afp.length()< 4 || afp.length() > 30){
            //escaner del texto
            System.out.println(" ingrese AFP ");
            afp = leer.nextLine();

        }

        while (sistemaDeSalud < 1 || sistemaDeSalud > 2){
            //escaner del texto
            System.out.println(" ingrese sistema de salud ");
            System.out.println(" 1 (Fonasa), 2 (Isapre) ");
            sistemaDeSalud = leer.nextInt();
            leer.nextLine();

        }

        while (direccion.length() <= 0 || direccion.length() > 70){
            //escaner del texto
            System.out.println(" ingrese direccion ");
            direccion = leer.nextLine();

        }

        while (comuna.length() <= 0 || comuna.length() > 50){
            //escaner del texto
            System.out.println(" ingrese comuna ");
            comuna = leer.nextLine();

        }
        while (edad <= 0 || edad > 150){
            //escaner del texto
            System.out.println(" ingrese edad ");
            try {
                edad = leer.nextInt();
            } catch (Exception e){
                leer.nextLine();
            }
            leer.nextLine();
        }
    }

    /**
     * Retorna un String con nombres y apellidos ingresados en la clase.
     */
    public String obtenerNombre(){

        return ", Nombre:'" + nombres  + " " + apellidos +  '}';

    }

    /**
     * Retorna un String el Sistema de Salud, dependiente del dato ingresado previamente.
     */

    public String obtenerSistemaSalud() {
        if(this.sistemaDeSalud==1){
            return "Fonasa";
        }
        else {
            return "Isapre";
        }
    }

    /**
     *
     * "analizarUsuarios" retorna un String con el nombre y run de Usuario más los datos específicos de la clase, tales
     * como "dirección" y "comuna".
     */
    @Override
    public String analizarUsuario() {
        super.analizarUsuario();
        return "Usuario{" +
                "nombres='" + super.getNombres() + '\'' +
                ", run=" + super.getRun() + //no editar
                "} Cliente {" +
                ", direccion='" + this.direccion + '\'' +
                ", comuna='" + this.comuna + '\'' +
                '}';
    }
}
