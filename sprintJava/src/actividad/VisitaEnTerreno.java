package actividad;
import interfaz.IValidacion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Clase dedicada a la obtención de datos específicos de la Actividad, en este caso referente a Visita en Terreno.
 */

public class VisitaEnTerreno implements IValidacion {

    private int idVisita = (int) Math.floor((Math.random()*9999999) + 1000000);
    private int rutCliente = 0;
    private String dia = "";
    private String hora = "";
    private String lugar = "";
    private String comentario = "";
    private List<Revision> revisiones = new ArrayList<Revision>();

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public VisitaEnTerreno() {
    }

    public VisitaEnTerreno(int idVisita, int rutCliente, String dia, String hora, String lugar, String comentario) {
        this.idVisita = idVisita;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "actividad.VisitaEnTerreno{" +
                "idVisita=" + idVisita +
                ", rutCliente=" + rutCliente +
                ", dia='" + dia + '\'' +
                ", hora='" + hora + '\'' +
                ", lugar='" + lugar + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }

    @Override
    public void ingresar() {
        Scanner s = new Scanner(System.in);
        boolean verificador= true;

        while (rutCliente > 99999999 || rutCliente <= 0){
            try {
                System.out.println("ingrese el RUT del cliente");
                rutCliente = s.nextInt();
                s.nextLine();
            } catch (Exception e){
                System.out.println("esto no es un número");
                s.next();
            }
        }

        while (verificador){
            try{
                System.out.println(" ingrese el dia de la visita en formato:dd/MM/yyyy ");
                dia= s.nextLine();
                Date fecha= new SimpleDateFormat("dd/MM/yyyy").parse(dia);
                String fecha2 =new SimpleDateFormat("dd/MM/yyyy").format(fecha);

                if(dia.equals(fecha2)){
                    verificador= false;
                }

            } catch (Exception e) {
            }

        }

        verificador=true;

        while (verificador){
            try{
                System.out.println(" ingrese hora formato:HH:mm");
                hora= s.nextLine();
                Date h= new SimpleDateFormat("HH:mm").parse(hora);
                String h1 =new SimpleDateFormat("HH:mm").format(h);

                if(hora.equals(h1)){
                    verificador= false;
                }

            } catch (Exception e) {
            }

        }

        while (lugar.length()< 10 || lugar.length() > 50){
            //escaner del texto
            System.out.println(" ingrese el lugar de la visita ");
            lugar = s.nextLine();

        }

        while (comentario.length() <= 0 || comentario.length() > 100){
            System.out.println(" ingrese nombres ");
            comentario = s.nextLine();

        }
    }
}
