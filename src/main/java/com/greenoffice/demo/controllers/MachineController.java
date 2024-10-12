package com.greenoffice.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.greenoffice.demo.models.Machine;
import com.greenoffice.demo.services.MachineService;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    @Autowired
    private MachineService machineService;

    // POST - Adicionar uma máquina
    @PostMapping
    public Machine createMachine(@RequestBody Machine machine) {
        return machineService.createMachine(machine);
    }

    // GET - Listar todas as máquinas
    @GetMapping
    public List<Machine> getAllMachines() {
        return machineService.getAllMachines();
    }

    // GET - Buscar máquina por ID
    @GetMapping("/{id}")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        Machine machine = machineService.getMachineById(id);
        if (machine != null) {
            return ResponseEntity.ok(machine);
        }
        return ResponseEntity.notFound().build();
    }

    // PUT - Atualizar máquina por ID
    @PutMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(@PathVariable Long id, @RequestBody Machine machineDetails) {
        Machine updatedMachine = machineService.updateMachine(id, machineDetails);
        if (updatedMachine != null) {
            return ResponseEntity.ok(updatedMachine);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE - Remover máquina por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        machineService.deleteMachine(id);
        return ResponseEntity.noContent().build();
    }
}
