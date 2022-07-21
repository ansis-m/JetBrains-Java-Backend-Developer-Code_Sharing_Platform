package platform;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface CodeService {

    public List<Code> getAll();
    public List<Code> getLatest();
    public void save(Code code);
    Code findById(UUID id);
    void deleteById(UUID id);

}
