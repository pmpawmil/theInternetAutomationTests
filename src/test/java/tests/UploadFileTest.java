package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.UploadFilePage;

import static navigation.ApplicationURLs.UPLOAD_FILE_URL;

public class UploadFileTest extends TestBase {

    // third-party tool to manipulate windows
    // https://www.toolsqa.com/selenium-webdriver/autoit-selenium-webdriver/

    @Test
    @Description("...")
    public void uploadAFile() throws InterruptedException {

        DriverUtils.navigateToPage(UPLOAD_FILE_URL);
        UploadFilePage uploadFilePage = new UploadFilePage();
        uploadFilePage.uploadFile();
    }
}
