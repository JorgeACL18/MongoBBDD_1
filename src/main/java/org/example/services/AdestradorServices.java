package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Adestrador;
import org.example.repository.AdestradorRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AdestradorServices {
    private final AdestradorRepository adRepo;

    public AdestradorServices(AdestradorRepository adRepo){
        this.adRepo = adRepo;
    }

    public Adestrador crearAdestrador(Adestrador ad) {
        return adRepo.save(ad);
    }

    public void importJsonAdestrador(String ruta) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Adestrador> ades = mapper.readValue(
                new File(ruta),
                new TypeReference<List<Adestrador>>() {}
        );
        adRepo.saveAll(ades);
    }

    public Adestrador buscarAdestrador(String id) {
        return adRepo.findById(id).orElse(null);
    }

    public List<Adestrador> listAdestrador () {
        return adRepo.findAll();
    }
}