package com.clase.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.clase.model.Post;
import com.clase.services.PostService;

@Service("serviceDecorado")
@Scope("singleton")
public class PostServiceDecoredImpl implements PostService{
	private final Log log = LogFactory.getLog(getClass());
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	@Autowired
	private PostServiceImplDos postServiceImplDos;
	
	@Override
	public List<Post> validation(List<Post> posts) {
		log.debug(posts);
		posts = postServiceImpl.validation(posts);
		posts = postServiceImplDos.validation(posts);
		for(Post post : posts) {
			if(post.getDescripcion()==null) 
				throw new NullPointerException("La descripcion es nulo");
			if(post.getFecha()==null) 
				throw new NullPointerException("La fecha es nulo");
		}
		return posts;
	}
}
