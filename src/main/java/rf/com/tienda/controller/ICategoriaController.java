package rf.com.tienda.controller;

import java.util.List;

import rf.com.tienda.dominio.Categoria;

public interface ICategoriaController {

	List<Categoria> leerTodo();
	Categoria crear();
	
}
