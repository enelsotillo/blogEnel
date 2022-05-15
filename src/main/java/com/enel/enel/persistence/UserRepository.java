package com.enel.enel.persistence;

import com.enel.enel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private UserMapper userMapper;

    public Optional<User> buscarUserPorId(int id){
        Optional<UserEntity> entityUnSoloUser=this.userCrudRepository.findById(id);
        if (entityUnSoloUser.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(this.userMapper.convertirUserEntityAUser(entityUnSoloUser.get())); // returna el contenido de la caja;

    }
}
