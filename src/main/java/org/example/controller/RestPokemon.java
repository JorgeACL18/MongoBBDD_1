package org.example.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.example.model.Adestrador;
import org.example.model.Pokemon;
import org.example.services.PokemonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestPokemon.MAPPING)
public class RestPokemon {
    public static final String MAPPING = "/mongo/pokemon";

    @Autowired
    private PokemonServices pokeServ;

    @PostMapping("/guardarpokes")
    public ResponseEntity<Pokemon> guardarpokes(@RequestBody Pokemon pokes){
        pokeServ.crearPoke(pokes);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/listarpokes")
    public ResponseEntity<List<Pokemon>> listarpokes() {
        List<Pokemon> pokes = pokeServ.listarPoke();
        return new ResponseEntity<>(pokes,HttpStatus.OK);
    }

    @GetMapping("/getAdePoke/{id}")
    public ResponseEntity<Adestrador> actualizar(@PathVariable String id) {
        Adestrador ade = pokeServ.buscarAdePoke(id);
        if (ade == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ade);
    }
}