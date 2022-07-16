package platform;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Code {

    private String code;
    private LocalDate date;
    private final String initialCode = "public static void main(String[] args) {" +
            "SpringApplication.run(CodeSharingPlatform.class, args);}";

    public Code(String code) {
        this.code = code;
        date = LocalDate.now();
    }

    public Code() {
        code = initialCode;
        date = LocalDate.now();
    }
    public void updateCode(Code newCode){
        code = newCode.getCode();
        date = newCode.getDate();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

}
