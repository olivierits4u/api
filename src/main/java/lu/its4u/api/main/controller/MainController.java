package lu.its4u.api.main.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lu.its4u.api.basic.domain.DateResponse;
import lu.its4u.api.basic.domain.DateTimeResponse;
import lu.its4u.api.basic.domain.HealthResponse;
import lu.its4u.api.basic.domain.HtmlColorResponse;
import lu.its4u.api.basic.domain.IPResponse;
import lu.its4u.api.basic.domain.RandomFloatResponse;
import lu.its4u.api.basic.domain.RandomIntegerResponse;
import lu.its4u.api.basic.domain.RandomStringResponse;
import lu.its4u.api.basic.domain.TimeResponse;
import lu.its4u.api.entity.ApiCallEntity;
import lu.its4u.api.helper.Helper;
import lu.its4u.api.repository.ApiCallRepository;

@RestController
public class MainController {
	@Autowired
	private ApiCallRepository repository;
	Logger logger = LoggerFactory.getLogger(MainController.class);

	void saveLogging(String source, String target) {
		this.repository.save(new ApiCallEntity(null, new Date(), source, target));
	}

	@GetMapping(value = { "/" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IPResponse> main(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:main");
		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::main");
		return ip(request);
	}

	@GetMapping(value = { "/**" })
	public ResponseEntity<String> catchAll(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:catchAll");

		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::catchAll");

		return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = { "/headers" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> headers(final HttpServletRequest request,
			@RequestHeader Map<String, String> headers) {
		logger.info("________________________________________________________");
		logger.info("call:headers");

		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::headers");

		return new ResponseEntity<>(headers, HttpStatus.OK);
	}

	@GetMapping(value = { "/ip" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IPResponse> ip(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:ip");

		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::ip");

		return new ResponseEntity<>(new IPResponse(getIP(request)), HttpStatus.OK);
	}

	@GetMapping(value = { "/date" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DateResponse> date(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:date");

		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::date");

		return new ResponseEntity<>(new DateResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/time" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeResponse> time(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:time");

		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::time");

		return new ResponseEntity<>(new TimeResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/datetime" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DateTimeResponse> datetime(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:datetime");

		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::datetime");

		return new ResponseEntity<>(new DateTimeResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randomstring" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomStringResponse> randomstring(final HttpServletRequest request,
			@RequestParam(defaultValue = "10", name = "chars", required = false) Integer chars) {
		logger.info("________________________________________________________");
		logger.info("call:randomstring");

		logger.info("________________________________________________________");

		if (chars > 0) {
			return new ResponseEntity<>(new RandomStringResponse(chars), HttpStatus.OK);

		}
		saveLogging(getIP(request), "MainController::randomstring");

		return new ResponseEntity<>(new RandomStringResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randominteger" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomIntegerResponse> randominteger(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:randominteger");
		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::randominteger");

		return new ResponseEntity<>(new RandomIntegerResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randomfloat" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomFloatResponse> randomfloat(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:randomfloat");
		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::randomfloat");

		return new ResponseEntity<>(new RandomFloatResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/healthz" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HealthResponse> healthz(final HttpServletRequest request,
			@RequestHeader Map<String, String> headers) {
		logger.info("________________________________________________________");
		logger.info("call:healthz");
		logger.info("________________________________________________________");
		saveLogging(getIP(request), "MainController::healthz");

		return new ResponseEntity<>(new HealthResponse(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randomhtmlcolor" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HtmlColorResponse> randomhtmlcolor(final HttpServletRequest request,
			@RequestHeader Map<String, String> headers) {
		logger.info("________________________________________________________");
		logger.info("call:randomhtmlcolor");
		logger.info("________________________________________________________");

		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			sb.append(Helper.hexDigits[random.nextInt(Helper.hexDigits.length)]);
		}
		saveLogging(getIP(request), "MainController::randomhtmlcolor");

		return new ResponseEntity<>(new HtmlColorResponse(sb.toString()), HttpStatus.OK);

	}

	@GetMapping(value = { "/calls" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ApiCallEntity>> calls(final HttpServletRequest request,
			@RequestHeader Map<String, String> headers) {
		logger.info("________________________________________________________");
		logger.info("call:calls");
		logger.info("________________________________________________________");

		saveLogging(getIP(request), "MainController::calls");

		return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);

	}

	private String getIP(final HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getHeader("x-original-forwarded-for");
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
		}
		return ipAddress;
	}
}
