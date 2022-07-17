package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class CodeRESTController {

    @Autowired
    private CodeRepository codeRepository;

    @GetMapping("/api/code/{id}")
    public ResponseEntity getJSON(@PathVariable String id){

        if(id.equals("latest")) {
            List<Code> result = codeRepository.getLatest();
            return new ResponseEntity(result, HttpStatus.OK);
        }
        else {
            try {
                int i = Integer.parseInt(id);
                Code code = codeRepository.get(i);
                return new ResponseEntity(code, HttpStatus.OK);

            }
            catch (Exception e) {
                System.out.println("error at /api/code/{id}, bad id: " + id);
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PostMapping ("api/code/new")
    public ResponseEntity updateCode(@RequestBody Code newCode){

        codeRepository.update(newCode);
        return new ResponseEntity(Map.of("id", String.valueOf(codeRepository.size())), HttpStatus.OK);
    }
}
