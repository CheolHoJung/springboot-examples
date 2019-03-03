package springboot.exception.handling.mvc;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import springboot.exception.handling.domain.ExceptionDto;
import springboot.exception.handling.domain.ExceptionType;

@ControllerAdvice("springboot.exception.handling")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHighstControllerAdvice {
	
	Logger logger = LoggerFactory.getLogger(ExceptionHighstControllerAdvice.class);
	
	@ExceptionHandler(SQLException.class)
	public String sqlException(HttpServletRequest request, Exception e) {
		ExceptionDto exception = new ExceptionDto("SQLException occurred", e.getCause().getMessage(), ExceptionType.SQL);
		request.setAttribute("msg", exception.toString());
		logger.info(exception.toString());
		
		return "forward:/handling";
	}
}
