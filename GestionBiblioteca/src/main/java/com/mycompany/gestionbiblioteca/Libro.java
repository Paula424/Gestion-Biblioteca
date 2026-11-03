/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

import java.io.Serializable;
import java.util.Objects;

/**
 * Representa un libro de la biblioteca. Guarda su identificador, título, autor,
 * año y estado.
 *
 * @author paula
 */
public class Libro implements Comparable<Libro>, Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private EstadoLibro estado;

    /**
     * Crea un libro con todos sus datos.
     *
     * @param id identificador del libro
     * @param titulo título del libro
     * @param autor autor del libro
     * @param añoPublicacion año de publicación
     * @param estado estado actual del libro
     */
    public Libro(int id, String titulo, String autor, int añoPublicacion, EstadoLibro estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.estado = estado;
    }

    // Getters
    /**
     * Devuelve el identificador del libro.
     *
     * @return identificador del libro
     */
    public int getId() {
        return id;
    }

    /**
     * Devuelve el título del libro.
     *
     * @return título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Devuelve el autor del libro.
     *
     * @return autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Devuelve el año de publicación.
     *
     * @return año de publicación
     */
    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    /**
     * Devuelve el estado actual del libro.
     *
     * @return estado del libro
     */
    public EstadoLibro getEstado() {
        return estado;
    }

    // Setters
    /**
     * Cambia el identificador del libro.
     *
     * @param id nuevo identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Cambia el título del libro.
     *
     * @param titulo nuevo título
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Cambia el autor del libro.
     *
     * @param autor nuevo autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Cambia el año de publicación.
     *
     * @param añoPublicacion nuevo año de publicación
     */
    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    /**
     * Cambia el estado del libro.
     *
     * @param estado nuevo estado del libro
     */
    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    /**
     * Devuelve los datos del libro en forma de texto.
     *
     * @return texto con todos los datos del libro
     */
    @Override
    public String toString() {
        return String.format("ID: %-5d | Título: %-30s | Autor: %-20s | Año: %-4d | Estado: %s",
                id, titulo, autor, añoPublicacion, estado);
    }

    /**
     * Calcula el código hash del libro utilizando su identificador.
     *
     * @return código hash del libro
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Comprueba si dos libros tienen el mismo identificador.
     *
     * @param o objeto con el que se compara el libro
     * @return true si son el mismo objeto o tienen el mismo ID
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Libro libro = (Libro) o;
        return id == libro.id;
    }

    /**
     * Compara dos libros por su título, ignorando mayúsculas y minúsculas.
     *
     * @param otro libro con el que se compara
     * @return resultado de la comparación de los títulos
     */
    @Override
    public int compareTo(Libro otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }
}
