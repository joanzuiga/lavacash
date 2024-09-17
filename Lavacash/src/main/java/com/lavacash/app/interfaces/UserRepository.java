package com.lavacash.app.interfaces;
import com.lavacash.app.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "{call GET_USER_VERIFY(:$correo, :$contrasena)}", nativeQuery = true)
    public User getUserVerify(@Param("$correo") String correo, @Param("$contrasena") String contrasena );
    

    // @Transactional()
    // @Procedure(procedureName = "GET_USER_VERIFY")
    // public User getUserVerify(@Param("$correo") String correo, @Param("$contrasena") String contrasena );
}