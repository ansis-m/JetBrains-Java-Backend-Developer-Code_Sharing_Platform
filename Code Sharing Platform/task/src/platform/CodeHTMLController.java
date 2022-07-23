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
                Code code = codeService.findById(UUID.fromString(id));
                if(code.limitedTime() && code.remainingTime() < 0)
                    throw new OutOfTimeException();
                if(code.limitedViews() && code.getViews() >= 0) {
                    code.view();
                    codeService.save(code);
                }
                if (code.getViews() >= 0 || !code.limitedViews()) {
                    model.addAttribute("code", code);
                    return "code";
                }
                else if (code.getViews() <= 0 || code.limitedViews())
                    throw new OutOfViewsException();
        }
        return "error";
    }
}
