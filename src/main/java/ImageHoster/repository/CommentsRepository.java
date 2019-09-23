package ImageHoster.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import ImageHoster.model.Comment;
@Repository
public class CommentsRepository {
	 @PersistenceUnit(unitName = "imageHoster")
	    private EntityManagerFactory emf;
	public Comment addComment(Comment comment) {
		System.out.println("inside comments repository : add comment");
		        EntityManager em = emf.createEntityManager();
		        EntityTransaction transaction = em.getTransaction();

		        try {
		            transaction.begin();
		            em.persist(comment);
		            transaction.commit();
		        } catch (Exception e) {
		            transaction.rollback();
		        }
		        return comment;
		    }
}
