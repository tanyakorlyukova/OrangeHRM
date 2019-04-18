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
    private By heading = By.xpath("//div[@class='head']/h1");
    private By jobSpecInput = By.id("jobTitle_jobSpec");
    private By jobTitlesList = By.xpath("//td/a");
    private By fileExist = By.id("fileLink");
    private By updateFile = By.id("jobTitle_jobSpecUpdate_3");

    public JobTitlesPage(WebDriver driver) {
        super(driver);
    }

    public void openJobTitlesPage() {
        clickOn(adminModule);
        openJobTitles();
    }

    public void openJobTitles() {
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

    public void editJobTitle(String newTitle, String newDescription, String fileName, String newNote) {
        if(listOfTitles().size() != 0) {
            listOfTitles().get(1).click();
            clickOn(saveButton);
            clearForm();
            jobTitleForm(newTitle, newDescription, getFilePath(fileName), newNote);
        }
    }

    private void clearForm() {
        clear(titleInput);
        clear(descriptionInput);
        find(jobSpecInput).getText();
        if(findElements(fileExist).size() != 0) {
            clickOn(updateFile);
        }
        clear(noteInput);
    }

    public void deleteJobTitle(int number) {
        if(listOfTitles().size() != 0) {
            delete(listOfTitles(), number);
        }
    }

    private void delete(List<WebElement> titles, int number) {
        for(int i = 0; i < number; i++) {
            String title = titles.get(i).getText();
            clickOn(By.xpath("//a[contains(text(),'" + title + "')]/../../td[1]/input"));
        }
        clickOn(deleteButton);
        if(number != 0) {
            waitForElement(dialogDeleteButton);
            clickOn(dialogDeleteButton);
        }
    }

    public boolean isFound(String title) {
        List<WebElement> allTitles = findElements(jobTitlesList);
        boolean isFound = false;
        for (int i = 0; i < allTitles.size(); i++) {
            if (allTitles.get(i).getText().equals(title)) {
                isFound = true;
            }
        }
        return isFound;
    }

    public String getHeadingText() {
        return getTextFrom(heading);
    }

    private String getFilePath(String fileName) {
        File jobSpec = new File("src/test/resources/JobTitlesData/jobSpecs/" + fileName);
        return jobSpec.getAbsolutePath();
    }

    public int getCountOfJobTitles() {
        List<WebElement> allTitles = listOfTitles();
        return allTitles.size();
    }

    public List<WebElement> listOfTitles() {
        return findElements(jobTitlesList);
    }

}
