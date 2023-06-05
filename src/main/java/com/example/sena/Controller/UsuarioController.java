package com.example.sena.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sena.Dto.UserDTORequest;
import com.example.sena.Dto.UserDTOResponse;
import com.example.sena.Repository.IUserRepository;
import com.example.sena.Service.UsuarioService;
import com.example.sena.Service.Impl.UserImpl;

@RestController
@RequestMapping("users")
public class UsuarioController {
	Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	UserImpl userImpl;
	@Autowired
	UsuarioService usuarioService;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createUser(@RequestBody UserDTORequest usuarioDTORequest) {

		logger.info("----HttpRequest Create User ----");
		UserDTOResponse response = userImpl.createUser(usuarioDTORequest);
		logger.info("----Final de la peticion ----");

		return ResponseEntity.ok(response);

	}

	@GetMapping("/read/{id}")
	public ResponseEntity<Map<String, Object>> readUser(@PathVariable Long id) {
		Map<String,Object> response = new HashMap<>();
		List<UserDTOResponse> listUser = this.usuarioService.readUser(id);
		response.put("data", listUser);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateUser(@RequestBody UserDTORequest usuarioDTORequest) {
		return null;

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Object> deleteUser(@PathVariable Long id) {
		try {
			UserDTOResponse res = usuarioService.deleteUser(id);
			
			
			return new ResponseEntity<>(res, HttpStatus.OK);	
			
	}catch(Exception e) {
		logger.info("-----Hubo un error-----");
		
	}
		return null;
	}

}
