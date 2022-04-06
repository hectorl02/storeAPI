package com.hector.store.persistence.mapper;

import com.hector.store.domain.Category;
import com.hector.store.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory (Categoria categoria);

    @InheritInverseConfiguration // conversion inversa
    @Mapping(target = "productos", ignore = true) // atributo de la relelación
    Categoria toCategory(Category category);

}