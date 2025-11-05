package poo;

public class AlumnosMain {
  public static void main(String[] args) {
    Alumno alu1 = new Alumno(52, "jesus", "hernandez");
    Alumno alu2 = new Alumno();

    System.out.println("LA id del alumno 2 es: " + alu1.getId());
    System.out.println("El nombre es: " + alu1.nombre);
    System.out.println("El apellido es: " + alu1.apellido);

    alu2.setId(50);
    alu2.setNombre("jose");
    alu2.setApellido("jose");

    System.out.println("-----------------------------------------------");

    System.out.println("LA id del alumno 2 es: " + alu2.getId());
    System.out.println("El nombre es: " + alu2.nombre);
    System.out.println("El apellido es: " + alu2.apellido);

    alu2.setId(20);

    System.out.println("-----------------------------------------------");

    System.out.println("LA id del alumno 2 es: " + alu2.getId());
    System.out.println("El nombre es: " + alu2.nombre);
    System.out.println("El apellido es: " + alu2.apellido);

    Alumno as = new Alumno();

    as.saberAprobado(5);

    Alumno es = new Alumno();
    es.mostrarNombre();

    System.out.println(  alu2.nombre +  alu2.apellido);




  }


}