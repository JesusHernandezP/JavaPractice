package com.vehiculos.interfaz.console;

import com.vehiculos.aplicacion.*;
import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {

    private final CrearVehiculoService crearService;
    private final BuscarVehiculoService buscarService;
    private final ListarVehiculoService listarService;
    private final ActualizarVehiculoService actualizarService;
    private final EliminarVehiculoService eliminarService;

    private final Scanner sc = new Scanner(System.in);
    private final InputUtils input = new InputUtils(sc);

    public ConsoleApp(IVehiculoRepository repo) {
        this.crearService = new CrearVehiculoService(repo);
        this.buscarService = new BuscarVehiculoService(repo);
        this.listarService = new ListarVehiculoService(repo);
        this.actualizarService = new ActualizarVehiculoService(repo);
        this.eliminarService = new EliminarVehiculoService(repo);
    }

    public void run() {
        int opcion;
        do {
            pintarMenu();
            opcion = input.readInt("Elige opción: ");
            System.out.println();

            try {
                switch (opcion) {
                    case 1 -> crear();
                    case 2 -> listar();
                    case 3 -> buscarPorId();
                    case 4 -> actualizar();
                    case 5 -> eliminar();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            System.out.println();
        } while (opcion != 0);
    }

    private void pintarMenu() {
        System.out.println("==================================");
        System.out.println("   VEHICULOS - Clean Architecture  ");
        System.out.println("==================================");
        System.out.println("1) Crear vehiculo");
        System.out.println("2) Listar vehiculos");
        System.out.println("3) Buscar vehiculo por ID");
        System.out.println("4) Actualizar vehiculo");
        System.out.println("5) Eliminar vehiculo");
        System.out.println("0) Salir");
        System.out.println("==================================");
    }

    private void crear() throws Exception {
        String matricula = input.readString("Matricula: ");
        String marca = input.readString("Marca: ");
        String modelo = input.readString("Modelo: ");
        float precio = input.readFloat("Precio: ");
        LocalDate fecha = input.readLocalDate("Fecha matricula");

        crearService.crearVehiculo(matricula, marca, modelo, precio, fecha);
        System.out.println("Vehiculo creado correctamente.");
    }

    private void listar() throws Exception {
        List<Vehiculo> lista = listarService.listarTodas();
        if (lista.isEmpty()) {
            System.out.println("No hay vehiculos.");
            return;
        }

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-5s %-12s %-12s %-12s %-10s %-15s%n",
                "ID", "MATRICULA", "MARCA", "MODELO", "PRECIO", "FECHA MATRICULA");
        System.out.println("-----------------------------------------------------------------------------------");

        for (Vehiculo v : lista) {
            System.out.printf("%-5d %-12s %-12s %-12s %-10.2f %-15s%n",
                    v.getId(),
                    v.getMatricula(),
                    v.getMarca(),
                    v.getModelo(),
                    v.getPrecio(),
                    v.getFechaMatricula().toString());
        }

        System.out.println("-----------------------------------------------------------------------------------");
    }


    private void buscarPorId() throws Exception {
        int id = input.readInt("ID a buscar: ");
        Vehiculo v = buscarService.buscarPorId(id);
        System.out.println(v);
    }

    private void actualizar() throws Exception {
        int id = input.readInt("ID a actualizar: ");
        String matricula = input.readString("Matricula: ");
        String marca = input.readString("Marca: ");
        String modelo = input.readString("Modelo: ");
        float precio = input.readFloat("Precio: ");
        LocalDate fecha = input.readLocalDate("Fecha matricula");

        actualizarService.actualizarVehiculo(id, matricula, marca, modelo, precio, fecha);
        System.out.println("Vehiculo actualizado correctamente.");
    }

    private void eliminar() throws Exception {
        int id = input.readInt("ID a eliminar: ");
        eliminarService.eliminarPorId(id);
        System.out.println("Vehiculo eliminado correctamente.");
    }
}
