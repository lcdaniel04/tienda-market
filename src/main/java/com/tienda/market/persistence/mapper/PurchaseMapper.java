package com.tienda.market.persistence.mapper;

import com.tienda.market.domain.Purchase;
import com.tienda.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

// Interface Mapper, con componente modelo: spring para poderlo inyectar y usa la clase PurchaseItemMapper.
@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    // obtener un Puchase a partir de una Compra.
    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items") // Lo usa PurchaseItemMapper para convertirlos uno a uno.
    })
    Purchase toPurchse(Compra compra);
    // Toma automaticamenteel Mappins - singular.
    List<Purchase> toPurchases(List<Compra> compras);

    // Conversión Inversa
    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true) // se ingnora
    Compra toCompra(Purchase purchase);
}
