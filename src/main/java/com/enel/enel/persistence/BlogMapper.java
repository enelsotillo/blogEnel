package com.enel.enel.persistence;

import com.enel.enel.domain.Blog;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring") // es un component de spring
public interface BlogMapper {

    // para crear una lista de Mapping
    //@Mappings({

           // @Mapping(target = "propiedad q no tiene blog", ignore = true)
    //})
    @Mapping(source = "id", target = "blogId") // cambia DNI a Cedula cambia la propiedad
    BlogEntity convertirBlogABlogEntity(Blog blog);

    //@Mapping(target = "propiedad que no tiene blogEntity", ignore = true)
    @Mapping(source = "blogId", target = "id")
    @InheritInverseConfiguration
    Blog convertirBlogEntityABlog(BlogEntity blogEntity);

    List<Blog> convertirAListaBlog(List<BlogEntity> lista);
}

