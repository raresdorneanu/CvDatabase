package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Cv;
import net.javaguides.springboot.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CvController {
    @Autowired
    private CvService cvService;

    @GetMapping("/see_all_cvs")
    public String allCvs(Model model, @Param("keyword") String keyword) {
        List<Cv> allCvs = cvService.getAllCvs(keyword);
        model.addAttribute("allCvs", allCvs);
        return "see_all_cvs";
    }

    @PostMapping("/saveCv")
    public String saveCv(@ModelAttribute("cv") Cv cv) {
        // save employee to database
        cvService.saveCv(cv);
        return "redirect:/";
    }

    @GetMapping("/showNewCvForm")
    public String showNewCvForm(Model model) {
        // create model attribute to bind form data
        Cv cv = new Cv();
        model.addAttribute("cv", cv);
        return "new_cv";
    }

    @GetMapping("/showCvFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get employee from the service
        Cv candidate = cvService.getCandidateById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("candidate", candidate);
        return "update_cv";
    }

    @GetMapping("/showParticularCv/{id}")
    public String showParticularCv(@PathVariable( value = "id") long id, Model model) {
        Cv particular = cvService.getCv(id);
        model.addAttribute("particular", particular);
        return "particular_cv";
    }
}
