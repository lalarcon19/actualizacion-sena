package com.example.sena.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sena.Dto.UserDTORequest;
import com.example.sena.Dto.UserDTOResponse;
import com.example.sena.Entity.Usuario;
import com.example.sena.Repository.IUserRepository;
import com.example.sena.Service.UsuarioService;

public class UserImpl implements UsuarioService{
	Logger logger = LoggerFactory.getLogger(UserImpl.class);
  
	@Autowired
	IUserRepository userRepo;
     
	@Override
	public UserDTOResponse createUser(UserDTORequest usuarioDTORequest) {
		// TODO Auto-generated method stub
		logger.info("---llego al service--");

		Usuario entity = new Usuario();
		entity.setId(usuarioDTORequest.getId());
		entity.setUserName(usuarioDTORequest.getUserName());
		entity.setPassword(usuarioDTORequest.getPassword());
		entity = userRepo.save(entity);

		logger.info("--Registro en base de datos--");

		UserDTOResponse response = new UserDTOResponse();
		response.setId(entity.getId());
		response.setPassword(entity.getPassword());
		response.setUserName(entity.getUserName());
		logger.info("--termino al proceso del service");
		return response;
	}

	@Override
	public List<UserDTOResponse> readUser(Long id) {
		UserDTOResponse userResponse = new UserDTOResponse();
		List<Usuario> listUsuario= userRepo.findAll();
		return listUsuario.stream().map(user -> BeanUtils.copyProperties(listUsuario,userResponse));
	}

	@Override
	public UserDTOResponse update(UserDTORequest usuarioDTORequest) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public UserDTOResponse deleteUser(Long id) {

		UserDTOResponse response = new UserDTOResponse();
		try {
			logger.info("-------Entro a la base de datos------- ");
			Optional<Usuario> usuarioDelete = userRepo.findById(id);

			if (usuarioDelete != null) {
				userRepo.deleteById(id);
			}
			logger.info("-----El ususario ha sido eliminado-------- ");

		} catch (Exception e) {
			logger.info("-----Error----" + e);
		}
		return null;
	}

	@Override
	public Usuario readUsuario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
