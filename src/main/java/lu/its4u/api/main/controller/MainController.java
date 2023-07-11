package lu.its4u.api.main.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lu.its4u.api.basic.domain.DateResponse;
import lu.its4u.api.basic.domain.DateTimeResponse;
import lu.its4u.api.basic.domain.IPResponse;
import lu.its4u.api.basic.domain.RandomFloatResponse;
import lu.its4u.api.basic.domain.RandomIntegerResponse;
import lu.its4u.api.basic.domain.RandomStringResponse;
import lu.its4u.api.basic.domain.TimeResponse;

@RestController
public class MainController {

	@GetMapping(value = { "/" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IPResponse> main(final HttpServletRequest request) {
		return ip(request);
	}

	@GetMapping(value = { "/**" })
	public ResponseEntity<String> catchAll(final HttpServletRequest request) {
		return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = { "/headers" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> headers(final HttpServletRequest request, @RequestHeader Map<String, String> headers) {

		return new ResponseEntity<>(headers, HttpStatus.OK);
	}

	@GetMapping(value = { "/ip" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IPResponse> ip(final HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getHeader("x-original-forwarded-for");
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
		}
		return new ResponseEntity<>(new IPResponse(ipAddress), HttpStatus.OK);
	}

	@GetMapping(value = { "/date" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DateResponse> date(final HttpServletRequest request) {

		return new ResponseEntity<>(new DateResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/time" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeResponse> time(final HttpServletRequest request) {

		return new ResponseEntity<>(new TimeResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/datetime" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DateTimeResponse> datetime(final HttpServletRequest request) {

		return new ResponseEntity<>(new DateTimeResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randomstring" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomStringResponse> randomstring(final HttpServletRequest request, @RequestParam(defaultValue = "10", name = "chars", required = false) Integer chars) {
		if (chars > 0) {
			return new ResponseEntity<>(new RandomStringResponse(chars), HttpStatus.OK);

		}

		return new ResponseEntity<>(new RandomStringResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randominteger" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomIntegerResponse> randominteger(final HttpServletRequest request) {

		return new ResponseEntity<>(new RandomIntegerResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randomfloat" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomFloatResponse> randomfloat(final HttpServletRequest request) {

		return new ResponseEntity<>(new RandomFloatResponse(), HttpStatus.OK);
	}

}
