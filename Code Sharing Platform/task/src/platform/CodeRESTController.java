package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class CodeRESTController {


    private CodeService codeService;

    @Autowired
    public CodeRESTController(CodeService codeService){
        this.codeService = codeService;
    }

    @GetMapping("/api/code/{id}")
    public ResponseEntity getJSON(@PathVariable String id){

        if(id.equals("latest")) {
            List<Code> result = codeService.getLatest();
            return new ResponseEntity(result, HttpStatus.OK);
        }
        else {
            try {
                Code code = codeService.findById(UUID.fromString(id));
                return new ResponseEntity(code, HttpStatus.OK);

            }
            catch (Exception e) {
                System.out.println("error at /api/code/{id}, bad id: " + id);
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping ("database")
    public ResponseEntity showDatabase(){

        Map<String, String> result = new HashMap<>();
        for(Code c : codeService.getAll()) {
            result.put(c.getId().toString(), c.getCode());
            System.out.println(c.getCode());
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping ("api/code/new")
    public ResponseEntity updateCode(@RequestBody Code newCode){

        System.out.println("Enter the api/code/new");
        codeService.save(newCode);
        System.out.println("the new code in the database id: " + newCode.getId());
        return new ResponseEntity(Map.of("id", newCode.getId().toString()), HttpStatus.OK);
    }
}
