package com.tienda.market.persistence.mapper;

import com.tienda.market.domain.PurchaseItem;
import com.tienda.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.crypto.SealedObject;

// Notación Mapper
@Mapper(componentModel = "spring", uses = {ProductMapper.class}) // spring con el fin de poder inyectarlo de otros lugares.
public interface PurchaseItemMapper {
    // Mapper1: de ComprasProducto a PurchaseItem
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"), //source = fuente o atributo de ComprasProducto, target: destino.
            @Mapping(source= "cantidad", target = "quantity"),
           // @Mapping(source = "total", target = "total"), // como el source y el tager son iguales, no es necesario colocarlo.
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    // Mapper2: Inverso ComprasProducto a PurchaseItem
    // Conversión contraria (PurcharseItem a ComprasProducto)
    @InheritInverseConfiguration // Utilizar de manera inversa el Mapper1.
    @Mappings({
            @Mapping(target = "compra", ignore = true), // se ignorar los atributos no mapeados en el anterior Mapper1.
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
