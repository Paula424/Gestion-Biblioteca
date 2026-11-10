/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gestionbiblioteca;

import java.util.List;

/**
 * Clase principal que ejecuta las pruebas de la biblioteca. Carga los libros,
 * realiza operaciones y guarda los resultados.
 *
 * @author paula
 */
public class GestionBiblioteca {

    /**
     * Método principal del programa.
     *
     * @param args argumentos recibidos al ejecutar el programa
     */
    public static void main(String[] args) {

        String csvPath = "libros.csv";
        String serializadoPath = "biblioteca.dat";

        try {
            // 1. Cargar libros desde el CSV e inicializar la biblioteca
            List<Libro> librosIniciales = GestionArchivos.cargarDesdeCSV(csvPath);
            Biblioteca miBiblioteca = new Biblioteca();
            for (Libro libro : librosIniciales) {
                miBiblioteca.agregarLibro(libro);
            }

            System.out.println("--- Libros inicialmente cargados ---");
            System.out.println(miBiblioteca.mostrarTodosLosLibros());

            // 2. Mostrar libros ordenados por año de publicación
            System.out.println("\n--- Libros ordenados por año de publicación ---");
            miBiblioteca.obtenerLibrosOrdenadosPorAño().forEach(System.out::println);

            // 3. Demostrar préstamo y devolución
            System.out.println("\n--- Operaciones de Préstamo y Devolución ---");
            System.out.println("Intentando prestar libro ID 1 (Cien años de soledad): " + miBiblioteca.prestarLibro(1));
            System.out.println("Estado actual del libro ID 1: " + (miBiblioteca.buscarLibroPorId(1) != null ? miBiblioteca.buscarLibroPorId(1).getEstado() : "No encontrado"));
            System.out.println("Intentando prestar libro ID 2 (1984 - ya prestado en CSV): " + miBiblioteca.prestarLibro(2));
            System.out.println("Estado actual del libro ID 2: " + (miBiblioteca.buscarLibroPorId(2) != null ? miBiblioteca.buscarLibroPorId(2).getEstado() : "No encontrado"));
            System.out.println("Intentando devolver libro ID 2 (1984): " + miBiblioteca.devolverLibro(2));
            System.out.println("Estado actual del libro ID 2: " + (miBiblioteca.buscarLibroPorId(2) != null ? miBiblioteca.buscarLibroPorId(2).getEstado() : "No encontrado"));
            System.out.println("Intentando devolver libro ID 50 (inexistente): " + miBiblioteca.devolverLibro(50));

            // 4. Filtrar libros por estado (ej. DISPONIBLE)
            System.out.println("\n--- Libros en estado DISPONIBLE ---");
            miBiblioteca.filtrarLibrosPorEstado(EstadoLibro.DISPONIBLE).forEach(System.out::println);

            // 5. Eliminar un libro
            System.out.println("\n--- Eliminación de un libro ---");
            System.out.println("Antes de eliminar libro ID 3: " + (miBiblioteca.buscarLibroPorId(3) != null ? miBiblioteca.buscarLibroPorId(3) : "No encontrado"));
            System.out.println("Eliminando libro ID 3: " + miBiblioteca.eliminarLibro(3));
            System.out.println("Después de eliminar libro ID 3: " + (miBiblioteca.buscarLibroPorId(3) != null ? miBiblioteca.buscarLibroPorId(3) : "No encontrado (eliminado)"));
            System.out.println("Intentando eliminar libro ID 99 (inexistente): " + miBiblioteca.eliminarLibro(99));

            // 6. Guardar y recuperar la biblioteca
            System.out.println("\n--- Guardando biblioteca ---");
            GestionArchivos.serializarBiblioteca(miBiblioteca, serializadoPath);
            System.out.println("Biblioteca guardada en " + serializadoPath);

            System.out.println("\n--- Recuperando biblioteca ---");
            Biblioteca bibliotecaRecuperada = GestionArchivos.deserializarBiblioteca(serializadoPath);
            System.out.println("Biblioteca recuperada. Mostrando todos los libros:");
            System.out.println(bibliotecaRecuperada.mostrarTodosLosLibros());

            // 7. Demostrar el uso de exportarAArray()
            System.out.println("\n--- Libros exportados a un Array ---");
            Libro[] librosEnArray = bibliotecaRecuperada.exportarAArray();
            for (int i = 0; i < librosEnArray.length; i++) {
                System.out.println("Posición " + i + ": " + librosEnArray[i]);
            }

        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
