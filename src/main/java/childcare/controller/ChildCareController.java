package childcare.controller;

import childcare.domain.Child;
import childcare.domain.ChildCare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cc")
public class ChildCareController {

    @Autowired
    ChildCare childCare;


    @RequestMapping("/getChildren")
    @ResponseBody
    public List<Child> getChildren(){
        return childCare.getChildren();
    }

}
