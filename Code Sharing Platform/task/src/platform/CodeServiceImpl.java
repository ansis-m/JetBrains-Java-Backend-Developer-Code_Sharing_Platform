package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class CodeServiceImpl implements CodeService{

    private CodeRepository codeRepository;

    @Autowired
    public CodeServiceImpl(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    @Transactional
    public List<Code> getAll() {

        return codeRepository.findAll();
    }

    @Override
    @Transactional
    public List<Code> getLatest() {
        List<Code> codeList = this.getAll();
        int i = codeList.size();
        if (i >= 11) {
            codeList = codeList.subList(i - 10, i);
        }
        Collections.reverse(codeList);
        return codeList;
    }

    @Override
    @Transactional
    public void save(Code code) {
        codeRepository.save(code);
    }

    @Override
    @Transactional
    public Code findById(UUID id) {
        return codeRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        codeRepository.deleteById(id);

    }
}
