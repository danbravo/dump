package Lesson8;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class Testt {

    public static void charArrWriter() {
        try (FileWriter f1 = new FileWriter("a.txt");
             FileWriter f2 = new FileWriter("b.txt");
             FileWriter f3 = new FileWriter("c.txt");
             FileWriter f4 = new FileWriter("d.txt")) {

            CharArrayWriter out = new CharArrayWriter();
            out.write("my name isssss");

            out.writeTo(f1);
            out.writeTo(f2);
            out.writeTo(f3);
            out.writeTo(f4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void fileReaderRead() {
        try (FileReader fr = new FileReader("writerFile.txt")) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage());
        }
    }
    public static void fileWriterWrite() {
        try (FileWriter fw = new FileWriter("writerFile.txt")) {
            fw.write("my name is DOMDOMDOM");
        } catch (IOException e) {
            System.err.println("Error: 0"+e.getMessage());
        }
    }

    public static void readFromMultipleFile() {
        try (FileInputStream fin = new FileInputStream("abc.txt");
             FileInputStream fin2 = new FileInputStream("abc.txt");
             FileInputStream fin3 = new FileInputStream("file1.txt");
             FileInputStream fin4 = new FileInputStream("file2.txt")) {

            //creating Vector object to all the streams
            Vector v = new Vector();
            v.add("abc.txt");
            v.add("abc.txt");
            v.add("file1.txt");
            v.add("file2.txt");

            //creating enum object by calling the elements method
            Enumeration e = v.elements();
// TODO: 04.06.2016 redo this method
            //passing the enum object in the constructor
            SequenceInputStream bin = new SequenceInputStream(e);

            int i;
            while ((i=bin.read()) != -1) {
                System.out.println((char)i);
            }
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage());
        }
    }

    public static void readFromTwoFiles() {
        try (FileInputStream fin1 = new FileInputStream("file1.txt");
             FileInputStream fin2 = new FileInputStream("file2.txt")) {

            SequenceInputStream sis = new SequenceInputStream(fin1, fin2);
            int i;
            while ((i = sis.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage());
        }
    }

    public static void writeToFiles() {
        try (FileOutputStream fout1 = new FileOutputStream("file1.txt");
             FileOutputStream fout2 = new FileOutputStream("file2.txt")) {

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            String s = "someRANDOM text";
            byte[] b = s.getBytes();
            bout.write(b);
            bout.writeTo(fout1);
            bout.writeTo(fout2);

            bout.flush();
            System.out.println("Success");
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage());
        }
    }

    public void write() {
        try (FileOutputStream fout = new FileOutputStream("abc.txt")) {
            String s = "Some awesome sstringnggg";
            byte[] b = s.getBytes();
            fout.write(b);
            System.out.println("successssssss");
        } catch (IOException e) {
            System.err.println("error: "+e);
        }
    }

    public static void read() {
        try (FileInputStream fin = new FileInputStream("abc.txt")) {
            int i;
            while((i=fin.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            System.err.println("error: "+e);
        }
    }

    public static void copy() {
        try (FileInputStream fin = new FileInputStream("abc.txt");
             FileOutputStream fout = new FileOutputStream("abc.txt")) {
            int i;
            while ((i = fin.read()) != -1) {
                fout.write((byte)i);
            }
        } catch (IOException e) {
            System.err.println("Error: "+e);
        }
    }

    public static void main(String[] args) {

    }
}
