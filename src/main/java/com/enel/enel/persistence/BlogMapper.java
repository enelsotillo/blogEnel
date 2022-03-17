package com.enel.enel.persistence;

import com.enel.enel.domain.Blog;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring") // es un componente de spring
public interface BlogMapper {

    // para crear una lista de Mapping
    //@Mappings({

           // @Mapping(target = "propiedad q no tiene blog", ignore = true)
    //})
    @Mapping(source = "id", target = "blogId") // cambia DNI a Cedula cambia la propiedad
    BlogEntity convertirBlogABlogEntity(Blog blog);
    //@Mapping(source = "blogId", target = "id")

    //@Mapping(target = "propiedad que no tiene blogEntity", ignore = true);
    //@InheritInverseConfiguration
   // Blog convertirBlogEntityABlog(BlogEntity blogEntity);

}

