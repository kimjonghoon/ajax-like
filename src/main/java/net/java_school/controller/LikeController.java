package net.java_school.controller;

import net.java_school.board.Like;
import net.java_school.board.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("like")
public class LikeController {
	@Autowired
	private LikeService service;

	@GetMapping("{no}")
	public Like getLike(@PathVariable(name="no") int no) {
		return service.getLike(no);
	}

	@PostMapping
	public void addLike(@RequestParam(name="articleNo") int articleNo) {
		Like like = new Like();
		like.setNo(articleNo);
		like.setUsername("John Doe");
		service.addLike(like);
	}

	@DeleteMapping("{no}")
	public void removeLike(@PathVariable(name="no") int no) {
		service.removeLike(no);
	} 
}