package org.sofka.mykrello.controller;

import org.sofka.mykrello.model.service.LogService;
import org.sofka.mykrello.utilities.MyResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
public class LogController {

	@Autowired
	private MyResponseUtility response;

	@Autowired
	private LogService logService;


	/**
		* Este metodo me trae todos los logs de una tarea
	 * @param
	 * @return
	 */
	@GetMapping(path = "/api/v1/logs")
	public ResponseEntity<MyResponseUtility> index() { //El {index} se utilisa para obtener todos los logs
		response.data = logService.findAll();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	@GetMapping(path = "/api/v1/logs/{id}")
	public ResponseEntity<MyResponseUtility> getLog(@PathVariable(name = "id") Integer id) {
		response.data = logService.findById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
