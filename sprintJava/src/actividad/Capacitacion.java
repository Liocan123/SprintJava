package actividad;
import interfaz.IValidacion;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
* Clase dedicada a la obtención de datos específicos de la Actividad en este caso, a Capacitación.
*/
public class Capacitacion implements IValidacion {
    private int identificador = 0;
    private int rut = 0;
    private String dia ="";
    private String hora ="";
    private String lugar = "";
    private String duracion = "";
    private int cantidadAsistentes = 0;

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCantAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantAsistentes(int cantAsistentes) {
        this.cantidadAsistentes = cantAsistentes;
    }

    public Capacitacion() {
    }

    public Capacitacion(int identificador, int rut, String dia, String hora, String lugar, String duracion,
                        int cantidadAsistentes) {
        this.identificador = identificador;
        this.rut = rut;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }
    @Override
    public String toString() {
        return "actividad.Capacitacion {" +
                "Identificador = " + identificador + '\'' +
                ", Rut= " + rut + '\'' +    //no editar
                ", Día= " + dia +          //no editar
                ", Hora= " + hora + '\'' +
                ", Lugar= " + lugar + '\'' +
                ", Duración= " + duracion + '\'' +
                ", Asistentes= " + cantidadAsistentes + '\'' +
                '}';
    }

    @Override
    public void ingresar() {

        Scanner ent = new Scanner(System.in);
        boolean verificador = true;

        //auto asignado del identificador
        identificador = (int) Math.floor((Math.random()*9999999) + 1000000);
        System.out.println(identificador);

        //VALIDACIÓN DE RUT DE LA CAPACITACIÓN.

        while (rut == 0 || rut > 99999999 || rut < 0){

            System.out.println("Ingrese Rut del cliente sin guion");

            try {
                rut = ent.nextInt();
            } catch (Exception e) {
                ent.nextLine();
            }

            if (rut == 0 || rut > 99999999 || rut < 0){
                System.out.println("Ingrese un Número Válido");
            }

            ent.nextLine();

        }

        //día de la capacitación

        String[] diasDeSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        while (verificador) {
            System.out.println("ingrese el día de la semana en formato (Lunes) con acento si corresponde");
            this.dia = ent.nextLine();
            for (String d : diasDeSemana) {
                if (this.dia.equals(d)) {
                    verificador = false;
                }
            }
        }

        //hora
        verificador = true;
        while (verificador){
            try{
                System.out.println(" ingrese hora formato:HH:mm");
                hora= ent.nextLine();
                Date h= new SimpleDateFormat("HH:mm").parse(hora);
                String h1 =new SimpleDateFormat("HH:mm").format(h);

                if(hora.equals(h1)){
                    verificador= false;
                }

            } catch (Exception e) {}
        }

        //VALIDACIÓN DE LUGAR DE LA CAPACITACIÓN.

        while(lugar.length() < 10 || lugar.length() > 50){
            System.out.println("Ingrese Lugar de la Capacitación");
            lugar = ent.nextLine();
            if (lugar.length() < 10 || lugar.length() > 50){
                System.out.println("Ingrese una frase o palabra igual de entre 10 a 50 caracteres");
            }
        }

        //VALIDACIÓN DE DURACIÓN DE LA CAPACITACIÓN.

        while(duracion.length() == 0  || duracion.length() > 70){
            System.out.println("Ingrese Duración de la Capacitación");
            duracion = ent.nextLine();
            if (duracion.length() == 0  || duracion.length() > 100){
                System.out.println("Ingrese una frase o palabra igual de entre 1 a 100 caracteres");
            }
        }

        //VALIDACIÓN DE CANTIDAD DE ASISTENTES A LA CAPACITACIÓN.

        while(cantidadAsistentes <= 0 || cantidadAsistentes > 1000){

            System.out.println("Ingrese la Cantidad de Asistentes.");
            try {
                cantidadAsistentes = ent.nextInt();
            } catch (Exception e) {
                ent.nextLine();
            }

            if(cantidadAsistentes == 0 || cantidadAsistentes > 1000){
                System.out.println("Ingrese un número entre 1 y 1000 ");
            }

        }
    }

    /**
     * Muestra donde será realizada la Capacitación con datos tales como "lugar", "hora", "día" y "duración.
     */

    public void mostrarDetalle(){
        System.out.println("La capacitación será en " + lugar + "a las "+ hora + "hrs. " + " del día " + dia +
                " y tendrá una duración de " + duracion + " minutos");
    }

}
