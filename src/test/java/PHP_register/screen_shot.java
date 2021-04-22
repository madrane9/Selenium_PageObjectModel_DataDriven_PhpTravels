package PHP_register;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screen_shot {

	public static void take_screenshot(WebDriver driver, String screen_shot_path) throws IOException
	{
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SrcFile, new File(screen_shot_path));
		
	}
}
