package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class CodeServiceImpl implements CodeService{

    private CodeDAO codeDAO;

    @Autowired
    public CodeServiceImpl(CodeDAO codeDAO) {
        this.codeDAO = codeDAO;
    }

    @Override
    @Transactional
    public List<Code> getAll() {
        return codeDAO.getAll();
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
        codeDAO.save(code);
    }

    @Override
    @Transactional
    public Code findById(String id) {
        return codeDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        codeDAO.deleteById(id);

    }
}
