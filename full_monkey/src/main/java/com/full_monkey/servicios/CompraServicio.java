/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.full_monkey.servicios;

import com.full_monkey.entidades.Carrito;
import com.full_monkey.entidades.Compra;
import com.full_monkey.repository.CompraRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServicio {
     @Autowired
    private CompraRepository compraRepositorio;
     @Transactional
    public void guardar (Compra compra){
        compraRepositorio.save(compra);
    }
    @Transactional
    public void eliminar (Compra compra){
       compraRepositorio.delete(compra);
    }
    @Transactional
    
    public Compra crearCompra(){
    Compra compra= new Compra();
    compra.setFecha_compra(fecha_compra);
    compra.setCarro(carro);
    compra.setMetodopago(metodopago);
    compra.setPrecio_final(precio_final);
    return compraRepositorio.save(compra);
    }
    @Transactional
    public Compra modificar(String id, Date fecha_compra, Carrito carro, String metodopago, Double precio_final) throws Exception{
 
   Optional<Compra>compraTraida= compraRepositorio.findById(id);
   if (compraTraida.isPresent()){
   Compra compra = compraTraida.get();
    compra.setfecha_compra(fecha_compra);
    compra.setCarro(carro);
    compra.setMetodopago(metodopago);
    compra.setPrecio_final(precio_final);
    return compraRepositorio.save(compra);
   }else throw new Exception("no existe una compra con esde Id");
   }
}

    
}
