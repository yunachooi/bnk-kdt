package chapter05;

import chapter05_vo.Mouse;
import chapter05_vo.OpticalMouse;
import chapter05_vo.WheelMouse;

public class ExtendsMouse {

	public static void main(String[] args) {
		Mouse[] m = new Mouse[3];
		Mouse mouse = new Mouse();
		WheelMouse wheel = new WheelMouse();
		OpticalMouse optical = new OpticalMouse();
		
		m[0] = mouse;
		m[1] = wheel;
		m[2] = optical;
		
		for(int i = 0; i < 3; i++) {
			m[i].clickLift();
			m[i].clickRight();
			if(m[i] instanceof WheelMouse) {
				WheelMouse wm = (WheelMouse)m[i];
				wm.scroll();
			}
			System.out.println("--------------");
		}
		
		for(int i = 0; i < 3; i++) {
			if(m[i].getClass() == Mouse.class) {
				System.out.println("Mouse 타입입니다...");
			}
			else if(m[i].getClass() == WheelMouse.class) {
				System.out.println("Wheel Mouse 타입입니다...");
			}
			else if(m[i].getClass() == OpticalMouse.class) {
				System.out.println("Optical Mouse 타입입니다...");
			}
			System.out.println("------------");
		}
	}

}
