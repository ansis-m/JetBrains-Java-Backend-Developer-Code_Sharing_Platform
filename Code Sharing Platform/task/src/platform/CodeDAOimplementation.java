package platform;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class CodeDAOimplementation implements CodeDAO{


    private EntityManager entityManager;

    @Autowired
    public CodeDAOimplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Code> getAll() {

        // get the session
        Session session = entityManager.unwrap(Session.class);
        // create a query
        Query<Code> query = session.createQuery("from Code", Code.class);
        // execute a query
        List<Code> codeList = query.getResultList();
        // return results
        return codeList;

    }

    @Override
    @Transactional
    public List<Code> getLatest() {
        Session session = entityManager.unwrap(Session.class);
        Query<Code> query = session.createQuery("from Code", Code.class);
        List<Code> codeList = query.getResultList();
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
        System.out.println("saving in the H2 database");
        //code.setId("abc");
        System.out.println("set id before saving: " + code.getId());
        Code newCode = entityManager.merge(code);
        code.setId(newCode.getId());
        System.out.println("set id after saving: " + code.getId());

    }

    @Override
    @Transactional
    public Code findById(String id) {
        System.out.println("finding in the H2 database");

        return entityManager.find(Code.class, id);
    }

    @Override
    @Transactional
    public void deleteById(String ID) {
        System.out.println("deleting by ID in the H2 database");
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from code where id=:codeId");
        query.setParameter("codeId", ID);
        query.executeUpdate();
    }
}
