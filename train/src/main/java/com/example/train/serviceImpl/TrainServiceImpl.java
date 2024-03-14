package com.example.train.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.train.dto.TrainUpdateRequest;
import com.example.train.entity.Train;
import com.example.train.repo.TrainRepository;
import com.example.train.service.TrainService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainRepository trainRepository;
	private ObjectMapper objectMapper;

	@Override
	public Train addTrain(Train train) {

		return trainRepository.save(train);
	}

	@Override
	public void removeTrain(String number) {

		trainRepository.removeTrain(number);
	}

	@Override
	public boolean updateTrain(String number, TrainUpdateRequest updateRequest) {
		if (trainRepository.existsByNumber(number)) {
			Train train = trainRepository.findByNumber(number);
			// Update train details based on updateRequest
			train.setName(updateRequest.getName());
			train.setStations(updateRequest.getStations());
			trainRepository.save(train);
			return true;
		}
		return false;
	}

	public List<String> findTrainsBetween(String source, String destination) {

		return trainRepository.findBySourceAndDestination(source, destination);

	}

	@Override
	public Train getByPathVariableDummy(int id) {

		Optional<Train> t=trainRepository.findById(id);
		
		return t.get();
	}

	@Override
	public Train getByRequestParamDummy(int id) {

		Optional<Train> t= trainRepository.findById(id);

		return t.get();
	}
}
