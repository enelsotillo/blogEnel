package com.enel.enel.persistence;

import com.enel.enel.persistence.BlogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogCrudRepository extends CrudRepository<BlogEntity, Integer> {
    List<BlogEntity> findByCategoria(String categoria);
    //@Query(value = "SELECT * FROM blog WHERE categoria = ? ORDER BY blog_id DESC", nativeQuery = true)
    List<BlogEntity> findByCategoriaOrderByBlogIdDesc(String categoria);
    // consulta que ordena Descendete y por limite de 4 registros

    @Query(value = "SELECT * FROM blog ORDER BY blog_id DESC LIMIT ?", nativeQuery = true)
   List<BlogEntity> findByCantidadOrderByBlogIdDescByLimit(int cantidad);

}
