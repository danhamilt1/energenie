package com.energenie.energenie;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;
import com.pi4j.io.gpio.impl.PinImpl;



@Component("energenieController")
public class EnergenieController {
	private final GpioController gpio = GpioFactory.getInstance();
	private GpioPinDigitalOutput pin11 = null;
	private GpioPinDigitalOutput pin15 = null;
	private GpioPinDigitalOutput pin16 = null;
	private GpioPinDigitalOutput pin13 = null;
	
	private GpioPinDigitalOutput pin18 = null;
	private GpioPinDigitalOutput pin22 = null;
	
	@PostConstruct
	private void init(){
		// Initialise controller pins
		pin11 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
		pin15 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
		pin16 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
		pin13 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
		
		// Set all pins off
		pin11.low();
		pin15.low();
		pin16.low();
		pin13.low();
		
		pin18 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
		pin22 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
		
		pin18.low();
		pin22.low();
		
	}
	
	public void allOn(){
		pin11.high();
		pin15.high();
		pin16.low();
		pin13.high();
	}
	
	public void allOff(){
		pin11.high();
		pin15.high();
		pin16.low();
		pin13.low();
	}
	
	public void l1On(){
		pin11.high();
		pin15.high();
		pin16.high();
		pin13.high();
		send();
	}
	
	public void l1Off(){
		pin11.high();
		pin15.high();
		pin16.high();
		pin13.low();
		send();
	}
	
	public void l2On(){
		pin11.low();
		pin15.high();
		pin16.high();
		pin13.high();
		send();
	}
	public void l2Off(){
		pin11.low();
		pin15.high();
		pin16.high();
		pin13.low();
		send();
	}
	public void l3On(){
		pin11.high();
		pin15.low();
		pin16.high();
		pin13.high();
		send();
	}
	public void l3Off(){
		pin11.high();
		pin15.low();
		pin16.high();
		pin13.low();
		send();
	}	
	public void l4On(){
		pin11.low();
		pin15.low();
		pin16.high();
		pin13.high();
		send();
	}
	public void l4Off(){
		pin11.low();
		pin15.high();
		pin16.low();
		pin13.low();
		send();
	}
	
	public void send(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pin22.high();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pin22.low();
	}
	
}
