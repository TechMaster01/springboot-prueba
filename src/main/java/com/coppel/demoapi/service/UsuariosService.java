package com.coppel.demoapi.service;

import java.util.List;
import java.util.Optional;

import com.coppel.demoapi.model.Usuarios;

public interface UsuariosService {
    List<Usuarios> obtenerUsuarios();
    Optional<Usuarios> obtenerUsuarioPorId(Integer id);
    public Usuarios guardarUsuario(Usuarios usuarios);
    public Usuarios actualizarUsuario(Integer id, Usuarios usuarios);
    public Boolean eliminarUsuario(Integer id);
}
