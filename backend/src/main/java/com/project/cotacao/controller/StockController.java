package com.project.cotacao.controller;

import com.project.cotacao.model.dto.StockDTO;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody(required = true) StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody(required = true) StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("DB1");
        dto.setPrice(100D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());
        list.add(dto);

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){

        List<StockDTO> list = new ArrayList<>();
        StockDTO dto1 = new StockDTO();
        dto1.setId(1L);
        dto1.setName("DB1");
        dto1.setPrice(100D);
        dto1.setVariation(10D);
        dto1.setDate(LocalDate.now());

        StockDTO dto2 = new StockDTO();
        dto2.setId(2L);
        dto2.setName("Grupo Mateus");
        dto2.setPrice(100D);
        dto2.setVariation(10D);
        dto2.setDate(LocalDate.now());
        list.add(dto1);
        list.add(dto2);

        StockDTO selected = list.stream().filter(x-> x.getId().compareTo(id) == 0).findFirst().get();

        return ResponseEntity.ok(selected);
    }
}
