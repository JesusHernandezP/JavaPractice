package poo;

public class UsoCoches {

  public static void main(String[] args) {

    Coche renault = new Coche();

    renault.arrancar();

    Coche mazda = new Coche();

    mazda.setRuedas(3);

    mazda.setColor("verde");

    System.out.println("el mazda tiene: " + mazda.getRuedas());
    System.out.println("El renault tiene: " + renault.getRuedas());
    System.out.println("El color del coche es : " + mazda.getColor());
    System.out.println("El color del coche es : " + renault.getColor());

    mazda.girar();

    Coche coche1=new Coche();

    coche1.setAsientosCuero("si");
    coche1.setClimatizador("si");

    System.out.println("peso : " + coche1.getPeso());
    System.out.println("Precio: " + coche1.getPrecioBase());


  }
}