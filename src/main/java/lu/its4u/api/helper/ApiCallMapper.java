package lu.its4u.api.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lu.its4u.api.domain.ApiCall;
import lu.its4u.api.entity.ApiCallEntity;

@Component
public class ApiCallMapper {

	public ApiCall toApiCall(ApiCallEntity input) {
		if (input == null) {
			return null;
		}
		return new ApiCall(input.getId(), input.getCallDate(), input.getSource(), input.getTarget());
	}

	public List<ApiCall> toApiCalls(List<ApiCallEntity> input) {
		if (input == null) {
			return null;
		}
		List<ApiCall> output = new ArrayList<ApiCall>();
		for (ApiCallEntity entity : input) {
			output.add(this.toApiCall(entity));
		}
		return output;
	}

	public ApiCallEntity toApiCallEntity(ApiCall input) {
		if (input == null) {
			return null;
		}
		return new ApiCallEntity(input.getId(), input.getCallDate(), input.getSource(), input.getTarget());
	}

	public List<ApiCallEntity> toApiCallEntities(List<ApiCall> input) {
		if (input == null) {
			return null;
		}
		List<ApiCallEntity> output = new ArrayList<ApiCallEntity>();
		for (ApiCall entity : input) {
			output.add(this.toApiCallEntity(entity));
		}
		return output;
	}
}
