package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class JobTitlesPage extends BasePage {

    private By adminModule = By.id("menu_admin_viewAdminModule");
    private By jobModule = By.id("menu_admin_Job");
    private By jobTitlesModule = By.id("menu_admin_viewJobTitleList");
    private By addButton = By.id("btnAdd");
    private By titleInput = By.id("jobTitle_jobTitle");
    private By descriptionInput = By.id("jobTitle_jobDescription");
    private By noteInput = By.id("jobTitle_note");
    private By saveButton = By.id("btnSave");
    private By deleteButton = By.id("btnDelete");
    private By dialogDeleteButton = By.id("dialogDeleteBtn");
    private By addConfirmation = By.id("saveHobTitleHeading");
    private By jobSpecInput = By.id("jobTitle_jobSpec");

    public JobTitlesPage(WebDriver driver) {
        super(driver);
    }

    public void openJobTitlesPage() {
        clickOn(adminModule);
        clickOn(jobModule);
        clickOn(jobTitlesModule);
    }

    private void jobTitleForm(String title, String description, String path, String note) {
        typeIn(titleInput, title);
        typeIn(descriptionInput, description);
        typeIn(jobSpecInput, path);
        typeIn(noteInput, note);
        clickOn(saveButton);
    }

    public void addJobTitle(String title, String description, String fileName, String note) {
        clickOn(addButton);
        jobTitleForm(title, description, getFilePath(fileName), note);
    }

    public void editJobTitle(String previousTitle, String newTitle, String newDescription, String fileName, String newNote) {
        clickOn(addButton);
        jobTitleForm(previousTitle, "", "", "");
        clickOn(By.xpath("//tr/td/a[contains(text(),'" + previousTitle + "')]"));
        clickOn(saveButton);
        clear(titleInput);
        jobTitleForm(newTitle, newDescription, getFilePath(fileName), newNote);
    }

    public void deleteJobTitle(String title) {
        clickOn(addButton);
        jobTitleForm(title, "", "", "");
        delete(title);
    }

    public void delete(String title) {
        clickOn(By.xpath("//a[contains(text(),'" + title + "')]/../../td[1]/input"));
        clickOn(deleteButton);
        waitForElement(dialogDeleteButton);
        clickOn(dialogDeleteButton);
    }

    public boolean isFound(String title) {
        List<WebElement> allTitles = findElements(By.xpath("//td/a"));
        boolean isFound = false;
        for (int i = 0; i < allTitles.size(); i++) {
            if (allTitles.get(i).getText().equals(title)) {
                isFound = true;
            }
        }
        return isFound;
    }

    public String jobTitleText() {
        return getTextFrom(addConfirmation);
    }

    private String getFilePath(String fileName) {
            File jobSpec = new File("src/test/resources/JobTitlesData/jobSpecs/" + fileName);
            return jobSpec.getAbsolutePath();
    }
}
