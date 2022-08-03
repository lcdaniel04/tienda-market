package com.tienda.market.persistence.mapper;

import com.tienda.market.domain.Category;
import com.tienda.market.domain.Client;
import com.tienda.market.domain.Purchase;
import com.tienda.market.persistence.entity.Categoria;
import com.tienda.market.persistence.entity.Cliente;
import com.tienda.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

// Interface Mapper, con componente modelo: spring para poderlo inyectar y usa la clase PurchaseItemMapper.
@Mapper(componentModel = "spring" )
public interface ClienteMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "nombre", target = "name")
    })
    Client toClient(Cliente cliente);

    @InheritInverseConfiguration
    @Mapping(target = "apellidos", ignore = true)
    @Mapping(target = "direccion", ignore = true)
    @Mapping(target = "compras", ignore = true)
    @Mapping(target = "celular", ignore = true)
    Cliente toCliente(Client client);
}
