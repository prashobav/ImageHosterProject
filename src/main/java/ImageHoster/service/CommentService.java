package ImageHoster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentsRepository;
@Service
public class CommentService {
	 @Autowired
	  private  CommentsRepository commentsRepository;
	 
	 public void addComment(Comment comment) {
	    	System.out.println("inside comments service : add comment");
	    	commentsRepository.addComment(comment);
	    }
}
