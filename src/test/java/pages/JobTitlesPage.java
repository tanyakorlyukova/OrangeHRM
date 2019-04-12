package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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


    public JobTitlesPage(WebDriver driver) {
        super(driver);
    }

    public void openJobTitlesPage() {
        clickOn(adminModule);
        clickOn(jobModule);
        clickOn(jobTitlesModule);
    }

    private void jobTitleForm(String title, String description, String note) {
        typeIn(titleInput, title);
        typeIn(descriptionInput, description);
        typeIn(noteInput, note);
        clickOn(saveButton);
    }

    public void addJobTitle(String title, String description, String note) {
        clickOn(addButton);
        jobTitleForm(title, description, note);
    }

    public void editJobTitle(String previousTitle, String newTitle, String newDescription, String newNote) {
        clickOn(By.xpath("//tr/td/a[contains(text(),'" + previousTitle + "')]"));
        clickOn(saveButton);
        clear(titleInput);
        clear(descriptionInput);
        clear(noteInput);
        jobTitleForm(newTitle, newDescription, newNote);
    }

    public void deleteJobTitle(String title) {
        addJobTitle(title, "", "");
        clickOn(By.xpath("//a[contains(text(),'" + title + "')]/../../td/input"));
        clickOn(deleteButton);
        waitForElement(dialogDeleteButton);
        clickOn(dialogDeleteButton);
    }
}
