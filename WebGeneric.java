package generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import exception.ColorMisMatchException;
import exception.ElementNotPresentException;
import exception.ElementNotSelectedException;
import exception.FontTypeMismatchException;
import exception.ListBoxNotSortedException;
import exception.OptionNotFoundException;
import exception.TextNotMatchingException;
import exception.TitleNotMatchingException;
import exception.UrlNotMatchingException;

public class WebGeneric {
	public static void enter(WebDriver driver,String keyword2,String keyword3){
		driver.findElement(By.xpath(keyword2)).sendKeys(keyword3);
	}
public static void click(WebDriver driver,String keyword2){
	driver.findElement(By.xpath(keyword2)).click();
}
public static void verifyElementPresent(Logger log,WebDriver driver,String keyword2,String keyword3){
	long timeOut=Long.parseLong(keyword3);
	WebDriverWait wait=new WebDriverWait(driver,timeOut);
	try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(keyword2)));
		log.info("PASS:Element is present:"+keyword2);
	}
	catch(TimeoutException e){
		log.error("FAIL:Element is not present after"+timeOut+" secs");
		throw new ElementNotPresentException("Element is not Present"+keyword2);
	}
	
}
public static void verifyElementPresent(Logger log,WebDriver driver,String keyword2){
	try{
		boolean displayed = driver.findElement(By.xpath(keyword2)).isDisplayed();
		if(displayed){
			log.info("PASS:Element is Present:"+keyword2);
		}
		else{
			log.error("FAIL:Element is not present");
			String msg="Element is not Present";
			throw new ElementNotPresentException(msg+keyword2);
			
			
		}
	}
catch(NoSuchElementException e){
	String msg="Element is not Present( in src):";
	throw new ElementNotPresentException(msg+keyword2);
}
}
public static void verifyTitle(Logger log,WebDriver driver,String keyword2,String keyword3)
{
	long timeout=Long.parseLong(keyword3);
	log.info("Expected title:"+keyword2);
	WebDriverWait wait=new WebDriverWait(driver,timeout);
	try{
		wait.until(ExpectedConditions.titleIs(keyword2));
		log.info("PASS:Title is Matching");
		
	}
	catch(TimeoutException e){
		String aTitle=driver.getTitle();
		log.info("Actual Tile:"+aTitle);
		log.error("FAIL:Title is not Matching even after"+timeout+"Sec");
		throw new TitleNotMatchingException("Title is Not Matching");
		
		
	}
	

	
}
public static void verifyURLContains(Logger log,WebDriver driver,String keyword2,String keyword3){
	long timeOut=Long.parseLong(keyword3);
	log.info("Expected URL fractions:"+keyword2);
	WebDriverWait wait=new WebDriverWait(driver,timeOut);
	try{
		wait.until(ExpectedConditions.urlContains(keyword2));
		log.info("PASS:Actual URL COntains Expected URL Fraction");
		
	}
	catch(TimeoutException e)
	{
		String aURL=driver.getCurrentUrl();
		log.info("Actual URL :"+aURL);
		log.error("FAIL:URL does NOT contain Expected URL fraction");
		throw new UrlNotMatchingException("URL Not Matching");
		
	}

	
}
public static void verifyElementIsEnabled(Logger log,WebDriver driver,String keyword2){
	boolean enabled = driver.findElement(By.xpath(keyword2)).isEnabled();
	if(enabled)
	{
		log.info("PASS:Element is Enabled:"+keyword2);
		
	}
	else{
		log.error("FAIL:Element is Disabled:"+keyword2);
		throw new InvalidElementStateException("element is not presegent");//inbuilt Exception
	}
	
}
//----------------------------------------------------------------------------
public static void mouseHover(Logger log,WebDriver driver,String keyword2){
	Actions actions=new Actions(driver);
	WebElement e = driver.findElement(By.xpath(keyword2));
	actions.moveToElement(e).perform();
	log.info("Hovering on Element:"+keyword2);
	
	}
