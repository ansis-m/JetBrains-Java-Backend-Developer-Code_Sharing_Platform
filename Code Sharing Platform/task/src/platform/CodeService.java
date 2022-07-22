package platform;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface CodeService {

    List<Code> getAll();
    List<Code> getLatest();
    void save(Code code);
    Code findById(UUID id);
    void deleteById(UUID id);

}
