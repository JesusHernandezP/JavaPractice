package poo;

public class Coche {

  public Coche() {
    ruedas = 4;
    color = "amarillo";
    pesoBase = 1350.25;
    precioBase = 15600;
    peso = pesoBase;
    precioFinal = precioBase;

  }


  private double ancho;

  private double alto;

  private double peso;

  private double pesoBase;

  private String color;

  private int ruedas;

  private boolean climatizador;

  private boolean asientosCuero;

  private double precioBase;

  private double precioFinal;


  public double getPesoBase() {
    return pesoBase;
  }

  public void setPesoBase(double pesoBase) {
    this.pesoBase = pesoBase;
  }

  public String isClimatizador() {
    if (climatizador == true) {
      return "El coche incorpora climatizador";
    } else return "El coche incorpora aire acondicionado";
  }

  public void setClimatizador(String climatizador) {

    if (climatizador.equalsIgnoreCase("si"))
      this.climatizador = true;
    else this.climatizador = false;

    setPrecioFinal();
    setPeso();

  }

  public String isAsientosCuero() {
    if (asientosCuero == true) {
      return "El coche incorpora asientos de cuero";
    } else return "El coche no incorpora asientos de cuero";
  }

  public void setAsientosCuero(String asientosCuero) {
    if (asientosCuero.equalsIgnoreCase("si")) {
      this.asientosCuero = true;
    } else this.asientosCuero = false;

    setPrecioFinal();
    setPeso();
  }

  public double getPrecioBase() {
    return precioBase;
  }

  public double setPrecioBase(double precioBase) {
    return precioBase;

  }


  public double getPrecioFinal() {
    return precioFinal;
  }

  private void setPrecioFinal() {
    if (climatizador == true)
      precioBase += 3250.20;
    if (asientosCuero == true) precioBase += 3320.20;
    precioFinal = precioBase;

  }


  public double getAncho() {
    return ancho;
  }

  public void setAncho(double ancho) {
    this.ancho = ancho;
  }

  public double getAlto() {
    return alto;
  }

  public void setAlto(double alto) {
    this.alto = alto;
  }

  public double getPeso() {
    return peso;
  }

  private void setPeso() {
    if (asientosCuero) {
      pesoBase += 50;
      if (climatizador) pesoBase += 70;

      peso = pesoBase;
    }
  }


  public String getColor() {
    return color;
  }

  public void setColor(String c) {
    color = c;
  }


  public void setRuedas(int r) {
    if (r < 3 || r > 4) {
      System.out.println("el num de ruedas no puede ser ese");
    } else {
      ruedas = r;
    }
  }

  public int getRuedas() {
    return ruedas;
  }


  void arrancar() {


  }

  void frenar() {


  }

  void acelerar() {


  }

  void girar() {


  }


}