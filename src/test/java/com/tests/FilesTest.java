package com.tests;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class FilesTest {

    // there is a simpler method below
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

    // there is a simpler method at the end of this class
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

    @Test
    public void writingFilesSimple() throws IOException {

        // 1. create temp file
        File outputFile = new File("src/main/java/com/support/", "writer_file_name.txt");

        // 2. file writer
        FileWriter writer = new FileWriter(outputFile);

        // write in the file - we need to add the line breaks manually and we don't use buffer
        writer.write("Print my first line \n");
        writer.write("Second text \n");
        writer.write("APPENDING THIS TEXT"); // adds a text to an existing file

        writer.close();
        outputFile.deleteOnExit(); // uncomment this to see the file
    }

    @Test
    public void writingFilesWithBuffer() throws IOException {

        // 1. create temp file
        File outputFile = new File("src/main/java/com/support/", "file_name.txt");

        // 2. file writer
        FileWriter writer = new FileWriter(outputFile);

        // 3. file buffer - write by buffer (for efficiency) - this step could be removed
        BufferedWriter buffer = new BufferedWriter(writer);

        // 4. print writer - write readable lines - we could pass "writer" instead of "buffer" as a parameter if we don't want to use buffer
        PrintWriter print = new PrintWriter(buffer);

        print.println("Print my first line");
        print.println("Second line");
        print.print("APPENDING THIS TEXT"); // adds a text to an existing file

        print.close();
        outputFile.deleteOnExit(); // uncomment this to see the file
    }

    @Test
    public void simpleRead() throws IOException {

        // 1. create or get the file
        File inputFile = writeTheTestDateFile();

        // 2. crete the file reader
        FileReader reader = new FileReader(inputFile);

        // 3. create buffer reader - to read efficiently (blocks of bytes)
        BufferedReader buffer = new BufferedReader(reader);

        try {
            String line;
            while ( (line = buffer.readLine() ) != null) { // when the line is NULL, it reached the end of the file
                System.out.println(line);
            }
        } finally {
            reader.close();
        }
    }

    @Test
    public void listFilesFromDirectory(){

        // location will be the temp folder
        String location = System.getProperty("java.io.tmpdir");
        File tempFolder = new File(location);

        String[] fileList = tempFolder.list();
        for (String item:
             fileList) {
            System.out.println(item);
        }
    }

    @Test
    public void listFilesCheckAttributes(){
        // location will be the temp folder. It could also be String location = "src/main/java/com/support/";
        String location = System.getProperty("java.io.tmpdir");
        File tempFolder = new File(location);

        // note that now we use File[]
        File[] fileList = tempFolder.listFiles();
        for (File item:
                fileList) {
            if(item.isDirectory()){System.out.println(item.getName() + ">>> Is directory");}
            if(item.isFile()){System.out.println(item.getName() + ">>> Is File");}
            /*
            We could also check the methods:
            canRead - true if the file is readable
            canWrite - true if the file is writable
            canExecute true if the file is executable
            lastModified - the last modified date as a long
            setExecutable
            setReadable
            setWritable
            setReadOnly
            setLastModified
             */
        }
    }

    @Test
    public void moveCopyMethods() throws IOException {

        // create a file
        File outputFile = new File("src/main/java/com/support/", "writer_file_name.txt");
        FileWriter writer = new FileWriter(outputFile);
        writer.write("Print my first line \n");
        writer.close();

        // <to do: copy and move>

    }

}
