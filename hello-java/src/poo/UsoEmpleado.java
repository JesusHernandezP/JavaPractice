package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class UsoEmpleado {
  public static void main(String[] args) {

    /*Empleado empleado1 = new Empleado("jesus hernandez", 14000, 1970, 06, 28);
    Empleado empleado2 = new Empleado("paco lopez", 18000, 1980, 04, 19);
    Empleado empleado3 = new Empleado("maria martin", 12000, 1990, 03, 9);

    empleado1.setSueldo(12);
    empleado2.setSueldo(12);
    empleado3.setSueldo(12);

    System.out.println("nombre: " + empleado1.getNombre() + " Sueldo: " + empleado1.getSueldo() + " Fecha de alta: " + empleado1.getAltaContrato());
    System.out.println("nombre: " + empleado2.getNombre() + " Sueldo: " + empleado2.getSueldo());
    System.out.println("nombre: " + empleado3.getNombre() + " Sueldo: " + empleado3.getSueldo());*/

    Empleado[] misEmpleados = new Empleado[3];

    misEmpleados[0] = new Empleado("jesus hernandez", 14000, 1970, 06, 28);

    misEmpleados[1] = new Empleado("paco lopez", 18000, 1980, 04, 19);

    misEmpleados[2] = new Empleado("maria martin", 12000, 1990, 03, 9);


    for( Empleado e : misEmpleados){
      e.setSueldo(12);

    }
    for (int i = 0; i < 3; i++) {

      System.out.println("nombre: " + misEmpleados[i].getNombre() + " Sueldo: " + misEmpleados[i].getSueldo() + " Fecha de alta: " + misEmpleados[i].getAltaContrato());

    }


  }
}

class Empleado {

  public Empleado(String nom, double sue, int year, int mes, int dia) {

    nombre = nom;

    sueldo = sue;

    GregorianCalendar calendario = new GregorianCalendar(year, mes - 1, dia);

    altaContrato = calendario.getTime();

  }

  public String getNombre() {
    return nombre;
  }

  public double getSueldo() {
    return sueldo;
  }

  public Date getAltaContrato() {
    return altaContrato;
  }


  public void setSueldo(double porcentaje) { //Metodo de logica de negocio

    double aumento = sueldo * porcentaje / 100;

    sueldo += aumento;

  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public void setAltaContrato(Date altaContrato) {
    this.altaContrato = altaContrato;
  }

  private String nombre;

  private double sueldo;

  private Date altaContrato;


}