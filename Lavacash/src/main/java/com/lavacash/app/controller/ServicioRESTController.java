package com.lavacash.app.controller;

import com.lavacash.app.domain.ServicioJPA;
import com.lavacash.app.services.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio/api")
public class ServicioRESTController {
    
    @Autowired
    private ServicioService servicioService;
    
    @GetMapping("/")
    public List<ServicioJPA> listar() {
        List<ServicioJPA> servicios = servicioService.obtener();
        return servicios;
    }
    
    @PostMapping("/")
    public int guardar (@RequestBody ServicioJPA servicio) {
        return servicioService.guardar(servicio);
    }
    
   @DeleteMapping("/{id}")
    public void eliminar (@PathVariable int id) {
        servicioService.eliminar(id);
    }
}
