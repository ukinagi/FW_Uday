package executor;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import exception.InvalidKeyWordException;
import generic.WebGeneric;

public class Keyword {
	public static void executeKeyword(Logger log,WebDriver driver,String keyword1,String keyword2,String keyword3) {
	log.info("Start-executeKeyword");
	if(keyword1.equalsIgnoreCase("enter")){
	WebGeneric.enter(driver, keyword2, keyword3);
	}
	else if(keyword1.equalsIgnoreCase("click")){
    WebGeneric.click(driver, keyword2);
	}
	else if(keyword1.equalsIgnoreCase("verifyElementPresent"))
	{
		if(keyword3.length()>0){
			
		    log.info("Timeout is:"+keyword3);
			WebGeneric.verifyElementPresent(log, driver, keyword2,keyword3);
	        }
		else{
		log.info("No Timeout");
		WebGeneric.verifyElementPresent(log, driver, keyword2);
		
		}
		}
	else if(keyword1.equalsIgnoreCase("verifyTitle")){
		WebGeneric.verifyTitle(log, driver, keyword2, keyword3);
	}
	else if(keyword1.equalsIgnoreCase("selectOptionByIndex")){
		WebGeneric.selectOptionByIndex(log, driver, keyword2, keyword3);
	}
	else if(keyword1.equalsIgnoreCase("selectOptionByValue")){
		WebGeneric.selectOptionByValue(log, driver, keyword2, keyword3);
	}
	else if(keyword1.equalsIgnoreCase("selectOptionByText")){
		WebGeneric.selectOptionByText(log, driver, keyword2, keyword3);
	}
	
	else if(keyword1.equalsIgnoreCase("deselectOptionByIndex")){
		WebGeneric.deselectOptionByIndex(log, driver, keyword2, keyword3);
	}
	
	else if(keyword1.equalsIgnoreCase("deselectOptionByValue")){
		WebGeneric.deselectOptionByValue(log, driver, keyword2, keyword3);
	}

	else if(keyword1.equalsIgnoreCase("deselectOptionByText")){
		WebGeneric.deselectOptionByText(log, driver, keyword2, keyword3);
	}
	//----
	else if(keyword1.equalsIgnoreCase("deselectAllOptions")){
		WebGeneric.deselectAllOptions(log, driver, keyword2, keyword3);
	}
	
	//--------------
	else if(keyword1.equalsIgnoreCase("isListBoxSorted")){
		WebGeneric.isListBoxSorted(log, driver, keyword2);
		
	}
	
	
	else if(keyword1.equalsIgnoreCase("switchToFrameByIndex")){
		WebGeneric.switchToFrameByIndex(log, driver, keyword2);
	}
	
	
	else if(keyword1.equalsIgnoreCase("searchListBox")){
		WebGeneric.searchListBox(log, driver, keyword2,keyword3);
		
	}
	else if(keyword1.equalsIgnoreCase("exitFromFrameToPage")){
		WebGeneric.exitFromFrameToPage(log, driver, keyword2);
	}
	
	else if(keyword1.equalsIgnoreCase("switchToFrameByIdOrName")){
		WebGeneric.switchToFrameByIdOrName(log, driver, keyword2);
	}
	
	else if(keyword1.equalsIgnoreCase("switchToFrameByAddress")){
		WebGeneric.switchToFrameByAddress(log, driver, keyword2);
	}
	
	else if(keyword1.equalsIgnoreCase("exitFromFrameToParent")){
		WebGeneric.exitfromFrameToParent(log, driver, keyword2);
	}
	
	
	else if(keyword1.equalsIgnoreCase("verifyColor")){
		WebGeneric.verifyColor(log, driver, keyword2, keyword3);
	}
	else if(keyword1.equalsIgnoreCase("verifyFontType")){
		WebGeneric.verifyFontType(log, driver, keyword2, keyword3);
	}
	else if(keyword1.equalsIgnoreCase("verifyURLContains")){
		WebGeneric.verifyURLContains(log, driver, keyword2, keyword3);
	}
	else if(keyword1.equalsIgnoreCase("verifyElementIsEnabled")){
		WebGeneric.verifyElementIsEnabled(log, driver, keyword2);
	}
	else if(keyword1.equalsIgnoreCase("verifyElementIsSelected")){
		WebGeneric.verifyElementIsSelected(log, driver, keyword2);
	}
	else if(keyword1.equalsIgnoreCase("verifyText")){
		WebGeneric.verifyText(log, driver, keyword2, keyword3);
	}
	else{
		log.error("Invalid keyword");
		throw new InvalidKeyWordException("Invalid Keyword"+keyword1);
	}
	log.info("End-executekeyword");
	
	
	
	
	}
}
