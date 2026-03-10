package altn72.TpFilRouge.controller;

import altn72.TpFilRouge.model.Programmer;
import altn72.TpFilRouge.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgrammerService {

    @Autowired
    private ProgrammerRepository programmerRepository;

    public List<Programmer> getProgrammers() {
        return programmerRepository.findAll();
    }

    public Optional<Programmer> getProgrammerById(Integer id) {
        return programmerRepository.findById(id);
    }

    public void deleteProgrammerById(Integer id) {
        programmerRepository.deleteById(id);

    }

    public void addProgrammer(Programmer programmer) {
        programmerRepository.save(programmer);
    }

    public Programmer updateProgrammer(Programmer programmer) {
        System.out.println("Before save: " + programmer);
        return programmerRepository.save(programmer);
    }

}
