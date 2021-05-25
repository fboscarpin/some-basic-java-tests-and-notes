package com.tests;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class FilesTest {

    private File writeTheTestDateFile() throws IOException {
        File outputFile = File.createTempFile("forReading", null); // null means .tmp / the result is something like forReading16535777254649642741.tmp
        PrintWriter print = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(outputFile)
                )
        );

        for (int lineNumber = 1; lineNumber < 6; lineNumber++) {
            print.println("line " + lineNumber);
        }

        print.close();
        return outputFile;
    }

    @Test
    public void outputFileToSystemOutWithBufferedReader() throws IOException {

        File inputFile = writeTheTestDateFile();
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            reader.close();
        }
    }

    @Test
    public void createTmpFile() throws IOException {
        // creates the file in the users tmp directory
        File firstFile = File.createTempFile("myPrefix", null, new File(System.getProperty("user.dir")));
        // creates the file in a specific project folder
        File secondFile = File.createTempFile("myPrefix", null, new File("src/main/java/com/support"));
        secondFile.delete();
    }

    @Test
    public void listRootsMethod() throws IOException {
        File[] arrayFiles = File.listRoots();
    }

    @Test
    public void basicFileCreationAndExistsMethod() throws IOException {

        // this will create a representation of a file
        //File myFile = new File("src/main/java/com/support/myfile.txt"); // this would also work
        File myFile = new File("src/main/java/com/support/", "file_name.txt");
        myFile.deleteOnExit();

        // now we really create the physical file
        if(myFile.exists()) myFile.delete();

        Assert.assertFalse(myFile.exists()); // check that the above command does not create the physical file

        myFile.createNewFile();
        Assert.assertTrue(myFile.exists());

        //delete the file manually if needed. It's not needed here because we used deleteOnExist() previously
//        myFile.delete();
//        Assert.assertFalse(myFile.exists());
    }

    @Test
    public void getMethods() throws IOException {

        // this will create a representation of a file
        //File myFile = new File("src/main/java/com/support/myfile.txt"); // this would also work
        File myFile = new File("src/main/java/com/support/", "file_name.txt");
        myFile.deleteOnExit();

        System.out.println(myFile.getPath());
        System.out.println(myFile.getAbsolutePath());
        System.out.println(myFile.getCanonicalPath());
        Assert.assertTrue(myFile.getName().startsWith("file"));
        Assert.assertTrue(myFile.getParent().endsWith("support"));
    }

    @Test
    public void creatingDirectoriesTemp() throws IOException {

        String tempDir = System.getProperty("java.io.tmpdir"); // get temp folder's name
        String dirStructure = tempDir + System.currentTimeMillis() + File.separator + System.currentTimeMillis();
        File completePath = new File(dirStructure);

        System.out.println(dirStructure);

        completePath.mkdirs();
//        completePath.mkdir(); this will not work because it does not create sub-directories
    }

    @Test
    public void creatingDirectories() throws IOException {

        String tempDir = "src/main/java/com/support/";
        String dirStructure = tempDir + System.currentTimeMillis() + File.separator + System.currentTimeMillis(); // this is a directory, not a file
        File completePath = new File(dirStructure);

        System.out.println(dirStructure);

        completePath.mkdirs();
        // completePath.mkdir(); // this will not work (though the test passes) because it does not create sub-directories
        completePath.deleteOnExit(); // this will delete the sub-folder (last level)

        // create with mkdir()

        String tempDir2 = "src/main/java/com/support/";
        String dirStructure2 = tempDir2 + System.currentTimeMillis(); // this is a directory, not a file
        File completePath2 = new File(dirStructure2);

        System.out.println(completePath2);
        completePath2.mkdir();
        completePath2.exists();
        completePath2.deleteOnExit(); // works to delete the folder (unique) you created
    }



}
