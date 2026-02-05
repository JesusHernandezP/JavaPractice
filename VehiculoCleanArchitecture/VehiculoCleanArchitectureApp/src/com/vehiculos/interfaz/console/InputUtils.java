package com.vehiculos.interfaz.console;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtils {

    private final Scanner sc;

    public InputUtils(Scanner sc) {
        this.sc = sc;
    }

    public String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine();
            if (s != null) {
                s = s.trim();
            }
            if (s != null && !s.isEmpty()) return s;
            System.out.println("Valor inválido. Intenta otra vez.");
        }
    }

    public int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Número entero inválido. Intenta otra vez.");
            }
        }
    }

    public float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim().replace(",", ".");
            try {
                return Float.parseFloat(s);
            } catch (NumberFormatException e) {
                System.out.println("Número decimal inválido. Intenta otra vez.");
            }
        }
    }

    public LocalDate readLocalDate(String prompt) {
        while (true) {
            System.out.print(prompt + " (yyyy-MM-dd): ");
            String s = sc.nextLine().trim();
            try {
                return LocalDate.parse(s);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Formato esperado: yyyy-MM-dd");
            }
        }
    }
}
