package regressionsuit.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import regressionsuit.cubecartobjects.NewsletterObject;
import regressionsuit.testngproject.TestData;
import regressionsuit.testngproject.FunctionLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NewslettersPage {
    WebDriver driver;
    FunctionLibrary functionLibrary;

    public NewslettersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        functionLibrary=new FunctionLibrary(driver);
    }

    @FindBy(linkText = "Create Newsletter")
    WebElement createNewsLetterLink;
    @FindBy(id = "email_subject")
    WebElement newsLetterSubjectField;
    @FindBy(id = "sender_name")
    WebElement senderNameField;
    @FindBy(id = "sender_email")
    WebElement senderEmailField;
    @FindBy (id = "template_id")
    WebElement templateField;
    @FindBy(linkText = "HTML Content")
    WebElement htmlContentLink;
    @FindBy(css = "iframe[aria-describedby*='cke_76']")
    WebElement iframe;
    @FindBy(css = "body[class*='_editable']")
    WebElement htmlContentField;
    @FindBy(linkText = "Plain Text Content")
    WebElement plainTextContentLink;
    @FindBy(id = "content_text")
    WebElement textContentField;
    @FindBy(linkText = "Send Test Email")
    WebElement sendTestEmailLink;
    @FindBy(id = "email_test")
    WebElement recipientEmailField;
    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement saveButton;
    @FindBy(css = ".tiny")
    WebElement saveAndSendButton;
    @FindAll(
            @FindBy(xpath = "//div[@id='gui_message']/div[@class='success']")
    )
    List<WebElement> successMessage;
    public void selectTemplate(){
        Select select=new Select(templateField);
        List<String> options=new ArrayList<>(Arrays.asList(TestData.template.NONE.getValue(),
                TestData.template.DEFAULT_NEWSLETTER.getValue(), TestData.template.DEFAULT_EMAILS.getValue()));
        Random random=new Random();
        String toBeSelected= options.get(random.nextInt(options.size()));
        select.selectByVisibleText(toBeSelected);
    }
    public void createNewsLetter(NewsletterObject newsletterObject){
        functionLibrary.waitForElementPresent(createNewsLetterLink);
        createNewsLetterLink.click();
        newsLetterSubjectField.sendKeys(newsletterObject.getNewsLetterSubject());
        senderNameField.sendKeys(newsletterObject.getSenderName());
        senderEmailField.sendKeys(newsletterObject.getSenderEmail());
        functionLibrary.sleep();
        selectTemplate();
        htmlContentLink.click();
        functionLibrary.sleep();
        driver.switchTo().frame(iframe);
        Actions actions=new Actions(driver);
        actions.sendKeys(htmlContentField, newsletterObject.getHtmlContent()).perform();
        driver.switchTo().defaultContent();
        functionLibrary.sleep();
        plainTextContentLink.click();
        functionLibrary.waitForElementPresent(textContentField);
        textContentField.sendKeys(newsletterObject.getPlainTextContent());
        functionLibrary.sleep();
        sendTestEmailLink.click();
        functionLibrary.waitForElementPresent(recipientEmailField);
        recipientEmailField.sendKeys(newsletterObject.getRecipientEmail());
        saveAndSendButton.click();
        System.out.println("Newsletter subject is: "+newsletterObject.getNewsLetterSubject());
    }
    public void createNewsLetter(String newsletterSubject,String senderName,String senderEmail,
                                 String htmlContent, String plainTextContent, String recipientEmail){
        functionLibrary.waitForElementPresent(createNewsLetterLink);
        createNewsLetterLink.click();
        newsLetterSubjectField.sendKeys(newsletterSubject);
        senderNameField.sendKeys(senderName);
        senderEmailField.sendKeys(senderEmail);
        functionLibrary.sleep();
        selectTemplate();
        htmlContentLink.click();
        functionLibrary.sleep();
        driver.switchTo().frame(iframe);
        Actions actions=new Actions(driver);
        actions.sendKeys(htmlContentField,htmlContent).perform();
        driver.switchTo().defaultContent();
        functionLibrary.sleep();
        plainTextContentLink.click();
        functionLibrary.waitForElementPresent(textContentField);
        textContentField.sendKeys(plainTextContent);
        functionLibrary.sleep();
        sendTestEmailLink.click();
        functionLibrary.waitForElementPresent(recipientEmailField);
        recipientEmailField.sendKeys(recipientEmail);
        saveAndSendButton.click();
        System.out.println("Newsletter subject is: "+newsletterSubject);
    }
    public boolean editNewsletter(String newsLetterSubject){
        WebElement editIcon=driver.findElement(By.xpath(String.format("//a[text()='%s']/ancestor::tr/td//a/i[@title='Edit']",newsLetterSubject)));
        editIcon.click();
        selectTemplate();
        saveButton.click();
        List<WebElement> editSuccessMessage=driver.findElements(By.xpath("//div[text()='Newsletter Saved.']"));
        if (editSuccessMessage.size()>=1)
            return true;
        else
            return false;
    }
    public boolean deleteNewsletter(String newLetterSubject){
        WebElement deleteIcon=driver.findElement(By.xpath(String.format("//a[text()='%s']/ancestor::tr/td//a[@class='delete']",newLetterSubject)));
        deleteIcon.click();
        driver.switchTo().alert().accept();

        List<WebElement> verifyMessage=driver.findElements(By.xpath("//div[text()='Newsletter deleted.']"));
        if (verifyMessage.size()>=1)
            return true;
        else
            return false;
    }

    public boolean verifyNewsletterCreated(){
        return successMessage.size()>=1;
    }
}
