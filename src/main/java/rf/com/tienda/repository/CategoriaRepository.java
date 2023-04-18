package rf.com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rf.com.tienda.dominio.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
