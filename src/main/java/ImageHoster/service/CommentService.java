package ImageHoster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentsRepository;
@Service
public class CommentService {
	 @Autowired
	  private  CommentsRepository commentsRepository;
	 
	 public Comment addComment(Comment comment) {
	    	System.out.println("inside comments service : add comment");
	    	return commentsRepository.addComment(comment);
	    }
	 
	//Call the getAllImages() method in the Repository and obtain a List of all the images in the database
	    public List<Comment> getAllComments() {
	        return commentsRepository.getAllComments();
	    }
}
