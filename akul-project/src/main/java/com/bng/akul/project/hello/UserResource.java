package com.bng.akul.project.hello;
//package com.bng.akul.project.user;
//
//import java.net.URI;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//@RestController
//public class UserResource {
//	
//	@Autowired
//	
//	
//	
//	private UserdaoService service;
//	@GetMapping("/users")
//	public List<User> retreiveAllUsers()
//	{
//		return service.findAll();
//	}
//	
//	@GetMapping("/users/{id}")
//	public User retrieveUser(@PathVariable int id)
//	{
//		User user = service.findOne(id);
//		if(user==null)
//			throw new UserNotFoundException("id-"+id);
//		return user;
//	}
//	@PostMapping("/users")
//	public ResponseEntity<Object> setUser(@RequestBody User user)
//	{
//		User entry = service.add(user);
//		URI location = ServletUriComponentsBuilder
//				.fromCurrentRequest().path("/{id}").buildAndExpand(entry.getId()).toUri();
//		return ResponseEntity.created(location).build();
//	}
//	@DeleteMapping("/users/{id}")
//	public User removeUser(@PathVariable int id)
//	{
//		User user = service.deleteUser(id);
//		if(user==null)
//			throw new UserNotFoundException("id-"+id);
//		return user;
//	}
//	
//}
//
//
