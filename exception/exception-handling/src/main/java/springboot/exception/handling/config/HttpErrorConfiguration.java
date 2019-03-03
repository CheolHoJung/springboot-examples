package springboot.exception.handling.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class HttpErrorConfiguration extends ServerProperties {
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container)
	{
		super.customize(container);
		container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
		container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
		container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
	}
}