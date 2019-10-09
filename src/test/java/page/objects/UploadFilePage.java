package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadFilePage extends BasePage {

    @FindBy(id = "file-upload")
    private WebElement uploadFileButton;

    @FindBy(id = "file-submit")
    private WebElement submitFileButton;

    private final static String filename = "file_to_upload.txt";

    @Step("Upload file")
    public UploadFilePage uploadFile() throws InterruptedException {

        File file = new File(filename);
        // absolute path to file in project folder
        String path = file.getAbsolutePath();
        log().info(path);

        // test of highlighting elements
        highlightElement(uploadFileButton, 3);
        highlightElement(submitFileButton, 3);

        log().info("File path {} injected into the form", path);
        uploadFileButton.sendKeys(path);
        log().info("Form submitted");
        submitFileButton.click();

        WebElement uploadedFile = DriverManager.getWebDriver().findElement(By.id("uploaded-files"));
        AssertWebElement.assertThat(uploadedFile).hasText(filename);

        return this;
    }
}
