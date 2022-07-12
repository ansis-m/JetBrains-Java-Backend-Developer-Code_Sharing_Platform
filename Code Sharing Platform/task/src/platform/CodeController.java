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

    String code = "public static void main(String[] args) {" +
            "SpringApplication.run(CodeSharingPlatform.class, args);}";


//    @GetMapping("/code")
//    public ModelAndView getHTML(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("code.html");
//
//        return modelAndView;
//    }

    @GetMapping("/code")
    public String getHTML(){
        String response = "<html>\n" +
                "<head>\n" +
                "<title>" + "Code" + "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<pre>" + code + "</pre>\n" +
                "</body>\n" +
                "</html>";

        return response;
    }


    @GetMapping("/api/code")
    public ResponseEntity getJSON(){

        return new ResponseEntity(Map.of("code", code), HttpStatus.OK);
    }





}