public static void dragDrop(Logger log,WebDriver driver,String keyword2,String keyword3){
	Actions actions=new Actions(driver);
	WebElement from = driver.findElement(By.xpath(keyword2));
	WebElement to=driver.findElement(By.xpath(keyword3));
	actions.dragAndDrop(from, to).perform();
	log.info("Drag Element:"+keyword2);
	log.info("Drop it onto element"+keyword3);
	
	
}
public static void doubleClick(Logger log,WebDriver driver,String keyword2,String keyword3){
	Actions actions=new Actions(driver);
	WebElement e = driver.findElement(By.xpath(keyword2));
	actions.doubleClick(e).perform();
	log.info("Double CLicling on element:"+keyword2);	
	
}
public static void rightClick(Logger log,WebDriver driver,String keyword2){
	Actions actions=new Actions(driver);
	WebElement e = driver.findElement(By.xpath(keyword2));
	actions.contextClick(e).perform();
	log.info("Double CLicking on element:"+keyword2);
	
}

public static void selectOptionByIndex(Logger log,WebDriver driver,String keyword2,String keyword3){
    WebElement e = driver.findElement(By.xpath(keyword2));
    Select select=new Select(e);
    int Index=Integer.parseInt(keyword3);
    select.selectByIndex(Index);
    log.info("Sleecting option in ListBox using Index:"+keyword3);
}

public static void selectOptionByValue(Logger log,WebDriver driver,String keyword2,String keyword3){
    WebElement e = driver.findElement(By.xpath(keyword2));
    Select select=new Select(e);
    select.selectByValue(keyword3);
    log.info("Sleecting option in ListBox using value:"+keyword3);
}

public static void selectOptionByText(Logger log,WebDriver driver,String keyword2,String keyword3){
    WebElement e = driver.findElement(By.xpath(keyword2));
    Select select=new Select(e);
    select.selectByVisibleText(keyword3);
    log.info("Sleecting option in ListBox using text:"+keyword3);
}

public static void deselectOptionByIndex(Logger log,WebDriver driver,String keyword2,String keyword3){
    WebElement e = driver.findElement(By.xpath(keyword2));
    Select select=new Select(e);
    int Index=Integer.parseInt(keyword3);
    select.deselectByIndex(Index);
    log.info("DeSleecting option in ListBox using Index:"+keyword3);
}

public static void deselectOptionByValue(Logger log,WebDriver driver,String keyword2,String keyword3){
    WebElement e = driver.findElement(By.xpath(keyword2));
    Select select=new Select(e);
    select.deselectByValue(keyword3);
    log.info("deSleecting option in ListBox using value:"+keyword3);
}

public static void deselectOptionByText(Logger log,WebDriver driver,String keyword2,String keyword3){
    WebElement e = driver.findElement(By.xpath(keyword2));
    Select select=new Select(e);
   
    select.deselectByVisibleText(keyword3);
    log.info("deSleecting option in ListBox using text:"+keyword3);
}
public static void deselectAllOptions(Logger log,WebDriver driver,String keyword2,String keyword3){
    WebElement e = driver.findElement(By.xpath(keyword2));
    Select select=new Select(e);
    select.deselectAll();
    log.info("DeSleecting All options in ListBox");
    
}

//-------------------------------------------------------------------

public static void switchToFrameByIndex(Logger log,WebDriver driver,String keyword2){

	int index=Integer.parseInt(keyword2);
	driver.switchTo().frame(index);
	log.info("Switching frame by Index:"+keyword2);
}
public static void switchToFrameByIdOrName(Logger log,WebDriver driver,String keyword2){

    
	driver.switchTo().frame(keyword2);
	log.info("Switching frame by id or name:"+keyword2);
}

public static void switchToFrameByAddress(Logger log,WebDriver driver,String keyword2){

    WebElement e = driver.findElement(By.xpath(keyword2));
	driver.switchTo().frame(e);
	log.info("Switching frame by element address:"+keyword2);
}

//-----------------------------------------------

public static void searchListBox(Logger log,WebDriver driver,String keyword2,String keyword3){
    boolean found=false;
    log.info("searching "+keyword3+" in ListBox "+keyword2);
    WebElement e = driver.findElement(By.xpath(keyword2));
	Select select=new Select(e);
	List<WebElement> alloptions = select.getOptions();
	for(WebElement option:alloptions)
	{
		String text=option.getText();
		log.info("Comparing with:"+text);
		if(text.equalsIgnoreCase(keyword3)){
			found=true;
			break;
		}
	}
	if(found){
		log.info("PASS:option found in ListBox");
	}
	else{
		log.info("FAIL:Option not found in ListBox ");
		throw new OptionNotFoundException("Option NOt Found Exception");
	}
       
	}

