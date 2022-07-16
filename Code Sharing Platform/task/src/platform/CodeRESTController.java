package platform;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CodeRESTController {

    @Autowired
    private Code code;

    @GetMapping("/api/code")
    public ResponseEntity getJSON(){

        return new ResponseEntity(code, HttpStatus.OK);
    }

    @PostMapping ("api/code/new")
    public ResponseEntity updateCode(@RequestBody Code newCode){
        code.updateCode(newCode);
        return new ResponseEntity(Map.of(), HttpStatus.OK);
    }
}
