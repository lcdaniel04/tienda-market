package com.tienda.market.persistence.crud;

import com.tienda.market.persistence.entity.Cliente;
import com.tienda.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioCrudRepository extends CrudRepository<Cliente, Integer> {

    @Query(value="select * from clientes where correo_electronico= ? and password= ? ", nativeQuery = true)
    Cliente findByUserPassword(String correo,String password);

}
