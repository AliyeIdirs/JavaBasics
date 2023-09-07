package regressionsuit.advancedactions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import regressionsuit.pageobjectmodel.FunctionLibrary;
import regressionsuit.testngframework.ScreenShotUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AdvancedActionsDemo {
    WebDriver driver;
    FunctionLibrary functionLibrary;
    Actions actions;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        functionLibrary=new FunctionLibrary(driver);
        actions=new Actions(driver);
    }
    @Test
    public void dragAndDropTest(){
        driver.get("https://jqueryui.com/droppable/");
        WebElement framePath=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(framePath);
        WebElement draggableElement=driver.findElement(By.id("draggable"));
        functionLibrary.waitForElementPresent(draggableElement);
        WebElement droppableElement=driver.findElement(By.id("droppable"));
        functionLibrary.waitForElementPresent(droppableElement);
        functionLibrary.sleep();
        //actions.dragAndDrop(draggableElement,droppableElement).build().perform();
        actions.dragAndDropBy(draggableElement,100,20)
                .dragAndDropBy(draggableElement,50,10).build().perform();
        //actions.clickAndHold(draggableElement).moveToElement(droppableElement).release().build().perform();
        Assert.assertTrue(droppableElement.getText().contains("Dropped!"));
    }

    @Test
    public void moveToElementTest(){
        driver.get("https://www.barnesandnoble.com/");
        WebElement booksMenu=driver.findElement(By.id("rhfCategoryFlyout_Books"));
        actions.moveToElement(booksMenu).perform();
        functionLibrary.sleep();
        WebElement bestSellersMenu=driver.findElement(By.xpath("(//*[@alt='Bestsellers'])[1]"));
        functionLibrary.waitForElementPresent(bestSellersMenu);
        Assert.assertTrue(bestSellersMenu.isDisplayed());
    }
    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com/");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        actions.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("m")
                .keyUp(Keys.SHIFT).sendKeys("acbook").doubleClick().build().perform();
        functionLibrary.sleep();
    }

    @Test
    public void switchWithinFrames(){
        driver.get("https://jqueryui.com/draggable/");
        String mainPageName=driver.getCurrentUrl();
        System.out.println(mainPageName);
        driver.switchTo().frame(0);
        WebElement draggableElement=driver.findElement(By.id("draggable"));
        actions.clickAndHold(draggableElement).moveByOffset(160,45).release().build().perform();
        functionLibrary.sleep();
        WebElement afterDrag=driver.findElement(By.cssSelector("div[style*='160px; top: 45px;']"));
        Assert.assertTrue(afterDrag.isDisplayed());

        driver.switchTo().defaultContent();
        WebElement resizableLink=driver.findElement(By.linkText("Resizable"));
        functionLibrary.waitForElementPresent(resizableLink);
        actions.click(resizableLink).perform();
        functionLibrary.sleep();
        String resizablePageName=driver.getCurrentUrl();
        System.out.println(resizablePageName);
        Assert.assertNotEquals(mainPageName,resizablePageName);
    }

    @Test
    public void multipleWindowsTest(){
        driver.get("http://www.seleniummastertutorial.com/");
        String currentWindowName=driver.getWindowHandle();
        System.out.println("Main window name is: "+currentWindowName);
        WebElement newWindowButton=driver.findElement(By.id("windowsButton"));
        newWindowButton.click();
        Set<String> allWindows=driver.getWindowHandles();
        for(String eachWindow:allWindows){
            System.out.println("Window name  is: "+eachWindow);
            if(!eachWindow.equalsIgnoreCase(currentWindowName)){
                driver.switchTo().window(eachWindow);
                WebElement goBackButton=driver.findElement(By.partialLinkText("Main Page"));
                functionLibrary.waitForElementPresent(goBackButton);
                Assert.assertTrue(goBackButton.isDisplayed());
            }
        }
    }

    @Test
    public void menuTest(){
        driver.get("https://jqueryui.com/menu/");
        WebElement frame=driver.findElement(By.cssSelector(".demo-frame"));
        driver.switchTo().frame(frame);
        WebElement musicMenu=driver.findElement(By.id("ui-id-9"));
        actions.moveToElement(musicMenu).perform();
        functionLibrary.sleep();
        WebElement jazzMenu=driver.findElement(By.id("ui-id-13"));
        actions.moveToElement(jazzMenu).perform();
        functionLibrary.sleep();
        WebElement bigBandMenu=driver.findElement(By.id("ui-id-15"));
        actions.moveToElement(bigBandMenu).perform();
        functionLibrary.sleep();
        Assert.assertTrue(bigBandMenu.isDisplayed());
    }
    @Test
    public void multipleLinkTest(){
        driver.get("https://jqueryui.com/");
        List<WebElement> allLinks=driver.findElements(By.xpath("//div[@id='sidebar']//a"));
        int totalLink=allLinks.size();
        System.out.println("Total link size: "+totalLink);
        List<String> urls=new ArrayList<>();
        for(WebElement eachLink:allLinks){
            urls.add(eachLink.getAttribute("href"));
        }
        int count=0;
        for(String eachUrl:urls){
                driver.navigate().to(eachUrl);
                functionLibrary.sleep();
                ScreenShotUtility screenShotUtility = new ScreenShotUtility();
                screenShotUtility.takeScreenShot(eachUrl.substring(21).replace("/", ""), driver);
                count++;
                if (count>5)
                    break;
        }
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
