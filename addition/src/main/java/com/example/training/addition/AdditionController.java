package com.example.training.addition;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdditionController {
	@RequestMapping(path = "/addition", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Addition> processAddition(@RequestBody Addition requestJSON) {
		//Building Response JSON
		Addition responseJSON = new Addition();
		responseJSON.setA(requestJSON.getA());
		responseJSON.setB(requestJSON.getB());
		responseJSON.process(); //Update the result
		
		//Returning Response JSON + HTTP Status code 200 i.e. OK
		ResponseEntity response = new ResponseEntity(responseJSON, HttpStatus.OK);
		return response;
	}
}
