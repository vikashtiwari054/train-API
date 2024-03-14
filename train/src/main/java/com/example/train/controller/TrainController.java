package com.example.train.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.train.dto.TrainFindRequest;
import com.example.train.dto.TrainUpdateRequest;
import com.example.train.entity.Train;
import com.example.train.service.TrainService;

@RestController
@RequestMapping("/api")
public class TrainController {

	@Autowired
	private TrainService trainService;

	@GetMapping("/dummy/{id}")
	public ResponseEntity<Train> getByPathVariable(@PathVariable("id") int ids) {

	   Train train = trainService.getByPathVariableDummy(ids);

		return new ResponseEntity<Train>(train, HttpStatus.OK);
	}

	@GetMapping("/dummy/")
	public ResponseEntity<Train> getByRequestParam(@RequestParam("id") int ids) {

		Train train = trainService.getByRequestParamDummy(ids);

		return new ResponseEntity<Train>(train, HttpStatus.OK);

	}
	
	

	@PostMapping("/add")
	public ResponseEntity<Train> addTrains(@RequestBody Train t) {

		Train train = trainService.addTrain(t);

		return new ResponseEntity<Train>(train, HttpStatus.OK);
	}

	@PostMapping("/remove")
	public ResponseEntity<String> removeTrainByNumber(@RequestBody Map<String, String> request) {

		String trainNumber = request.get("number");

		trainService.removeTrain(trainNumber);
		return ResponseEntity.ok("train with number : " + trainNumber + " is  removed successfully");

	}

	@PostMapping("/update/{number}")
	public ResponseEntity<String> updateTrain(@PathVariable("number") String numbers,
			@RequestBody TrainUpdateRequest updateRequest) {

		if (trainService.updateTrain(numbers, updateRequest)) {
			return ResponseEntity.ok("Train updated successfully");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Train not found");
		}
	}

	@GetMapping("/trains")
	public List<String> getTrainsBetween(@RequestBody Map<String, String> request) {
		String source = request.get("source");
		String destination = request.get("destination");

		return trainService.findTrainsBetween(source, destination);
	}
}
