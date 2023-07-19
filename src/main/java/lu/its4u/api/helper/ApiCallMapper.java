package lu.its4u.api.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lu.its4u.api.basic.domain.ApiCallResponse;
import lu.its4u.api.entity.ApiCallEntity;

@Component
public class ApiCallMapper {

	public ApiCallResponse toApiCallResponse(ApiCallEntity input) {
		if (input == null) {
			return null;
		}
		return new ApiCallResponse(input.getId(), input.getCallDate(), input.getSource(), input.getTarget());
	}

	public List<ApiCallResponse> toApiCallResponses(List<ApiCallEntity> input) {
		if (input == null) {
			return null;
		}
		List<ApiCallResponse> output = new ArrayList<ApiCallResponse>();
		for (ApiCallEntity entity : input) {
			output.add(this.toApiCallResponse(entity));
		}
		return output;
	}

	public ApiCallEntity toApiCallEntity(ApiCallResponse input) {
		if (input == null) {
			return null;
		}
		return new ApiCallEntity(input.getId(), input.getCallDate(), input.getSource(), input.getTarget());
	}

	public List<ApiCallEntity> toApiCallEntities(List<ApiCallResponse> input) {
		if (input == null) {
			return null;
		}
		List<ApiCallEntity> output = new ArrayList<ApiCallEntity>();
		for (ApiCallResponse entity : input) {
			output.add(this.toApiCallEntity(entity));
		}
		return output;
	}
}
