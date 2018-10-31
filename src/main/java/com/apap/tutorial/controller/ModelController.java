package com.apap.tutorial.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.apap.tutorial.model.*;
import com.apap.tutorial.rest.*;
import com.apap.tutorial.service.*;
import com.apap.tutorial.rest.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/model")
public class ModelController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping()
	private Object modelCar(@RequestParam("factory") String factory) throws Exception{
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Mobile Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		String path = Setting.modelUrl + "/?cmd=getModels&make=" + factory + "&year=2018";
		Object response = restTemplate.exchange(path, HttpMethod.GET, entity, Object.class);
		return response;
	}

}
