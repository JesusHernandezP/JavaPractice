public class Main {
  public static void main(String[] args) {
    // Crear un objeto de la clase Coche
    Coche miCoche = new Coche();

    // Asignar valores a los atributos usando los métodos set
    miCoche.setMarca("Toyota");
    miCoche.setModelo("Corolla");
    miCoche.setYears(2020);
    miCoche.setVelocidad(120);

    // Obtener y mostrar los valores usando los métodos get
    System.out.println("Marca: " + miCoche.getMarca());
    System.out.println("Modelo: " + miCoche.getModelo());
    System.out.println("Año: " + miCoche.getYears());
    System.out.println("Velocidad: " + miCoche.getVelocidad() + " km/h");
  }
}