package com.coppel.demoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coppel.demoapi.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    //public List<Usuarios> buscarPorEmail(String email);
    //public List<Usuarios> buscarPorNombreYEmail(String nombre, String email);

    public List<Usuarios> findByEmail(String email);
}
