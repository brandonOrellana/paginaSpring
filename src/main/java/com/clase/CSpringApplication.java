package com.clase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.clase.beans.PostComponent;
import com.clase.model.Conexion;
import com.clase.services.PostService;


@SpringBootApplication
//@ComponentScan(basePackages= {"com.clase"})
public class CSpringApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;
	
	@Autowired
	@Qualifier("com.clase.beans.PostComponent")
	private PostComponent postComponent;
	
	
	
	//Primer metodo
	/*@Autowired
	@Qualifier("serviceDecorado")*/
	public PostService postService;
	
	//Segundo Metodo atraves del set
	//Falta hacer la clase de agregado del set
	/*
	public PostService getPostService() {
		return postService;
	}
	@Autowired
	@Qualifier("serviceDecorado")
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	*/
	//Tercer metodo atraves del constructor
	@Autowired
	public CSpringApplication(@Qualifier("serviceDecorado") PostService postService) {
		this.postService=postService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CSpringApplication.class, args);
	}

	
	


	@Override
	public void run(String... args) throws Exception {
		Log log = LogFactory.getLog(getClass());
		
		
		/*System.out.println(conexion.getDb());
		postComponent.getPosts().forEach(p->{
			System.out.println(p.getDescripcion());
		});*/
		try {
			postService.validation(postComponent.getPosts())
			.forEach(post->{
				log.info(post.getTitulo());
			});
		} catch (Exception e) {
			log.error(e);
		}
		
	}

}
