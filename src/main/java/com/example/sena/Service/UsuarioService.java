package com.example.sena.Service;

import java.util.List;

import com.example.sena.Dto.UserDTORequest;
import com.example.sena.Dto.UserDTOResponse;
import com.example.sena.Entity.Usuario;

public interface UsuarioService  {

	
	UserDTOResponse createUser (UserDTORequest usuarioDTORequest) ;
	List<UserDTOResponse> readUser (Long id);
	UserDTOResponse update (UserDTORequest usuarioDTORequest);
	UserDTOResponse deleteUser (Long id );
	Usuario readUsuario(Long id);
	
	
	
}

