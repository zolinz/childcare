package childcare.controller;

import childcare.model.ChildCare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cc")
public class ChildCareController {

    @Autowired
    ChildCare childCare;


    @RequestMapping("/listkiddos")
    public String getChildren(Model model){

        model.addAttribute("children" , childCare.getChildren());
        return "views/list";
    }

}
