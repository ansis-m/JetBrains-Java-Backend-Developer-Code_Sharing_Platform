package platform;

import java.util.List;

public interface CodeService {

    public List<Code> getAll();
    public List<Code> getLatest();
    public void save(Code code);
    Code findById(String id);
    void deleteById(String ID);
}
