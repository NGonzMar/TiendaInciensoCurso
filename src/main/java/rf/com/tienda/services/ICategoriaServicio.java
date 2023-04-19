package rf.com.tienda.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;

public interface ICategoriaServicio {
	
	List<Categoria> leerCategorias();
	Categoria crearCategoria(Categoria categoria);
	ResponseEntity actualizarCategoria(Categoria categoriaNueva, Integer id) throws DomainException;
	ResponseEntity eliminarCategoria(Integer id);
	ResponseEntity buscarIdCategoria(Integer id);

}