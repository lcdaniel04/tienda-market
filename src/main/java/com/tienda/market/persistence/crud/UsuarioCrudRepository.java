package com.tienda.market.persistence.crud;

import com.tienda.market.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {

    @Query(value="select * from clientes where correo_electronico= ? and password= ? ", nativeQuery = true)
    Usuario findByUserPassword(String correo, String password);

}
