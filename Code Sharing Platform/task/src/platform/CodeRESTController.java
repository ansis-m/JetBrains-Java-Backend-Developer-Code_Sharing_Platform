package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
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
            return new ResponseEntity(codeService.getLatest(), HttpStatus.OK);
        }
        else {
            try {
                Code code = codeService.findById(UUID.fromString(id));
                if(code.limitedTime() && code.remainingTime() < 0)
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                if(code.limitedViews() && code.getViews() >= 0) {
                    code.view();
                    codeService.save(code);

                }
                if (code.getViews() >= 0 || !code.limitedViews()) {
                    return new ResponseEntity(code, HttpStatus.OK);
                }
                else
                    return new ResponseEntity(HttpStatus.NOT_FOUND);

            }
            catch (Exception e) {
                System.out.println("error at /api/code/{id}, bad id: " + id);
                return new ResponseEntity(HttpStatus.NOT_FOUND);
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
    public ResponseEntity updateCode(@RequestBody CodeInput newInput){

        System.out.println("Enter the api/code/new");
        try{
            Code newCode = new Code(newInput);
            codeService.save(newCode);
            System.out.println("the new code in the database id: " + newCode.getId());
            return new ResponseEntity(Map.of("id", newCode.getId().toString()), HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println("bad input format");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
