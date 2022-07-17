package platform;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class Code{

    private String code;
    private LocalDate date;

    public void setCode(String code) {
        this.code = code;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Code() {
        this.code = "new code constructed by SpringBoot";
        date = LocalDate.now();
    }

    public Code(String code) {
        this.code = code;
        date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

}
