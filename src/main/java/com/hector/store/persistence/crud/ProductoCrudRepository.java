package com.hector.store.persistence.crud;

import com.hector.store.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {


    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria); // query Method => 1 manera
    // otra manera
    // @Query(value = "select + from products where id_category = ?", nativeQuery = true) //  query Method manera nativa

    // query Method => 1 manera
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidad, boolean estado);

}
