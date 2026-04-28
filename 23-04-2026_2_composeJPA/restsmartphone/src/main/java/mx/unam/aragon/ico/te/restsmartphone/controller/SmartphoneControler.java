package mx.unam.aragon.ico.te.restsmartphone.controller;


import mx.unam.aragon.ico.te.restsmartphone.model.Smartphone;
import mx.unam.aragon.ico.te.restsmartphone.repository.SmartphoneInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/smartphones")
public class SmartphoneControler {

    private final SmartphoneInterface repository;

    public SmartphoneControler(SmartphoneInterface repository) {
        this.repository = repository;
    }
    @GetMapping
    public List<Smartphone> getAll() {
        return repository.findAll();
    }

    @GetMapping("/test")
    public Smartphone test() {
        Smartphone s = new Smartphone();
        s.setMarca("Samsung");
        s.setModelo("S23");
        return s;
    }

    @PostMapping
    public Smartphone create(@RequestBody Smartphone smartphone) {

        return repository.save(smartphone);
    }

    @GetMapping("/{id}")
    public Smartphone getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Smartphone update(@PathVariable Long id, @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        return repository.save(smartphone);
    }



    }

