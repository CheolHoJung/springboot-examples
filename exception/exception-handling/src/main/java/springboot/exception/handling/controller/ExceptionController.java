package springboot.exception.handling.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ExceptionController {

	@RequestMapping("/")
	public String exceptionTest() {
		return "/exceptionTest";
	}
	
	@RequestMapping("/403")
	public String forBiddenPage() {
		return "/403";
	}
	
	@RequestMapping("/404")
	public String notFoundPage() {
		return "/404";
	}
	
	@RequestMapping("/405")
	public String internalServerErrorPage() {
		return "/405";
	}

	@RequestMapping(value = "/handling")
	public ModelAndView sampleTest(HttpServletRequest request) {
		String msg = (String) request.getAttribute("msg");
		ModelAndView mv = new ModelAndView("/500");
		mv.addObject("msg", msg);
		return mv;
	}

	@RequestMapping(value = "/handling", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public ResponseEntity<String> handleCustomException(HttpServletRequest request) {
		String msg =  (String) request.getAttribute("msg");
		return new ResponseEntity<String>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/exceptionOnHtmlRequst")
	public String exceptionOnHtmlRequst() throws NullPointerException {
		throw new NullPointerException();
	}
	
	@GetMapping("/sqlExceptionOnHtmlRequest")
	public String sqlExceptionOnHtmlRequest() throws SQLException {
		throw new SQLException("SQLExceptin", new SQLException("SQL_101"));
	}
	
	@GetMapping("/exceptionOnJsonRequest")
	@ResponseBody
	public List<Map<String, Object>> exceptionOnJsonRequest() throws Exception{
		throw new Exception();
	}
	
	@GetMapping("/sqlExceptionOnJsonRequest")
	@ResponseBody
	public List<Map<String, Object>> sqlExceptionOnJsonRequest() throws SQLException {
		throw new SQLException("SQLExceptin", new SQLException("SQL_101"));
	}
}
