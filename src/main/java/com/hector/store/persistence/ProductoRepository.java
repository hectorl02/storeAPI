package com.hector.store.persistence;

import com.hector.store.domain.Product;
import com.hector.store.domain.repository.ProductRepository;
import com.hector.store.persistence.crud.ProductoCrudRepository;
import com.hector.store.persistence.entity.Producto;
import com.hector.store.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    // query Method
    public List<Producto> getByCategory(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        return Optional.empty();
    }

    @Override
    public Product save(int productId) {
        return null;
    }

    // query Method
    public Optional<List<Producto>>getInsufficient(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void delete (int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
