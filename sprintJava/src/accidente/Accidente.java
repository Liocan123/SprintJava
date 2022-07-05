package accidente;

import interfaz.IValidacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase en que se especifica los datos a ingresar de "Accidente" con sus respectivas validaciones.
 */
public class Accidente implements IValidacion {

    private int idAccidente;
    private int rutCliente;
    private String diaAccidente;
    private String horaAccidente;
    private String lugarAccidente;
    private String origenAccidente;
    private String consecuenciasAccidente;

    public int getIdAccidente() {
        return idAccidente;
    }

    public void setIdAccidente(int idAccidente) {
        this.idAccidente = idAccidente;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getDiaAccidente() {
        return diaAccidente;
    }

    public void setDiaAccidente(String diaAccidente) {
        this.diaAccidente = diaAccidente;
    }

    public String getHoraAccidente() {
        return horaAccidente;
    }

    public void setHoraAccidente(String horaAccidente) {
        this.horaAccidente = horaAccidente;
    }

    public String getLugarAccidente() {
        return lugarAccidente;
    }

    public void setLugarAccidente(String lugarAccidente) {
        this.lugarAccidente = lugarAccidente;
    }

    public String getOrigenAccidente() {
        return origenAccidente;
    }

    public void setOrigenAccidente(String origenAccidente) {
        this.origenAccidente = origenAccidente;
    }

    public String getConsecuenciasAccidente() {
        return consecuenciasAccidente;
    }

    public void setConsecuenciasAccidente(String consecuenciasAccidente) {
        this.consecuenciasAccidente = consecuenciasAccidente;
    }

    public Accidente() {
    }

    public Accidente(int idAccidente, int rutCliente, String diaAccidente, String horaAccidente, String lugarAccidente,
                     String origenAccidente, String consecuenciasAccidente) {
        this.idAccidente = idAccidente;
        this.rutCliente = rutCliente;
        this.diaAccidente = diaAccidente;
        this.horaAccidente = horaAccidente;
        this.lugarAccidente = lugarAccidente;
        this.origenAccidente = origenAccidente;
        this.consecuenciasAccidente = consecuenciasAccidente;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "IdAccidente= " + idAccidente + '\'' +
                ", Rut= " + rutCliente + '\'' +
                ", Dia del Accidente= " + diaAccidente +
                ", Hora= " + horaAccidente + '\'' +
                ", Lugar= " + lugarAccidente + '\'' +
                ", Origen= " + origenAccidente + '\'' +
                ", Consecuencias= " + consecuenciasAccidente + '\'' +
                '}';
    }

    @Override
    public void ingresar() {
        Scanner ent = new Scanner(System.in);

        boolean verificador= true;

        //auto asignado del identificador del accidente
        idAccidente = (int) Math.floor((Math.random()*9999999) + 1000000);
        System.out.println(idAccidente);

        //VALIDACIÓN DE RUT DEL CLIENTE.

        while (rutCliente == 0 || rutCliente > 99999999 || rutCliente <0){
            System.out.println("Ingrese Rut del Cliente");
            ent.nextInt(rutCliente);
            if (rutCliente == 0){
                System.out.println("Ingrese un Número Válido");
                ent.nextInt(rutCliente);
            }
            else
            if (rutCliente < 0){
                System.out.println("Ingrese un Número Válido");
                ent.nextInt(rutCliente);
            }
            else
            if (rutCliente > 99999999){
                System.out.println("Ingrese un Número Válido");
                ent.nextInt(rutCliente);
            }
        }

        //Día

        while (verificador){
            try{
                System.out.println(" ingrese día del accidente en formato:dd/MM/yyyy ");
                diaAccidente= ent.nextLine();
                Date fecha= new SimpleDateFormat("dd/MM/yyyy").parse(diaAccidente);
                String fecha2 =new SimpleDateFormat("dd/MM/yyyy").format(fecha);

                if(diaAccidente.equals(fecha2)){
                    verificador= false;
                }

            } catch (Exception e) {
            }

        }

        //Hora

        verificador = true;
        while (verificador){
            try{
                System.out.println(" ingrese hora formato:HH:mm");
                horaAccidente = ent.nextLine();
                Date h= new SimpleDateFormat("HH:mm").parse(horaAccidente);
                String h1 =new SimpleDateFormat("HH:mm").format(h);

                if(horaAccidente.equals(h1)){
                    verificador= false;
                }

            } catch (Exception e) {
            }

        }


        //VALIDACIÓN DE LUGAR DEL ACCIDENTE.

        while(lugarAccidente.length() < 10 || lugarAccidente.length() > 50){
            System.out.println("Ingrese Lugar del Accidente");
            lugarAccidente = ent.nextLine();
            if (lugarAccidente.length() < 10){
                System.out.println("Ingrese una frase o palabra igual de entre 10 a 50 caracteres");
                lugarAccidente = ent.nextLine();
            }
            else
            if (lugarAccidente.length() > 50){
                System.out.println("Ingrese una frase o palabra igual de entre 10 a 50 caracteres");
                lugarAccidente = ent.nextLine();
            }
        }

        //VALIDACIÓN DE ORIGEN DEL ACCIDENTE

        while(origenAccidente.length() == 0  || origenAccidente.length() > 100){
            System.out.println("Ingrese Origen del Accidente");
            origenAccidente = ent.nextLine();
            if (origenAccidente.length() == 0 || origenAccidente.length() > 100){
                System.out.println("Ingrese una frase o palabra igual de entre 1 a 100 caracteres");
                origenAccidente = ent.nextLine();
            }
        }

        //VALIDACIÓN DE CONSECUENCIAS DEL ACCIDENTE

        while(consecuenciasAccidente.length() == 0  || consecuenciasAccidente.length() > 100){
            System.out.println("Ingrese Consecuencias del Accidente");
            consecuenciasAccidente = ent.nextLine();
            if(consecuenciasAccidente.length()==0 || consecuenciasAccidente.length()>100)
            {
                System.out.println("Ingrese una frase o palabra igual de entre 1 a 100 caracteres");
                consecuenciasAccidente = ent.nextLine();
            }
        }


    }

    /*@Override
    public void validar() {

    }*/
}