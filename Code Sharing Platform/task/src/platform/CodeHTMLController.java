package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodeHTMLController {

    @Autowired
    private Code code;

    @GetMapping("/code/new")
    public String codeForm(){
        return "form";
    }

    @GetMapping("/code")
    public String getHTML(Model model){
        model.addAttribute("code", code);
        return "code";
    }
}
