package linkedintest.testcases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import linkedintest.base.Base;


public class LinkedinProfileTest extends Base {

    public WebDriver driver;

    public LinkedinProfileTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void AccessProfileTest() throws InterruptedException, IOException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"session_key\"]")).sendKeys(prop.getProperty("email"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"session_password\"]")).sendKeys(prop.getProperty("pass"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        String filePath, profileLink;

        String Path = "/Users/rubaiyatemohammad/work/LegoIO/rubaiyat-linkedin-test/";
        String Link = "https://www.linkedin.com/in/";

        String[] pathname = {"JonathanNorori.json", "ChrisHayen.json", "DanCostinett.json", "TomBatzold.json"};
        String[] pathlink = {"norori/", "chris-hayen-1842036b/", "dan-costinett/","tom-batzold-02a78728/"};


//

        for(int i=0; i<pathname.length; i++){
            System.out.println(pathname[i]);
            filePath = Path + pathname[i];
            profileLink = Link + pathlink[i];
            // Read and process each profile
            profileInfo(filePath, profileLink);
        }

    }

    private void profileInfo(String filePath, String profileLink) throws InterruptedException, IOException {

        driver.get(profileLink);
        Thread.sleep(2000);

        File file = new File(filePath);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("{" + "\n");

        try{
            Thread.sleep(3000);
            String name = driver.findElement(By.xpath("//h1[@class='text-heading-xlarge inline t-24 v-align-middle break-words']")).getText();
            Thread.sleep(2000);
            bw.write(" \"Name\" : " + "\"" + name + "\"," + "\n");
        }catch (Exception e){
            System.out.println("Name Not Found");
        }

        try{
            Thread.sleep(2000);
            String bio = driver.findElement(By.xpath("//div[@class='text-body-medium break-words']")).getText();
            bw.write(" \"Bio\" : " + "\"" + bio + "\"," + "\n");
        }catch (Exception e){
            System.out.println("Bio Not Found");
        }

        try{
            Thread.sleep(2000);
            String location = driver.findElement(By.xpath("//span[@class='text-body-small inline t-black--light break-words']")).getText();
            bw.write(" \"Location\" : " + "\"" + location + "\"," + "\n");
        }catch (Exception e){
            System.out.println("Location Not Found");
        }

        try{
            Thread.sleep(2000);
            String presentCompany = driver.findElement(By.xpath("//ul[@class='pv-text-details__right-panel']//li[1]")).getText();
            bw.write(" \"Present Company\" : " + "\"" + presentCompany + "\"," + "\n");
        }catch (Exception e){
            System.out.println("Company Not Found");
        }

        try{
            Thread.sleep(2000);
            String Heducation = driver.findElement(By.xpath("//ul[@class='pv-text-details__right-panel']//li[2]")).getText();
            bw.write(" \"Highest Education\" : " + "\"" + Heducation + "\"," + "\n");
        }catch (Exception e){
            System.out.println("Education Not Found");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[2]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[3]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[4]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[5]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[6]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[7]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[8]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {

            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[9]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[10]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[11]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        try {
            Thread.sleep(2000);
            String info = driver.findElement(By.xpath("//section[12]")).getText();
            writeInfo(info, bw);
        } catch (Exception e) {
            System.out.println("No Info");
        }

        bw.write("}");
        bw.close();

        try {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
            content.deleteCharAt(content.length() - 3);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(content.toString());
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Text has been written to the file successfully.");

    }

    private void writeInfo(String info, BufferedWriter bw) throws IOException {
        if(info.startsWith("About")){
            info = removeDuplicatesFromString(info);
            info = info.replaceAll("About ", "");
            bw.write(" \"About\" : " + "\"" + info + "\"," + "\n");
        } else if (info.startsWith("Experience")) {

            try{
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@id='navigation-index-see-all-experiences']")).click();
                Thread.sleep(2000);
                info = driver.findElement(By.xpath("//div[@class='pvs-list__container'][1]")).getText();
                Thread.sleep(2000);
                info = removeDuplicatesFromString(info);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@aria-label='Back to the main profile page']")).click();
                Thread.sleep(2000);
            }catch(Exception e){
                info = removeDuplicatesFromString(info);
            }
            info = info.replaceAll("Experience ", "");
            bw.write(" \"Experience\" : " + "\"" + info + "\"," + "\n");
        } else if (info.startsWith("Education")) {

            try{
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@id='navigation-index-see-all-education']")).click();
                Thread.sleep(2000);
                info = driver.findElement(By.xpath("//div[@class='pvs-list__container'][1]")).getText();
                Thread.sleep(2000);
                info = removeDuplicatesFromString(info);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@aria-label='Back to the main profile page']")).click();
                Thread.sleep(2000);
            }catch(Exception e){
                info = removeDuplicatesFromString(info);
            }
            info = info.replaceAll("Education ", "");
            bw.write(" \"Education\" : " + "\"" + info + "\"," + "\n");
        } else if (info.startsWith("Skills")) {
            int originalLength = info.length();
            String makeid = info.substring(originalLength - 9);
            makeid = makeid.replaceAll(" ", "-");
            makeid = "navigation-index-Show-all-" + makeid;
            try{
                Thread.sleep(2000);
                driver.findElement(By.id(makeid)).click();
                Thread.sleep(2000);
                info = driver.findElement(By.xpath("//section[@class='artdeco-card pb3'][1]")).getText();
                Thread.sleep(2000);
                info = removeDuplicatesFromString(info);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@aria-label='Back to the main profile page']")).click();
                Thread.sleep(2000);
            }catch(Exception e){
                info = removeDuplicatesFromString(info);
            }
            info = info.replaceAll("Skills ", "");
            info = info.replaceAll("All ", "");
            info = info.replaceAll("Industry Knowledge ", "");
            info = info.replaceAll("Tools & Technologies ", "");
            info = info.replaceAll("Interpersonal Skills ", "");
            info = info.replaceAll("Interpersonal", "");
            info = info.replaceAll("Other", "");
            info = info.replaceAll("Other Skills ", "");
            info = info.replaceAll("Show more results", "");

            bw.write(" \"Skills\" : " + "\"" + info + "\"," + "\n");
        } else if (info.startsWith("Licenses & certifications")) {

            try{
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@id='navigation-index-see-all-licenses-and-certifications']")).click();
                Thread.sleep(2000);
                info = driver.findElement(By.xpath("//div[@class='pvs-list__container'][1]")).getText();
                Thread.sleep(2000);
                info = removeDuplicatesFromString(info);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@aria-label='Back to the main profile page']")).click();
                Thread.sleep(2000);
            }catch(Exception e){
                info = removeDuplicatesFromString(info);
            }
            info = info.replaceAll("Licenses & certifications ", "");
            bw.write(" \"Licenses & certifications\" : " + "\"" + info + "\"," + "\n");
        } else if (info.startsWith("Honors & awards")) {

            try{
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@id='navigation-index-see-all-honors-and-awards']")).click();
                Thread.sleep(2000);
                info = driver.findElement(By.xpath("//div[@class='pvs-list__container'][1]")).getText();
                Thread.sleep(2000);
                info = removeDuplicatesFromString(info);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@aria-label='Back to the main profile page']")).click();
                Thread.sleep(2000);
            }catch(Exception e){
                info = removeDuplicatesFromString(info);
            }
            info = info.replaceAll("Honors & awards ", "");
            bw.write(" \"Honors & awards\" : " + "\"" + info + "\"," + "\n");
        } else if (info.startsWith("Courses")) {

            try{
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@id='navigation-index-see-all-courses']")).click();
                Thread.sleep(2000);
                info = driver.findElement(By.xpath("//div[@class='pvs-list__container'][1]")).getText();
                Thread.sleep(2000);
                info = removeDuplicatesFromString(info);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@aria-label='Back to the main profile page']")).click();
                Thread.sleep(2000);
            }catch(Exception e){
                info = removeDuplicatesFromString(info);
            }
            info = info.replaceAll("Courses ", "");
            bw.write(" \"Courses\" : " + "\"" + info + "\"," + "\n");
        }
    }

    private static String removeDuplicatesFromString(String str) {
        String[] lines = str.split("\n");
        StringBuilder uniqueString = new StringBuilder();

        String prevLine = null;
        for (String line : lines) {
            if (!line.equals(prevLine)) {
                uniqueString.append(line).append(" ");
            }
            prevLine = line;
        }
        String replaceLine = uniqueString.toString().trim();
        String output = replaceLine.replaceAll("\n", "");
        output = output.replaceAll("...see more", "");
        output = output.replaceAll("Show credential", "");
        return output;
    }

}