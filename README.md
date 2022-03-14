**Fabio's Java and Selenium notes**

**New Maven Project**

Add maven compiler plugin with java version configuration:

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
    
Maven surefire plugin:
    
        <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>3.0.0-M5</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
    
    
**Strings** 

// get the first character of string

    char c = text.charAt(0);
    
// get the last character of a string

    Integer lastLatterIndex = text.length() - 1;
    char c = text.charAt(lastLatterIndex);
    System.out.println("Last letter is: " + c);
    
**HashMap**

Create and print HashMap

    HashMap<Integer,String> map = new HashMap<>();
    map.put(01, "Apartment");
    map.put(02, "House");
    System.out.println(map);
    map.forEach((k, v) -> System.out.println("Key:"+k + " / Value:"+v));

**Selenium**

Dependency:

    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.1.2</version>
    </dependency>

Create (web)driver:

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver","/Users/fabio/Documents/Chromedriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

Locators:

    WebElement userField = driver.findElement(By.id("user-name"));
    WebElement passField = driver.findElement(By.id("password"));
    WebElement submit = driver.findElement(By.xpath("//*[@class='submit-button btn_action']"));

**Array and ArrayList**

Convert array to string:

    String converted = myList.toString();

Convert string to array:

    String[] myArray = text.split(" ");

Initialize arraylist with Arrays.asList():

    List<Integer> myarray = new ArrayList<>(Arrays.asList(1,5,7,8));

Set value to array list position:

    productslist.set(2, "nothing");

Read specific list element:

    list.get(0);


**Files**

Read a file and add text to a string:

    FileReader fr = new FileReader(path);
    BufferedReader br = new BufferedReader(fr);
    String lines;
    while ((lines = br.readLine())!=null) {
    text = text + lines;
    }

Read a specific line of a csv file and add content to an array:

    String [] userDetailsArray = null;
    FileReader myReader = new FileReader("src/main/java/supportMethods/data.csv");
    BufferedReader myBufferedReader = new BufferedReader(myReader);
    String lineContent  = myBufferedReader.lines().skip(userIndex).findFirst().get();
    userDetailsArray = lineContent.split(",");

