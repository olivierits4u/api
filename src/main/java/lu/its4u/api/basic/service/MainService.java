package lu.its4u.api.basic.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lu.its4u.api.basic.domain.ApiCallResponse;
import lu.its4u.api.entity.ApiCallEntity;
import lu.its4u.api.helper.ApiCallMapper;
import lu.its4u.api.repository.ApiCallRepository;

@Component
public class MainService {
	@Autowired
	private ApiCallRepository repository;
	@Autowired
	private ApiCallMapper mapper;

	public void saveLogging(String source, String target) {
		this.repository.save(new ApiCallEntity(null, new Date(), source, target));
	}

	public List<ApiCallResponse> getAllCalls() {
		return this.mapper.toApiCallResponses(this.repository.findAll());
	}

	public int purge() {
		long delta = 1 * 1000 * 60 * 60 * 24;
		List<ApiCallEntity> list = this.repository.findByCallDateBefore(new Date(System.currentTimeMillis() - delta));
		this.repository.deleteAll(list);
		return list.size();
	}

}
