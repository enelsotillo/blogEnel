package com.enel.enel.persistence;

import javax.persistence.*;

@Entity //indica entidad representa una tabla de datos
@Table(name = "Blog") // nombre de la base de datos
public class BlogEntity {
    @Id //representa la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private int blogId;
    private String titulo;
    private String contenido;
    private String autor;

    public BlogEntity(String titulo, String autor, String contenido, int blogId) {
        this.titulo = titulo;
        this.autor = autor;
        this.contenido = contenido;
        this.blogId = blogId;
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
        return blogId;
    }

    public void setId(int blogId) {
        this.blogId = blogId;
    }

}
