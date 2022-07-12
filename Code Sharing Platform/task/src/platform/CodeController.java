package platform;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class CodeController {


    @GetMapping("/code")
    public ModelAndView getHTML(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("code.html");

        return modelAndView;
    }


    @GetMapping("/api/code")
    public ResponseEntity getJSON(){
        String code = "public static void main(String[] args) {" +
                "SpringApplication.run(CodeSharingPlatform.class, args);}";
        return new ResponseEntity(Map.of("code", code), HttpStatus.OK);
    }





}
