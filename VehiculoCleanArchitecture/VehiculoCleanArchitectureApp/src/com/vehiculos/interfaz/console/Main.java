package com.vehiculos.interfaz.console;

import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.infraestructura.VehiculoFileSystemJsonRepository;
import com.vehiculos.infraestructura.VehiculoMemoriaRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("   VEHICULOS - Selección de Repo   ");
        System.out.println("==================================");
        System.out.println("1) Repositorio en Memoria (rápido, no guarda)");
        System.out.println("2) Repositorio JSON (persistente en datos/vehiculos.json)");
        System.out.print("Elige opción: ");

        String opcion = sc.nextLine().trim();

        IVehiculoRepository repo;
        if ("1".equals(opcion)) {
            repo = new VehiculoMemoriaRepository();
            System.out.println(">> Usando repositorio en MEMORIA");
        } else {
            repo = new VehiculoFileSystemJsonRepository();
            System.out.println(">> Usando repositorio JSON");
        }

        System.out.println();
        new ConsoleApp(repo).run();
    }
}
