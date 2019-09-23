package ImageHoster.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
@Repository
public class CommentsRepository {
	 @PersistenceUnit(unitName = "imageHoster")
	    private EntityManagerFactory emf;
	public Comment addComment(Comment newComment) {
		System.out.println("inside comments repository : add comment");
		        EntityManager em = emf.createEntityManager();
		        EntityTransaction transaction = em.getTransaction();

		        try {
		            transaction.begin();
		            em.persist(newComment);
		            transaction.commit();
		        } catch (Exception e) {
		            transaction.rollback();
		        }
		        return newComment;
		    }
	
	   //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the comments from the database
    //Returns the list of all the comments fetched from the database
    public List<Comment> getAllComments() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i", Comment.class);
        List<Comment> resultList = query.getResultList();

        return resultList;
    }
}
