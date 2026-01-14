package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Adestrador;
import org.example.model.Pokemon;
import org.example.repository.AdestradorRepository;
import org.example.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
@ComponentScan({"org.example"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

   /* @Bean
    public CommandLineRunner loadData(
            AdestradorRepository adestradorRepo,
            PokemonRepository pokemonRepo
    ) {
        return args -> {

            ObjectMapper mapper = new ObjectMapper();

            InputStream adestradoresStream = getClass().getResourceAsStream("/adestradores.json");
            List<Adestrador> adestradores = mapper.readValue(
                    adestradoresStream,
                    new TypeReference<List<Adestrador>>() {}
            );
            adestradorRepo.saveAll(adestradores);

            InputStream pokemonStream = getClass().getResourceAsStream("/pokemon.json");
            List<Pokemon> pokemons = mapper.readValue(
                    pokemonStream,
                    new TypeReference<List<Pokemon>>() {}
            );

            for (int i = 0; i < pokemons.size(); i++) {
                Adestrador dueño = adestradores.get(i % adestradores.size());
                pokemons.get(i).setAdestradorID(dueño.getId());
            }

            pokemonRepo.saveAll(pokemons);
            System.out.println("Datos guardados");
        };
    }*/
}

