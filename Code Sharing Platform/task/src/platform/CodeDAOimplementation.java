package platform;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

@Repository
public class CodeDAOimplementation implements CodeDAO{


    private EntityManager entityManager;

    @Autowired
    public CodeDAOimplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
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
    public void save(Code code) {
        System.out.println("saving in the H2 database");
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(code);
        return;

    }

    @Override
    public Code findById(String id) {
        System.out.println("finding in the H2 database");
        Session session = entityManager.unwrap(Session.class);
        Code code = session.get(Code.class, id);
        return code;
    }

    @Override
    public void deleteById(String ID) {
        System.out.println("deleting by ID in the H2 database");
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from code where id=:codeId");
        query.setParameter("codeId", ID);
        query.executeUpdate();
    }
}
