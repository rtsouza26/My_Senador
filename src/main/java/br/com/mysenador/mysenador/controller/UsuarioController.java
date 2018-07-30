package br.com.mysenador.mysenador.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.mysenador.mysenador.model.User;
import br.com.mysenador.mysenador.repository.UserRep;


@RestController

public class UsuarioController {

	@Autowired
	protected UserRep userRep;
	protected User user = new User();
		
	@CrossOrigin(origins = {"*"})
	@RequestMapping(value = "/api/user/signUp", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String registrarUsuario(@RequestBody String registerForm) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String,Object> map = new HashMap<>();
		
		try {
			map = mapper.readValue(registerForm, Map.class);
			user.setEmail(map.get("email").toString());
			user.setSenha(map.get("password").toString());
			user.setName(map.get("name").toString());
			
			userRep.save(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
			
		return mapper.writeValueAsString(map);
	}
	
	@CrossOrigin(origins = {"*"})
	@RequestMapping(value = "/api/user/sign", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String calcularCategorias(@RequestBody String login) throws JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Map<String,Object> map = new HashMap<>();
		
		try {
			map = mapper.readValue(login, Map.class);
			
			user.setEmail(map.get("email").toString());
			
			User userTemp = userRep.findById(user.getEmail()).get();
			
			if (userTemp != null && userTemp.getSenha().equals(map.get("password").toString())) {
				map.put("confirmLogin", true);
				return mapper.writeValueAsString(map);
			} else {
				map.put("confirmLogin", false);
				return mapper.writeValueAsString(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put("confirmLogin", false);
			return mapper.writeValueAsString(map);
		}
		
		
	}
}
