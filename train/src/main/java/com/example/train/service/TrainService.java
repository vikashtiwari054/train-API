package com.example.train.service;

import java.util.List;
import java.util.Optional;

import com.example.train.dto.TrainUpdateRequest;
import com.example.train.entity.Train;

public interface TrainService {

	// add train

	Train addTrain(Train t);

	// remove train

	void removeTrain(String number);

	// update train

	boolean updateTrain(String number, TrainUpdateRequest trainUpdateRequest);

	// find trains

	List<String> findTrainsBetween(String source, String destination);

	Train getByPathVariableDummy(int id);

	Train getByRequestParamDummy(int id);

}
