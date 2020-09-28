package com.hive;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biz.CarStatus;
import com.biz.Click;
import com.frame.Car;

@Controller
public class CarController {

	@Autowired
	Car<CarStatus> car;
	 
	@RequestMapping("/carstatus.mc")
	public void carstatus(CarStatus cstatus) {
		System.out.println(cstatus);
		car.status(cstatus);
	}
}









