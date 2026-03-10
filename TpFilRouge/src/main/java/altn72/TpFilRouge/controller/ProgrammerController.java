package altn72.TpFilRouge.controller;

import altn72.TpFilRouge.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import altn72.TpFilRouge.controller.ProgrammerService;


import java.util.ArrayList;
import java.util.List;

@RestController
public class ProgrammerController {

    @Autowired
    private ProgrammerService programmerService;

    @GetMapping("/programmers")
    public List<Programmer> displayProgrammerInfo() {
        return programmerService.getProgrammers();

    }

    @GetMapping("/programmers/{id}")
    public Programmer displayProgrammerInfoById(@PathVariable Integer id) {
        if (programmerService.getProgrammerById(id).isPresent()) {
            return programmerService.getProgrammerById(id).get();
        } else {
            System.out.println("This programmer does not exist");
            return null;
        }
    }

    @DeleteMapping("/programmers/delete/{id}")
    public void deleteProgrammerInfo(@PathVariable Integer id) {
        if (programmerService.getProgrammerById(id).isPresent()) {
            programmerService.deleteProgrammerById(id);
        } else {
            System.out.println("This programmer does not exist");
        }
    }

    @PostMapping("/programmers/add")
    public void addProgrammerInfo(@RequestBody Programmer programmer) {
        programmerService.addProgrammer(programmer);
    }

    @PutMapping("/programmers/put/{id}")
    public Programmer updateProgrammerInfo(@PathVariable Integer id,
                                     @RequestBody Programmer programmer) {
        programmer.setId(id);
        System.out.println("PUT received: " + programmer);
        return programmerService.updateProgrammer(programmer);
    }

}
