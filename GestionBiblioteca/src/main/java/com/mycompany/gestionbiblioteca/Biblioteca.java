/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Esta clase se encarga de gestionar los libros de la biblioteca. Permite
 * añadir, buscar, ordenar, prestar, devolver y eliminar libros.
 *
 * @author paula
 */
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    // Conjunto donde se guardan los libros de la biblioteca.
    private Set<Libro> libros;

    /**
     * Crea una biblioteca vacía.
     */
    public Biblioteca() {
        libros = new HashSet<>();
    }

    /**
     * Devuelve el conjunto de libros de la biblioteca.
     *
     * @return conjunto de libros
     */
    public Set<Libro> getLibros() {
        return libros;
    }

    /**
     * Añade un libro a la biblioteca.
     *
     * @param l libro que se quiere añadir
     * @return true si se añade y false si ya existe
     */
    public boolean agregarLibro(Libro l) {
        return libros.add(l);
    }

    /**
     * Muestra todos los libros de la biblioteca.
     *
     * @return texto con todos los libros o un mensaje si está vacía
     */
    public String mostrarTodosLosLibros() {
        if (libros.isEmpty()) {
            return "No hay libros en la biblioteca.";
        }
        StringBuilder sb = new StringBuilder();
        libros.forEach(libro -> sb.append(libro).append("\n"));
        return sb.toString();
    }

    /**
     * Obtiene los libros ordenados por año de publicación.
     *
     * @return lista de libros ordenada de menor a mayor año
     */
    public List<Libro> obtenerLibrosOrdenadosPorAño() {
        List<Libro> listaOrdenada = new ArrayList<>(libros);
        listaOrdenada.sort(Comparator.comparingInt(Libro::getAñoPublicacion));
        return listaOrdenada;
    }

    /**
     * Busca los libros que tienen un estado determinado.
     *
     * @param estadoDeseado estado que se quiere buscar
     * @return lista de libros que tienen ese estado
     */
    public List<Libro> filtrarLibrosPorEstado(EstadoLibro estadoDeseado) {
        return libros.stream()
                .filter(libro -> libro.getEstado() == estadoDeseado)
                .collect(Collectors.toList());
    }

    /**
     * Busca un libro mediante su identificador.
     *
     * @param id identificador del libro
     * @return libro encontrado o null si no existe
     */
    public Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Presta un libro si existe y está disponible.
     *
     * @param idLibro identificador del libro
     * @return true si se presta y false si no se puede prestar
     */
    public boolean prestarLibro(int idLibro) {
        Libro libro = buscarLibroPorId(idLibro);
        if (libro != null && libro.getEstado() == EstadoLibro.DISPONIBLE) {
            libro.setEstado(EstadoLibro.PRESTADO);
            return true;
        }
        return false;
    }

    /**
     * Devuelve un libro a la biblioteca si existe.
     *
     * @param idLibro identificador del libro
     * @return true si se encuentra y se devuelve, false si no existe
     */
    public boolean devolverLibro(int idLibro) {
        Libro libro = buscarLibroPorId(idLibro);
        if (libro != null) {
            libro.setEstado(EstadoLibro.DISPONIBLE);
            return true;
        }
        return false;
    }

    /**
     * Elimina un libro mediante su identificador.
     *
     * @param id identificador del libro que se quiere eliminar
     * @return true si se elimina y false si no existe
     */
    public boolean eliminarLibro(int id) {
        Iterator<Libro> it = libros.iterator();
        while (it.hasNext()) {
            Libro libro = it.next();
            if (libro.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Convierte el conjunto de libros en un array.
     *
     * @return array con los libros de la biblioteca
     */
    public Libro[] exportarAArray() {
        return libros.toArray(new Libro[0]);
    }
}
