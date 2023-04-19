package rf.com.tienda.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import rf.com.tienda.repository.CategoriaRepository;

@Service
public class CategoriaServicio implements ICategoriaServicio {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> leerCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public ResponseEntity actualizarCategoria(Categoria categoriaNueva, Integer id) throws DomainException {
		Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
		if (categoriaOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Categoria categoria = categoriaOpt.get();
		categoria.setCat_nombre(categoriaNueva.getCat_nombre());
		categoria.setCat_descripcion(categoriaNueva.getCat_descripcion());

		categoriaRepository.save(categoria);
		return ResponseEntity.ok("Se ha actualizado la categoria correctamente.");
	}

	@Override
	public ResponseEntity eliminarCategoria(Integer id) {
		if (categoriaRepository.existsById(id)) {
			categoriaRepository.deleteById(id);
			return ResponseEntity.ok("Se ha eliminado la categoria correctamente.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Override
	public ResponseEntity<Categoria> buscarIdCategoria(Integer id) {
	    Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);

	    if (categoriaOpt.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    Categoria categoria = categoriaOpt.get();

	    return ResponseEntity.ok(categoriaOpt.get());
	}

}
