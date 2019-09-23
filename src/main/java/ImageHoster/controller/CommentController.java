package ImageHoster.controller;

import java.util.Date;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
@Controller
public class CommentController {
	 @Autowired
	    private CommentService commentsService;
	 
	 @Autowired
	    private ImageService imageService;
	 
	 @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
	    public String createComment(@PathVariable("imageId") Integer imageId, @PathVariable("imageTitle") String imageTitle, @RequestParam("comment") String text, HttpSession session,Image image ) {
	     System.out.println("inside commentsController");   
		 User user = (User) session.getAttribute("loggeduser");
		    
	        Comment comment = new Comment();
	        comment.setImage(imageService.getImage(imageId));
	        comment.setText(text);
	        comment.setUser(user);
	        comment.setDate(new Date());
	        commentsService.addComment(comment);
	        return "redirect:/images/" + imageId + "/" + imageTitle;
	    }
}
