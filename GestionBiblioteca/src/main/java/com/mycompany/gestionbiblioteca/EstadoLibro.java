/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

/**
 * Define los posibles estados de un libro de la biblioteca.
 *
 * @author paula
 */
public enum EstadoLibro {
    /**
     * El libro está disponible para ser prestado.
     */
    DISPONIBLE,
    /**
     * El libro está prestado a un usuario.
     */
    PRESTADO,
    /**
     * El libro está en reparación y no se puede prestar.
     */
    EN_REPARACION
}
