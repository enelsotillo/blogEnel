package com.enel.enel.domain;

public class Blog {
    private int id;
    private String titulo;
    private String contenido;
    private String autor;

    public Blog(String titulo, String autor, String contenido, int id) {
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
