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

    @Bean
    public CommandLineRunner loadData(
            AdestradorRepository adestradorRepo,
            PokemonRepository pokemonRepo
    ) {
        return args -> {

            ObjectMapper mapper = new ObjectMapper();

            InputStream adeStream = getClass().getResourceAsStream("/adestradores.json");
            List<Adestrador> ades = mapper.readValue(
                    adeStream,
                    new TypeReference<List<Adestrador>>() {}
            );
            adestradorRepo.saveAll(ades);

            InputStream pokStream = getClass().getResourceAsStream("/pokemon.json");
            List<Pokemon> pokes = mapper.readValue(
                    pokStream,
                    new TypeReference<List<Pokemon>>() {}
            );

            for (int i = 0; i < pokes.size(); i++) {
                Adestrador entrenador = ades.get(i % ades.size());
                pokes.get(i).setAdestradorID(entrenador.getId());
            }

            pokemonRepo.saveAll(pokes);
            System.out.println("Datos guardados");
        };
    }
}

