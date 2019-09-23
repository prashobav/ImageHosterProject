package ImageHoster.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;

public class CommentController {
	 @Autowired
	    private CommentService commentsService;
	 
	 @Autowired
	    private ImageService imageService;
	 
	 @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
	    public String createImage(@RequestParam("comments") String text,@PathVariable("imageId") Integer id,@PathVariable("imageTitle") String title, HttpSession session) throws IOException {
		 System.out.println("Inside comments");
		Image image = new Image();
		Integer imageId = image.getId();
		String imageTitle=image.getTitle();
		
		 Comment comment = new Comment();
		 comment.setText(text);
		 comment.setDate(new Date());
		 commentsService.addComment(comment);
	        return "redirect:/images/image";
	    }
}
