package com.coppel.demoapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coppel.demoapi.model.Usuarios;
import com.coppel.demoapi.service.UsuariosService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping(path="/api/v1/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/")
    public ResponseEntity<List<Usuarios>> obtenerUsuarios() {
        List<Usuarios> usuarios = usuariosService.obtenerUsuarios();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(usuarios, HttpStatus.OK);   
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerUsuarioPorId(@PathVariable String id) {
        int identifier = Integer.parseInt(id);

        Optional<Usuarios> usuario = usuariosService.obtenerUsuarioPorId(identifier);
        if (usuario.isPresent()) {
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado.", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(value = "/", method=RequestMethod.POST)
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuarios usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            return new ResponseEntity<>("Error: El nombre del usuario no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        if(usuario.getEmail() == null || usuario.getEmail().isEmpty()){
            return new ResponseEntity<>("Error: el campo de email no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }
        Usuarios nuevoUsuario = usuariosService.guardarUsuario(usuario);

        if (nuevoUsuario != null) {
            return new ResponseEntity<>("Usuario guardado con éxito.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Error al guardar el usuario.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarUsuario(@PathVariable String id, @RequestBody Usuarios usuarioDetalles) {
        int identifier = Integer.parseInt(id);
    
        Usuarios usuarioActualizado = usuariosService.actualizarUsuario(identifier, usuarioDetalles);
    
        if (usuarioActualizado != null) {
            return new ResponseEntity<>("Respuesta: usuario actualizado correctamente, \n" + usuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al actualizar el usuario o usuario no encontrado.", HttpStatus.NOT_FOUND);
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String id){
        int identifier = Integer.parseInt(id);

        Optional<Usuarios> usuario = usuariosService.obtenerUsuarioPorId(identifier);
        if (usuario.isPresent()) {
            if (usuariosService.eliminarUsuario(identifier)) {
                return new ResponseEntity<>("Usuario eliminado correctamente.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Error del servidor.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Usuario no encontrado.", HttpStatus.NOT_FOUND);
        }
    }

}
