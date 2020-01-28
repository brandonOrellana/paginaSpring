package com.clase.controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clase.beans.PostComponent;
import com.clase.configuration.Paginas;
import com.clase.model.Post;


@Controller
@RequestMapping("/home")
public class ControllerBasic {
	@Autowired
	private PostComponent _postComponent;

	@GetMapping(path = {"/posts","/"})
	public String saludar(Model model ){
		model.addAttribute("posts",this._postComponent.getPosts());
		return "index";
	}
	/*
	@GetMapping(path= {"/public"})
	public ModelAndView post() {
		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
		modelAndView.addObject("posts",this.getPosts());
		return modelAndView;
	}
	*/
	@GetMapping(path={"/post","post/p/{post}"})
	public ModelAndView getPostIndividual(
			@RequestParam(defaultValue = "1", name="id", required = false) 
			//@PathVariable(required = true, name = "post")
			int id
			){
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);
		List<Post> postFiltrado=
				this._postComponent.getPosts()
				.stream()
				.filter((p)->{
					return p.getId() == id;
				})
				.collect(Collectors.toList());
		
		modelAndView.addObject("post",postFiltrado.get(0));
		
		return modelAndView;
	}
	
	@GetMapping(path={"/postNew"})
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post",new Post());
	}
	
	@PostMapping(path={"/addNewPost"})
	public String addNewPost(Post post, Model model) {
		List<Post> posts = this._postComponent.getPosts();
		posts.add(post);
		model.addAttribute("posts",posts);
		return "index";
	}
	
	
}
