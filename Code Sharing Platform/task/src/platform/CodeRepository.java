package platform;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CodeRepository {

    private ArrayList<Code> codeRepository;

    public CodeRepository() {
        codeRepository = new ArrayList<>();
    }

    public int size() {
        return codeRepository.size();
    }

    public void update(Code newCode){
        codeRepository.add(newCode);
    }

    public Code get(int i){
        return codeRepository.get(i - 1);
    }

    public List<Code> getLatest(){

        int size = codeRepository.size();
        List<Code> latest = (List<Code>) codeRepository.clone();
        if (size >= 11) {
            latest = latest.subList(size - 10, size);
        }
        Collections.reverse(latest);
        return latest;
    }
}
