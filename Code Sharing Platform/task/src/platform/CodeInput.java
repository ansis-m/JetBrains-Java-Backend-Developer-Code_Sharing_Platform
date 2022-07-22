package platform;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeInput {
    String code;
    String time;
    String views;


    public CodeInput(){

    }

    public CodeInput(String code, String time, String views) {
        this.code = code;
        this.time = time;
        this.views = views;
    }
}
