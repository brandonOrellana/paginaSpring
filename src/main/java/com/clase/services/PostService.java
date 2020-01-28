package com.clase.services;

import java.util.List;

import com.clase.model.Post;

public interface PostService {
	public List<Post> validation(List<Post> posts) throws NullPointerException;
}
