package com.bng.akul.project.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@GetMapping("/hello-world")
		public String show() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean hellobean() {
		return new HelloWorldBean("Hello World");
	}
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean hellopath(@PathVariable String name)
	{
		return new HelloWorldBean("Hello World "+name);
	}
}
