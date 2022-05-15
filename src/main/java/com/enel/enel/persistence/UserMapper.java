package com.enel.enel.persistence;

import com.enel.enel.domain.Blog;
import com.enel.enel.domain.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    //@Mapping(source = "idUser", target = "id") // cambia DNI a Cedula cambia la propiedad
   // @Mapping(source = '' )


   // @Mapping(source = "id", target = "idUser")
   // @InheritInverseConfiguration
   // User convertirUserEntityAUser(UserEntity userEntity);

    @Mapping(source = "id", target = "idUser") // cambia DNI a Cedula cambia la propiedad
    UserEntity convertirUserAUserEntity(User user);

    //@Mapping(target = "propiedad que no tiene blogEntity", ignore = true)
    @Mapping(source = "idUser", target = "idUser")
    @InheritInverseConfiguration
    User convertirUserEntityAUser(UserEntity userEntity);

}
