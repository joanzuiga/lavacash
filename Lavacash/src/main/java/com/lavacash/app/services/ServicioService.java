package com.lavacash.app.services;

import com.lavacash.app.domain.ServicioJPA;
import com.lavacash.app.interfaces.IServicio;
import com.lavacash.app.interfacesService.IServicioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioService implements IServicioService{

    @Autowired
    private IServicio servicioData;
    
    @Override
    public List<ServicioJPA> obtener() {
        return (List<ServicioJPA>) servicioData.findAll();
    }

    @Override
    public Optional<ServicioJPA> obtenerPorId(int id) {
        return servicioData.findById(id);
    }

    @Override
    public int guardar(ServicioJPA servicio) {
        ServicioJPA nServicio = servicioData.save(servicio);
        return (nServicio != null) ? 1 : 0;
    }

    @Override
    public void eliminar(int id) {
        servicioData.deleteById(id);
    }
    
}
