package br.com.mysenador.mysenador.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mysenador.mysenador.model.Categorias;
import br.com.mysenador.mysenador.model.CategoriasPorParlamentar;
import br.com.mysenador.mysenador.repository.CategoriasRep;


@RestController

public class CategoriasController {

	@Autowired
	protected CategoriasRep categoriarep;
	protected Categorias categorias = new Categorias();
	List<Categorias> cat = new ArrayList<Categorias>();
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@CrossOrigin(origins = {"*"})
	@RequestMapping("categoria")
	public String categorias(@RequestParam String categoria) {

		categorias.setCategoria(categoria);
		categoriarep.save(categorias);

		return "index1";
	}
	
	@CrossOrigin(origins = {"*"})
	@RequestMapping("/api/categories/all")
	public String todascategorias() throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<>();
		cat = (List<Categorias>) categoriarep.findAll();
		
		map.put("categories", cat);
			
		return mapper.writeValueAsString(map);
	}
	
	@CrossOrigin(origins = {"*"})
	@RequestMapping(value = "api/categories/calculate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String calcularCategorias(@RequestBody String categories) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String,Object> map = new HashMap<>();
		
		EntityManager em = emf.createEntityManager();;
		List<CategoriasPorParlamentar> categoriasParlamentar = new ArrayList<>();
		
		cat = mapper.readValue(categories, new TypeReference<List<Categorias>>(){});
		for(int i = cat.size()-1; i >= 0; i++) {
			List<CategoriasPorParlamentar> l = em.createQuery("SELECT DISTINCT catParl FROM CategoriasPorParlamentar catParl "
					+ "where categoria = '" + cat.get(i).getCategoria() 
					+ "' order by numero_pls DESC", CategoriasPorParlamentar.class).setMaxResults(5).getResultList();

			//colocar os pesos de cada candidato, por suas pls
			for (CategoriasPorParlamentar category : l) {
				category.setNumero_pls(i * category.getNumero_pls());
			}
			
			categoriasParlamentar.addAll(l);
		}

		map.put("senadores", categoriasParlamentar);
		return mapper.writeValueAsString(map);

	}
	
}
