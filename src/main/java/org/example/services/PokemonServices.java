package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Adestrador;
import org.example.model.Pokemon;
import org.example.repository.AdestradorRepository;
import org.example.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PokemonServices {
    private final PokemonRepository pokeRepo;
    private final AdestradorRepository adRepo;

    public PokemonServices(PokemonRepository pokeRepo, AdestradorRepository adRepo) {
        this.pokeRepo = pokeRepo;
        this.adRepo = adRepo;
    }

    public void crearPoke(Pokemon p){
        pokeRepo.save(p);
    }

    public void importJsonPoke(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Pokemon> pokes = mapper.readValue(
                new File(ruta),
                new TypeReference<List<Pokemon>>() {}
        );
        pokeRepo.saveAll(pokes);
    }

    public Pokemon buscarPoke(String id){
        return pokeRepo.findById(id).orElse(null);
    }

    public List<Pokemon> listarPoke() {
        return pokeRepo.findAll();
    }

    public Adestrador buscarAdePoke (String idPokemon) {
        Pokemon poke = buscarPoke(idPokemon);
        if (poke == null) return null;

        Adestrador ade = adRepo.findById(poke.getAdestradorID()).orElse(null);
        return ade;
    }
}