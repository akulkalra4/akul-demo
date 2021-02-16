package com.bng.akul.project.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
		
	@Autowired
	private UserRepository repo;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtTokenUtil;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@GetMapping("/")
	public String gettext() {
		return "HELLO";
	}
	@GetMapping("/admin")
	public String getadmin() {
		return "HELLO ADMIN";
	}
	
	@GetMapping("/jpa/users")
	public List<User> retreiveAllUsers()
	{
		return repo.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id)
	{
		Optional<User> user = repo.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
//		Resource<User> resource = new Resource<User>(user.get());
		return user;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> setUser(@RequestBody User user)
	{
		User entry = repo.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(entry.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void removeUser(@PathVariable int id)
	{
		repo.deleteById(id);
	}
	
	
	@PostMapping("/auth")
	public ResponseEntity<?> createAuthToken(@RequestBody authRequest arequest) throws Exception {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(arequest.getUsername(),arequest.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(arequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponse(jwt));
				
	}
	
}
