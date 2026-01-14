package org.example.controller;

import org.example.model.Adestrador;
import org.example.services.AdestradorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestAdestrador.MAPPING)
public class RestAdestrador {
    public static final String MAPPING = "/mongodb/adestrador";

    @Autowired
    private AdestradorServices adeServ;

    @PostMapping("/guardarades")
    public ResponseEntity<Adestrador> guardarades(@RequestBody Adestrador ade) {
        adeServ.crearAdestrador(ade);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listarades")
    public ResponseEntity<List<Adestrador>> listarades() {
        List<Adestrador> ades = adeServ.listAdestrador();
        return new ResponseEntity<>(ades,HttpStatus.OK);
    }

    @GetMapping("/test")
    public String testConexion() {
        return "Conexión con MongoDB exitosa";
    }
}
