package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CodeHTMLController {

    @Autowired
    private CodeRepository codeRepository;

    @GetMapping("/code/{id}")
    public String codeForm(@PathVariable String id, Model model){

        if(id.equals("new"))
            return "form";
        else if(id.equals("latest")){
            model.addAttribute("latest", codeRepository.getLatest());
            return "latest";
        }
        else {
            try{
                int i = Integer.parseInt(id);
                model.addAttribute("code", codeRepository.get(i));
                return "code";
            }
            catch (Exception e){
                System.out.println("bad code id at /code/{id}!");
                return "error";
            }
        }
    }
}
