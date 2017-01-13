package com.energenie.energenie;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

@Component("energenieController")
public class EnergenieController {
	private final GpioController gpio = GpioFactory.getInstance();
	private GpioPinDigitalOutput pin00 = null;
	private GpioPinDigitalOutput pin03 = null;
	private GpioPinDigitalOutput pin04 = null;
	private GpioPinDigitalOutput pin02 = null;
	
	private GpioPinDigitalOutput pin05 = null;
	private GpioPinDigitalOutput pin06 = null;
	
	@PostConstruct
	private void init(){
		// Initialise controller pins
		pin00 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
		pin03 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03);
		pin04 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04);
		pin02 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02);
		
		// Set all pins off
		pin00.low();
		pin03.low();
		pin04.low();
		pin02.low();
		
		// Initialise modulation and Tx pins
		pin05 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05);
		pin06 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06);
		
		// Set pins to off
		pin05.low();
		pin06.low();
		
	}
	
	public void allOn(){
		pin00.high();
		pin03.high();
		pin04.low();
		pin02.high();
	}
	
	public void allOff(){
		pin00.high();
		pin03.high();
		pin04.low();
		pin02.low();
	}
	
	public void l1On(){
		pin00.high();
		pin03.high();
		pin04.high();
		pin02.high();
		send();
	}
	
	public void l1Off(){
		pin00.high();
		pin03.high();
		pin04.high();
		pin02.low();
		send();
	}
	
	public void l2On(){
		pin00.low();
		pin03.high();
		pin04.high();
		pin02.high();
		send();
	}
	public void l2Off(){
		pin00.low();
		pin03.high();
		pin04.high();
		pin02.low();
		send();
	}
	public void l3On(){
		pin00.high();
		pin03.low();
		pin04.high();
		pin02.high();
		send();
	}
	public void l3Off(){
		pin00.high();
		pin03.low();
		pin04.high();
		pin02.low();
		send();
	}	
	public void l4On(){
		pin00.low();
		pin03.low();
		pin04.high();
		pin02.high();
		send();
	}
	public void l4Off(){
		pin00.low();
		pin03.high();
		pin04.low();
		pin02.low();
		send();
	}
	
	/**
	 * Enable Tx pin, wait a bit for ramp up and Tx, then switch off.
	 * This is a one way relationship so get no acks back.
	 */
	public void send(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pin06.high();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pin06.low();
	}
	
}
