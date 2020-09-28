# Video Notes Test Automation

###Frameworks/Language used:
- [Java 8](https://www.oracle.com/java/technologies/java8.html)
- [Selenium](https://www.selenium.dev/) - Selenium Java v2.53
- [TestNG](https://testng.org/doc/index.html) - v6.8
- [Maven](https://maven.apache.org/) - v3.6

###Setup Instructions:
- Install Java 8

- Install and configure Maven
    - Project is configured using maven framework to download dependencies (like Selenium and TestNG)
    - Verify using "mvn --version"
   
- Install preferred IDE (e.g. [Eclipse](https://www.eclipse.org/))

- If you are using eclipse IDE then install 
    - Maven plugin
    - TestNG plugin (to run Test suite from Eclipse IDE )

- Chrome Driver v2.41 (chromedriver.exe) is available in project root folder

### Run Test Suite:

There are 3 Test Cases are configured in Test Suite **videonotestestng.xml** file covering following scenarios:
1. Register User - Register new user based on username, email and password
2. Login - Login using previously registered user
3. Create new Note - After login as registered user, create new note and tag comment to specific time

#### To execute Test Suite:

- Eclipse IDE
    - Right click **videonotestestng.xml** (src/main/resouces folder) and Run as TestNG Suite
    

- Command line
    - Make sure Maven is configured in path
    - Open command line tool (Git bash or command prompt)
    - From project root folder, Run command "mvn clean test"
     
#### Test Report (Results):
- Both emailable report and Test result reports will be available in **"test-output"** folder
