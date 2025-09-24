package com.coppel.demoapi.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coppel.demoapi.model.Usuarios;
import com.coppel.demoapi.repository.UsuariosRepository;
import com.coppel.demoapi.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuarios> obtenerUsuarios(){
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> obtenerUsuarioPorId(Integer id) { 
        return usuariosRepository.findById(id);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario){
        try {
            return usuariosRepository.save(usuario);
        } catch (Exception e) {
            throw new IllegalStateException("Error al guardar el usuario en la base de datos.", e);
        }
    }

    public Usuarios actualizarUsuario(Integer id, Usuarios usuarioDetalles){
        try {
            Usuarios usuario = usuariosRepository.findById(id).orElseThrow();
            usuario.setNombre(usuarioDetalles.getNombre());
            usuario.setEmail(usuarioDetalles.getEmail());
            return usuariosRepository.save(usuario);
        } catch (Exception e) {
            throw new IllegalStateException("Error al actualizar el usuario en la base de datos", e);
        }
    }

    public Boolean eliminarUsuario(Integer id){
        try {
            usuariosRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}