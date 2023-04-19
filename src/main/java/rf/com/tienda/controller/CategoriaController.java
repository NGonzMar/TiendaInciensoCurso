package rf.com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.services.ICategoriaServicio;

@RestController
@RequestMapping("/categoria")
public class CategoriaController implements ICategoriaController {

    @Autowired
    private ICategoriaServicio iCategoriaServicio;

    @GetMapping("/listar")
    public List<Categoria> listaCategoria() {
        return iCategoriaServicio.leerCategorias();
    }

    @PostMapping("/añadir")
    public String addNewCategoria(@RequestBody Categoria categoria) {
        iCategoriaServicio.crearCategoria(categoria);
        return "Se ha añadido la categoria.";
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateCategoria(@RequestBody Categoria categoriaNueva, @PathVariable Integer id) throws DomainException {
        return iCategoriaServicio.actualizarCategoria(categoriaNueva, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Integer id) {
        return iCategoriaServicio.eliminarCategoria(id);
    }

    @GetMapping("/listar/{id}")
	public ResponseEntity buscarIdCategoria(Integer id) {
		return iCategoriaServicio.buscarIdCategoria(id);
	}
}
