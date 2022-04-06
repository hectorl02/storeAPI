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

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    // query Method
    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    @Override
    public Optional<Product> getProduct(int productId){
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    // query Method
    public Optional<List<Producto>>getInsufficient(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }

    @Override
    public void delete (int productId) {
        productoCrudRepository.deleteById(productId);
    }
}
