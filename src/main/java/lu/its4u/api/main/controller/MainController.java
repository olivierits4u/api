package lu.its4u.api.main.controller;

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

import lu.its4u.api.domain.ApiCall;
import lu.its4u.api.domain.Date;
import lu.its4u.api.domain.DateTime;
import lu.its4u.api.domain.Health;
import lu.its4u.api.domain.HtmlColor;
import lu.its4u.api.domain.IP;
import lu.its4u.api.domain.Purged;
import lu.its4u.api.domain.RandomFloat;
import lu.its4u.api.domain.RandomInteger;
import lu.its4u.api.domain.RandomString;
import lu.its4u.api.domain.Time;
import lu.its4u.api.helper.Helper;
import lu.its4u.api.service.MainService;

@RestController
public class MainController {
	Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private MainService service;

	@GetMapping(value = { "/" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IP> main(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:main");
		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::main");
		return ip(request);
	}

	@GetMapping(value = { "/**" })
	public ResponseEntity<String> catchAll(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:catchAll");

		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::catchAll");

		return new ResponseEntity<>("error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = { "/headers" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> headers(final HttpServletRequest request, @RequestHeader Map<String, String> headers) {
		logger.info("________________________________________________________");
		logger.info("call:headers");

		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::headers");

		return new ResponseEntity<>(headers, HttpStatus.OK);
	}

	@GetMapping(value = { "/ip" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IP> ip(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:ip");

		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::ip");

		return new ResponseEntity<>(new IP(getIP(request)), HttpStatus.OK);
	}

	@GetMapping(value = { "/date" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Date> date(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:date");

		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::date");

		return new ResponseEntity<>(new Date(), HttpStatus.OK);
	}

	@GetMapping(value = { "/time" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Time> time(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:time");

		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::time");

		return new ResponseEntity<>(new Time(), HttpStatus.OK);
	}

	@GetMapping(value = { "/datetime" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DateTime> datetime(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:datetime");

		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::datetime");

		return new ResponseEntity<>(new DateTime(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randomstring" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomString> randomstring(final HttpServletRequest request, @RequestParam(defaultValue = "10", name = "chars", required = false) Integer chars) {
		logger.info("________________________________________________________");
		logger.info("call:randomstring");

		logger.info("________________________________________________________");

		if (chars > 0) {
			return new ResponseEntity<>(new RandomString(chars), HttpStatus.OK);

		}
		service.saveLogging(getIP(request), "MainController::randomstring");

		return new ResponseEntity<>(new RandomString(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randominteger" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomInteger> randominteger(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:randominteger");
		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::randominteger");

		return new ResponseEntity<>(new RandomInteger(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randomfloat" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RandomFloat> randomfloat(final HttpServletRequest request) {
		logger.info("________________________________________________________");
		logger.info("call:randomfloat");
		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::randomfloat");

		return new ResponseEntity<>(new RandomFloat(), HttpStatus.OK);
	}

	@GetMapping(value = { "/healthz" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Health> healthz(final HttpServletRequest request, @RequestHeader Map<String, String> headers) {
		logger.info("________________________________________________________");
		logger.info("call:healthz");
		logger.info("________________________________________________________");
		service.saveLogging(getIP(request), "MainController::healthz");

		return new ResponseEntity<>(new Health(), HttpStatus.OK);
	}

	@GetMapping(value = { "/randomhtmlcolor" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HtmlColor> randomhtmlcolor(final HttpServletRequest request, @RequestHeader Map<String, String> headers) {
		logger.info("________________________________________________________");
		logger.info("call:randomhtmlcolor");
		logger.info("________________________________________________________");

		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			sb.append(Helper.hexDigits[random.nextInt(Helper.hexDigits.length)]);
		}
		service.saveLogging(getIP(request), "MainController::randomhtmlcolor");

		return new ResponseEntity<>(new HtmlColor(sb.toString()), HttpStatus.OK);

	}

	@GetMapping(value = { "/calls" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ApiCall>> calls(final HttpServletRequest request, @RequestHeader Map<String, String> headers) {
		logger.info("________________________________________________________");
		logger.info("call:calls");
		logger.info("________________________________________________________");

		service.saveLogging(getIP(request), "MainController::calls");

		return new ResponseEntity<>(this.service.getAllCalls(), HttpStatus.OK);

	}

	@GetMapping(value = { "/purge" }, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Purged> purge(final HttpServletRequest request) {

		service.saveLogging(getIP(request), "MainController::purge");

		return new ResponseEntity<>(this.service.purge(), HttpStatus.OK);

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
