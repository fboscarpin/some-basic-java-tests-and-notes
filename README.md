**Fabio's Learning project**

**New Maven Project**

Add maven compiler plugin:

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
    
Alternatively, add mave surefire plugin:
    
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

// get first character of string

        char c = text.charAt(0);
    
// get the last character of a string

        Integer lastLatterIndex = text.length() - 1;
        char c = text.charAt(lastLatterIndex);
        System.out.println("Last letter is: " + c);
