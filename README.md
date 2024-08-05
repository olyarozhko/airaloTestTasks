
# Test Tasks from AIRALO

Project contains UI test Task that verifies eSim Details and REST API test tasks for creating Order and verification eSim List
 


## Instrumets

- Program language: Java (22)
- Framework: TestNG

#### UI

- Selenium WebDriver

#### API

- RestAssured
- Jackson

## Overview

All test Classs are in a `src/test/java package`. This package contains 2 child packages: `ui` and `restApi`.

Used Constans you can find in `src/main/java/utils/Constants.java`

It is possible to set basic settings in `config/config.properties`


#### config.properties File


| Parameter | Description               |
| :-------- |:------------------------- |
| `uiUrl`   |  Base url for Ui Tests. It leads to the Home Page |
| `browser` |  `chrome` (default) \ `firefox` |
| `headles` |  `true` (default) \ `false`  |
| `timeot` |   Time (in seconds) for waiting an element appearance \ disappearance |
| `firefoxBinaryFileLocation` |  location of installed Firefox browser   |
| `clientId` | Credentials for API tests   |
| `clientSecret` | Credentials for API tests   |



### UI

Page Object Model architecture design pattern is used. So Classes that represent different pages are located in `src/main/java/ui/pages` and Classes that describe modals, alerts etc. in - `src/main/java/ui/windowsDialogsAlerts`.

Each class has list of correspond elements \ element locators, constructor with initialized WebDriver, list of methods for interaction with the Page \ Window.

As far as Web Elements need some time for appearance and WebDriver could interact with the them faster methods for waiting Elements are implemented.

`src/test/java/restApi/BaseTestAPI.java` class is a contaner for driver settings and general methods that should run before each test-class / method / after class etc. This approach is implemented with help of TestNG annotations - `@BeforeClass`, `@BeforeMethod`, `@AfterClass`.
### Rest Api

Rest Api tests are implemented with help of RestAssured library which contains main methods to create / send / receive Rest calls, simplifies Serialization and Deserialization of JSON / XML.

Each Entiy used in tests is represended has own class (`src/main/java/restApi/entities`) and is described with help of Jackson annotations. They help Serialization and Deserialization of JSON. For example:
```bash
   @JsonProperty(%prop_name%) indicates exact Property Name and helps mapping with Json.
   @JsonIgnoreProperties(ignoreUnknown = true) - gives possibility to work only with 
   neccessary properties
```

General and constantly used Rest Calls and it's verification should be descibed separately. That's why `src/main/java/restApi/services` package was created. It contains `AccessToken` class with methods that checks if token exists, it is valid and method for it's creation.

`src/test/java/ui/BaseTests.java` has general method for Test classes.
## Running Tests

To run tests an environment should have installed compatible Java Version.

Each Test Class with methods annotated with `@Test` could be run. And ech such method could be ru separately.

All existing tests could be run while installing the project (Maven) or with help of `suits/testng.xml` file.

Only RestApI tests could be run via `suits/testng.xml` file.

