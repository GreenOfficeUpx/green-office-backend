package com.greenoffice.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greenoffice.demo.models.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}
