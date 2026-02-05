package com.vehiculos.infraestructura;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.vehiculos.dominio.IVehiculoRepository;
import com.vehiculos.dominio.Vehiculo;
import com.vehiculos.infraestructura.utils.LocalDateAdapter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class VehiculoFileSystemJsonRepository implements IVehiculoRepository {

    private static final String FILE_PATH = "datos/vehiculos.json";

    private final Gson gson;
    private HashMap<Integer, Vehiculo> storage;

    public VehiculoFileSystemJsonRepository() throws IOException {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        cargarDatos();
    }

    @Override
    public int getNextId() {
        int maxId = storage.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);
        return maxId + 1;
    }

    @Override
    public void guardar(Vehiculo v) throws IOException {
        storage.put(v.getId(), v);
        persistirDatos();
    }

    @Override
    public Optional<Vehiculo> buscarPorId(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Vehiculo> listarTodas() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void actualizar(Vehiculo v) throws IOException {
        storage.put(v.getId(), v);
        persistirDatos();
    }

    @Override
    public void eliminarPorId(int id) throws IOException {
        storage.remove(id);
        persistirDatos();
    }

    private void cargarDatos() throws IOException {
        Path path = Paths.get(FILE_PATH);

        // Crear carpeta datos si no existe
        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        if (Files.exists(path)) {
            String json = Files.readString(path);

            Type type = new TypeToken<HashMap<Integer, Vehiculo>>() {}.getType();
            storage = gson.fromJson(json, type);

            if (storage == null) {
                storage = new HashMap<>();
            }

        } else {
            storage = new HashMap<>();
        }
    }

    private void persistirDatos() throws IOException {
        Path path = Paths.get(FILE_PATH);

        if (path.getParent() != null) {
            Files.createDirectories(path.getParent());
        }

        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            gson.toJson(storage, fw);
        }
    }
}
