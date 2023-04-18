package rf.com.tienda.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.repository.CategoriaRepository;

@Service
public class CategoriaServicio implements ICategoriaServicio{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> leerCategorias(){
		return categoriaRepository.findAll();
	}
	
//	@Override
//	public List<Categoria> leerCategorias(){
//		System.out.println("Leyendo");
//		var categorias = new ArrayList<Categoria>();
//		var categoria = new Categoria();
//		categoria.setId_categoria(1);
//
//		try {
//			categoria.setCat_nombre("Categoria 1");
//			categoria.setCat_descripcion("Descripcion 1");
//			
//		} catch (DomainException e) {
//			
//			System.out.println(e.getMessage());
//		}
//	
//		categorias.add(categoria);
//		
//		System.out.println(categorias.get(0));
//		
//		System.out.println("Guardado datos: " + categorias.size());
//		
//		return categorias;
//	}
	
	@Override
	public Categoria crearCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public ResponseEntity actualizarCategoria(Categoria categoriaNueva, Integer id) throws DomainException {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(!categoria.isPresent()) {
			return new ResponseEntity("No existe la cateogoria con ese ID", HttpStatus.NOT_FOUND);
		}
		
		categoria.get().setCat_nombre(categoriaNueva.getCat_nombre());
		categoria.get().setCat_descripcion(categoriaNueva.getCat_descripcion());
		
		categoriaRepository.save(categoria.get());
		return new ResponseEntity("Actualizado", HttpStatus.OK);

		
	}

	@Override
	public ResponseEntity eliminarCategoria(Integer id) {		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if(!categoria.isPresent()) {
			return new ResponseEntity("No existe la cateogoria con ese ID", HttpStatus.NOT_FOUND);
		}
		
		categoriaRepository.deleteById(id);
		return new ResponseEntity("Borrado", HttpStatus.OK);

	}
}
