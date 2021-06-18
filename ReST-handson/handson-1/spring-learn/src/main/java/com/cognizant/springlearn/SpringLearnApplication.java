package com.cognizant.springlearn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void displayDate() {

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat dateFormat = context.getBean("dateFormat", SimpleDateFormat.class);

		try {
			Date date = dateFormat.parse("31/12/2018");
			logger.debug("{}", date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		logger.debug("country:{},another country:{}", country.hashCode(),anotherCountry.hashCode());
		ArrayList<Country> countries=context.getBean("countryList",ArrayList.class);
		logger.debug("countries:{}",countries);
	}
	
	public static void main(String[] args) {

		logger.info("start main");
		
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate();
		displayCountry();

		logger.info("end");

	}

}
