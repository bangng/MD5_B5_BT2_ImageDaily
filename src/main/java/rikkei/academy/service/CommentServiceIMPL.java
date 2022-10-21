package rikkei.academy.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rikkei.academy.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Component
@Transactional
@Service
public class CommentServiceIMPL implements ICommentService {
    @Autowired
    private ICommentService commentService;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("SELECT C FROM Comment C", Comment.class);

        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() == null) {
            em.persist(comment);

        } else {
            em.merge(comment);
        }

    }

    @Override
    public Comment findById(int id) {
        TypedQuery<Comment> query = em.createQuery("SELECT C FROM Comment C WHERE C.id = :id", Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


}
