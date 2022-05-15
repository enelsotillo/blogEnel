package com.enel.enel.domain;
import java.util.Optional;
import com.enel.enel.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> consultarUser(int id){
        return this.userRepository.buscarUserPorId(id);

    }
}
