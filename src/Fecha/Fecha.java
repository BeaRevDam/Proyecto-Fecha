package Fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Admin
 */
public class Fecha {

    private int dia;
    private int mes;
    private int ano;
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};//static lo van a compartir todos los atributos
    private static String[] nombreMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Dicienmbre"};

    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * este es el constructor vacio
     */
    public Fecha() {
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;
        ano = c.get(Calendar.YEAR);
    }

    public void bisiesto() {
        if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public void bisiesto(int año) {//el año que le paso
        if (año % 4 == 0 && año % 100 != 0 || año % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAño(int ano) {
        this.ano = ano;
    }

    public static int[] getDiasMes() {
        return diasMes;
    }

    public static void setDiasMes(int[] aDiasMes) {
        diasMes = aDiasMes;
    }

    public static String[] getNombreMeses() {
        return nombreMeses;
    }

    public static void setNombreMeses(String[] aNombreMeses) {
        nombreMeses = aNombreMeses;
    }

    /**
     * metodo para saber si la fecha esta bien introducida
     *
     * @param a año
     * @param m mes
     * @param d dia
     * @return resultado (si es verdadero o falso)
     */
    public boolean comprobarFecha(int a, int m, int d) {//año mes dia
        boolean resultado = false;
        if (a >= 1990 && a < 2100) {
            bisiesto(a);
            if (m >= 1 && m <= 12) {
                if (d >= 1 && d <= diasMes[m - 1]) {//el array empieza en la posicion 0, por eso lo del -1.Acuerdate de restar uno
                    resultado = true;
                    dia = d;//guardo los valores
                    mes = m;
                    ano = a;
                }
            }
        }
        return resultado;
    }

    /**
     * metodo de comparar dos fechas empezando por el año
     *
     * @return resultado
     */
    public int compararFecha(Fecha f) {
        int resultado;
        if (ano > f.getAno()) {
            resultado = 1;
        } else if (ano < f.getAno()) {
            resultado = -1;
        } else if (mes > f.getMes()) {
            resultado = 1;
        } else if (mes < f.getMes()) {
            resultado = -1;
        } else if (dia > f.getDia()) {
            resultado = 1;
        } else if (dia < f.getDia()) {
            resultado = -1;
        } else {
            resultado = 0;
        }
        return resultado;
    }

    public int calcularAnos() {
        Fecha f = new Fecha();
        int anos;
        anos = f.getAno() - ano;
        if (f.getMes() < mes || f.getMes() == mes && f.getDia() < dia) {
            anos--;
        }
        return anos;
    }
    
    public int calcularTrienios(){
        int anos=calcularAnos();
        int trienios=anos/3;
        return trienios;
    }
}
