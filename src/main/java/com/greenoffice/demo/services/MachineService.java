package com.greenoffice.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greenoffice.demo.models.Machine;
import com.greenoffice.demo.repositories.MachineRepository;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public Machine createMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    public Machine getMachineById(Long id) {
        return machineRepository.findById(id).orElse(null);
    }

    public Machine updateMachine(Long id, Machine machineDetails) {
        Machine machine = machineRepository.findById(id).orElse(null);
        if (machine != null) {
            machine.setName(machineDetails.getName());
            machine.setKwh(machineDetails.getKwh());
            return machineRepository.save(machine);
        }
        return null;
    }

    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }
}
