package com.clase.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.clase.model.Post;
import com.clase.services.PostService;

@Service("serviceUno")
public class PostServiceImpl implements PostService {
	private final Log log = LogFactory.getLog(getClass());
	@Override
	public List<Post> validation(List<Post> posts) throws NullPointerException {
		log.info("servicio uno");
			for(Post post : posts) {
				if(post.getTitulo()==null) {
					throw new NullPointerException("El titulo es nulo");
				}   
			}
		return posts;
	}

}
