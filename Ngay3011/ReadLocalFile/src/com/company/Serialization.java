package com.company;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException {

        Student student = new Student("A", 20, "TP HCM");

        student.save("D:\\student.txt");

        student.load("D:\\student.txt");

        System.out.println(student);
    }

}

    class student {
        private String mName;
        private int mAge;
        private String mAddress;

        public student(String name, int age, String address) {
            mName = name;
            mAge = age;
            mAddress = address;
        }

        public void save(String filemName) throws IOException {
            FileOutputStream fos = new FileOutputStream(filemName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);

            fos.close();
        }

        public student load(String filemName) throws IOException, ClassNotFoundException {
            student st;
            FileInputStream fis = new FileInputStream(filemName);

            ObjectInputStream ois = new ObjectInputStream(fis);
            st = (student) ois.readObject();
            fis.close();

            return st;
        }
        @Override
        public String toString() {
            return "Student{" +
                    "mName='" + mName + '\'' +
                    ", mAge=" + mAge +
                    ", mAddress='" + mAddress + '\'' +
                    '}';
        }
    }

