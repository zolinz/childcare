package childcare.controller;

import childcare.model.Child;
import childcare.model.ChildCare;
import childcare.model.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/childcare")
public class ChildCareController {

    //@Autowired
    //ChildCare childCare;


    @Autowired
    private ChildRepository childRepo;


    @RequestMapping("/listkiddos")
    public String getChildren(Model model){

        // childRepo.findAll() --> implementing: select all
        List<Child> childrenDB = (List<Child>) childRepo.findAll();  // It will return a child list -- array list

       // model.addAttribute("children" , childCare.getChildren());
        model.addAttribute("children" , childRepo.findAll());
        return "views/list";
    }


    @GetMapping("/enrollment")
    public String greetingForm(Model model) {
        model.addAttribute("child", new Child());
        return "enrollment";
    }

    @PostMapping("/enrollment")
    public String greetingSubmit(@ModelAttribute Child child) {
        childRepo.save(child);
        return "result";
    }





}
