package tp.kits3.livedinner;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tp.kits3.livedinner.service.BookService;
import tp.kits3.livedinner.service.ModelService;

/**
 * Handles requests for the application home page.
 * @Controller mean this class is servlet 
 * don't need to extend httpServlet
 */
@Controller
public class HomeController {
	//injection : create other objects in this class
	@Autowired // auto create ModelService
	private ModelService modelService;
	private BookService bookservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("{}.", "HomeController:home"); // values in {}  in value of locale
	//	modelService = new ModelService() don't need to write this , spring will do it  (Dependencies injection)
		modelService.getModelData();
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String doPost(Locale locale, Model model) {
		logger.info("{}.", "HomeController:home"); // values in {}  in value of locale
		return "home";
	}
	
}
