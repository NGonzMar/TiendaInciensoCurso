package rf.com.tienda.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;

public interface ICategoriaServicio {
	
	public abstract List<Categoria> leerCategorias();
	public abstract Categoria crearCategoria(Categoria categoria);
	public abstract ResponseEntity actualizarCategoria(Categoria categoriaNueva, Integer id) throws DomainException;
	public abstract ResponseEntity eliminarCategoria(Integer id);

}