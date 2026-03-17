package altn72.TpFilRouge.controller;

import altn72.TpFilRouge.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import altn72.TpFilRouge.controller.ProgrammerService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProgrammerController {

    @Autowired
    private ProgrammerService programmerService;
    //display last programmer's firstname
    @GetMapping("/programmers/lastProgrammerName")
    public String showLastProgrammerName(Model model) {
        List<Programmer> list = programmerService.getProgrammers();
        Programmer lastProgrammer = list.get(list.size() - 1);
        model.addAttribute("programmer", lastProgrammer);
        return "detailsProgrammer";
    }
    //display list of programmers
    @GetMapping("/programmers/list")
    public String showProgrammerList(Model model) {
        List<Programmer> listProgrammers = programmerService.getProgrammers();
        model.addAttribute("listProgrammers", listProgrammers);
        return "listProgrammers";
    }
    //delete programmer
    @PostMapping("/programmers/delete/{id}")
    public String deleteProgrammer(@PathVariable Integer id) {
        programmerService.deleteProgrammerById(id);
        return "redirect:/programmers/list";
    }
    //add new programmer
    @GetMapping("/programmers/new")
    public String showAddForm() {
        return "newProgrammer";
    }
    @PostMapping("/programmers/add")
    public String addProgrammerInfo(@ModelAttribute Programmer programmer) {
        programmerService.addProgrammer(programmer);
        return "redirect:/programmers/list";
    }
    //edit programmer
    @GetMapping("/programmers/edit/{id}")
    public String editProgrammerInfo(Model model, @PathVariable Integer id) {
        Optional<Programmer> programmer = programmerService.getProgrammerById(id);
        if (programmer.isPresent()) {
            model.addAttribute("programmer", programmer.get());
            return "editProgrammer";
        } else {
            System.out.println("This programmer does not exist");
            return null;
        }
    }
    @PostMapping("/programmers/update")
    public String updateProgrammerInfo(@RequestParam Integer id,
                                       @ModelAttribute Programmer programmer) {
        programmer.setId(id);
        programmerService.updateProgrammer(programmer);
        return  "redirect:/programmers/list";
    }
}
