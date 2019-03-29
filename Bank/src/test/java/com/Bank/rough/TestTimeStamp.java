package com.Bank.rough;

import java.util.Date;

public class TestTimeStamp {
	
	public static void main(String[] args) {
		Date d = new Date();
		String screenShotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		System.out.println(screenShotName);
	}

}