//-------------------------------------------

public static void isListBoxSorted(Logger log,WebDriver driver,String keyword2){
	WebElement e = driver.findElement(By.xpath(keyword2));
	Select select=new Select(e);
	List<WebElement> allOptions = select.getOptions();
	ArrayList<String> allText=new ArrayList<String>();
	for(WebElement option:allOptions){
		allText.add(option.getText());
	}
	ArrayList<String> copy=new ArrayList<String>(allText);
	Collections.sort(copy);
	if(allText.equals(copy)){
		log.info("PASS:ListBox is in Sorted Order");
	}
	else{
		log.error("FAIL:ListBox is Not in sorted Order");
		throw new ListBoxNotSortedException("Listbox is not sorted");
	}
	
	
	
	
}
	


public static void exitFromFrameToPage(Logger log,WebDriver driver,String keyword2){

    
	driver.switchTo().defaultContent();
	log.info("exiting from frame to page:");
}

public static void exitfromFrameToParent(Logger log,WebDriver driver,String keyword2){

    
	driver.switchTo().parentFrame();
	log.info("Exiting from frame to Parent:");
}


public static void verifyElementIsSelected(Logger log,WebDriver driver,String keyword2){
	boolean selected = driver.findElement(By.xpath(keyword2)).isSelected();
	if(selected){
		log.info("Element is Selected:"+keyword2);
	}
	else{
		log.info("FAIL:Element is not selected"+keyword2);
		throw new ElementNotSelectedException("Element not selected");
	}
	
}
public static void verifyColor(Logger log,WebDriver driver,String keyword2,String keyword3){
	WebElement element = driver.findElement(By.xpath(keyword2));
	String aColor = element.getCssValue("color");
	String hColor = Color.fromString(aColor).asHex();
	log.info("Actual color code:"+hColor);
	log.info("Expected color code:"+keyword3);
	if(hColor.equals(keyword3)){
		log.info("Pass:Color matching for:"+keyword2);
		
	}else{
		log.error("FAIL:Color is not matching for:"+keyword2);
		throw new ColorMisMatchException("Color is not matching");
	}
	
}
public static void verifyFontType(Logger log,WebDriver driver,String keyword2,String keyword3){
	WebElement element = driver.findElement(By.xpath(keyword2));
	String aFont = element.getCssValue("font-Family");
	log.info("Actual Font:"+aFont);
	log.info("Expected Font:"+keyword3);
	if(aFont.equalsIgnoreCase(keyword3)){
		log.info("Pass:Font is matching for:"+keyword2);
	}else{
		log.error("Fail:Fontsixze is not matching for :"+keyword2);
		throw new FontTypeMismatchException("Fonttype is not matching");
	}
}

/*----------------------------------------------------------
public static void verifyFontSize(Logger log,WebDriver driver,String keyword2,String keyword3){
	WebElement element = driver.findElement(By.xpath(keyword2));
	String aFont = element.getCssValue("font-size");
	log.info("Actual Font:"+aFont);
	log.info("Expected Font:"+keyword3);
	if(aFont.equalsIgnoreCase(keyword3)){
		log.info("Pass:Font is matching for:"+keyword2);
	}else{
		log.error("Fail:Fontsixze is not matching for :"+keyword2);
		throw new FontTypeMismatchException("Fonttype is not matching");
	}
}

----------------------------------------------------------
*/

public static void verifyText(Logger log,WebDriver driver,String keyword2,String keyword3){
	log.info("Expected Text;"+keyword3);
	String aText=driver.findElement(By.xpath(keyword2)).getText();
	log.info("Actual Text:"+aText);
	if(aText.equals(keyword3)){
		log.info("PASS:Text is matching");
		
	}
	else{
		log.error("FAIL:Text is not matching");
	    throw new TextNotMatchingException("Text is Not matching");
	}
	
	
}
}


