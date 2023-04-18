package rf.com.tienda.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;

public interface ICategoriaController {

	public abstract List<Categoria> listaCategoria();

	public abstract String addNewCategoria(Categoria categoria);

	public abstract ResponseEntity updateCategoria(Categoria categoriaNueva, Integer id) throws DomainException;

	public abstract ResponseEntity deleteCategoria(Integer id);

}
