package com.clase.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.clase.model.Post;
import com.clase.services.PostService;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {
	private final Log log = LogFactory.getLog(getClass());
	
	@Override
	public List<Post> validation(List<Post> posts) throws NullPointerException {
		log.info("servicio dos");
			for(Post post : posts) {
				if(post.getId()==0) {
					throw new NullPointerException("El id es nulo");
				}
			}
		return posts;
	}

}
