package springboot.exception.handling.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import springboot.exception.handling.domain.ExceptionDto;
import springboot.exception.handling.domain.ExceptionType;

@ControllerAdvice("springboot.exception.handling")
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionLowestControllerAdvice {
	
	Logger logger = LoggerFactory.getLogger(ExceptionLowestControllerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public String handleAnyException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		ExceptionDto exception = new ExceptionDto("Exception on server occurred", e.toString(), ExceptionType.SERVER);
		request.setAttribute("msg", exception.toString());
		logger.info(exception.toString());
		
		return "forward:/handling";
	}
}
