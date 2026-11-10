/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Contiene los métodos para cargar y guardar los datos de la biblioteca.
 *
 * @author paula
 */
public class GestionArchivos {

    /**
     * Carga los libros desde un archivo CSV. Cada línea debe contener cinco
     * campos separados por comas.
     *
     * @param ruta ruta del archivo CSV
     * @return lista de libros que se han podido cargar
     * @throws IOException si ocurre un error al leer el archivo
     */
    public static List<Libro> cargarDesdeCSV(String ruta) throws IOException {
        List<Libro> librosCargados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    try {
                        int id = Integer.parseInt(datos[0].trim());
                        String titulo = datos[1].trim();
                        String autor = datos[2].trim();
                        int añoPublicacion = Integer.parseInt(datos[3].trim());
                        EstadoLibro estado = EstadoLibro.valueOf(datos[4].trim().toUpperCase()); // Convertir a mayúsculas para el enum

                        librosCargados.add(new Libro(id, titulo, autor, añoPublicacion, estado));
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato numérico en la línea CSV: '" + linea + "'. Saltando línea.");
                    } catch (IllegalArgumentException e) {
                        System.err.println("Estado de libro inválido en la línea CSV: '" + linea + "'. Saltando línea. Detalle: " + e.getMessage());
                    }
                } else {
                    System.err.println("Línea CSV mal formateada (número de campos incorrecto): '" + linea + "'. Esperados 5 campos, encontrados " + datos.length + ". Saltando línea.");
                }
            }
        }
        return librosCargados;
    }

    /**
     * Guarda la biblioteca en un archivo.
     *
     * @param biblioteca biblioteca que se quiere guardar
     * @param ruta ruta del archivo de destino
     * @throws IOException si ocurre un error al guardar el archivo
     */
    public static void serializarBiblioteca(Biblioteca biblioteca, String ruta) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(ruta)))) {
            oos.writeObject(biblioteca);
        }
    }

    /**
     * Recupera una biblioteca guardada en un archivo.
     *
     * @param ruta ruta del archivo que contiene la biblioteca
     * @return biblioteca recuperada
     * @throws IOException si ocurre un error al leer el archivo
     * @throws ClassNotFoundException si no se encuentra una clase necesaria
     * @throws ClassCastException si el objeto guardado no es una biblioteca
     */
    public static Biblioteca deserializarBiblioteca(String ruta) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(ruta)))) {
            Object obj = ois.readObject();
            if (obj instanceof Biblioteca) {
                return (Biblioteca) obj;
            } else {
                throw new ClassCastException("El objeto deserializado no es una instancia de Biblioteca.");
            }
        }
    }
}
