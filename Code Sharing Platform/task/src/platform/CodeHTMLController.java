package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class CodeHTMLController {


    private CodeService codeService;

    @Autowired
    public CodeHTMLController(CodeService codeService){
        this.codeService = codeService;
    }

    @GetMapping("/code/{id}")
    public String codeForm(@PathVariable String id, Model model){

        if(id.equals("new"))
            return "form";
        else if(id.equals("latest")){
            model.addAttribute("latest", codeService.getLatest());
            return "latest";
        }
        else {
            try{
                Code code = codeService.findById(UUID.fromString(id));
                if(code.limitedViews() && code.getViews() >= 0) {
                    code.view();
                    codeService.save(code);

                }
                if (code.getViews() >= 0 || !code.limitedViews()) {
                    model.addAttribute("code", code);
                    return "code";
                }
            }
            catch (Exception e){
                System.out.println("bad code id at /code/{id}!");
                return "error";
            }
            return "error";
        }
    }
}
