package childcare.controller;

import childcare.model.Child;
import childcare.model.ChildCare;
import childcare.model.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/childcare")
public class ChildCareController {

    @Autowired
    ChildCare childCare;


    @Autowired
    private ChildRepository childRepo;


    @RequestMapping("/listkiddos")
    public String getChildren(Model model){

        List<Child> childrenDB = (List<Child>) childRepo.findAll();

       // model.addAttribute("children" , childCare.getChildren());
        model.addAttribute("children" , childRepo.findAll());
        return "views/list";
    }

}
