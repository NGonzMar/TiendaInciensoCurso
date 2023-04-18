package rf.com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.repository.CategoriaRepository;
import rf.com.tienda.services.ICategoriaServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.services.ICategoriaServicio;

@RestController
@RequestMapping(path="/categoria")
public class CategoriaController implements ICategoriaController{
	
//	@GetMapping("/hola")
//	public String prueba() {
//		return "hola";
//	}
	
	@Autowired 
	private ICategoriaServicio iCategoriaServicio;
	
	@Override
	@GetMapping(path = "/all")
	public List<Categoria> listaCategoria() {
		return iCategoriaServicio.leerCategorias();
	}
	
	@Override
	@PostMapping(path = "/add")
	public @ResponseBody String addNewCategoria (@RequestBody Categoria categoria) {
		iCategoriaServicio.crearCategoria(categoria);
		return "Saved";
	}
	
	@Override
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> updateCategoria(@RequestBody Categoria cateogiraNueva, @PathVariable Integer id) throws DomainException{
		return iCategoriaServicio.actualizarCategoria(cateogiraNueva, id);
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Integer id) {
		return iCategoriaServicio.eliminarCategoria(id);
	}
	

}
