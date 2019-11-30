package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class ReadLocalFile {

    public static void main(String[] args) throws IOException {

        /*String str1 = readByLine("D:\\Java\\ReadLocalFile\\src\\com\\company\\cadao.txt");
        System.out.println(str1);

        String str2 = readUTF8ByLine("D:\\Java\\ReadLocalFile\\src\\com\\company\\cadao.txt");
        System.out.println(str2);

        String str3 = readByLine("D:\\Java\\ReadLocalFile\\src\\com\\company\\cadao.txt");
        System.out.println(str3);

        String str4 = readBuffer("D:\\Java\\ReadLocalFile\\src\\com\\company\\cadao.txt");
        System.out.println(str4);

        String str5 = readOnlineResource("https://raw.githubusercontent.com/nam-long/learning-java/master/resources/ca-dao.txt");
        System.out.println(str5);

        String s = "Wellcome to java";
        byte b[] = s.getBytes();
        saveFile("D:\\Java\\ReadLocalFile\\src\\com\\company\\file.txt", b);

        String imageUrl = "https://daotaosathachag.com/wp-content/uploads/2018/07/hinh-anh-de-thuong-9.jpg";
        String destinationFile = "image.jpg";
        saveImage(imageUrl,destinationFile);
*/
        String strUrl = "https://github.com/nam-long/learning-java/blob/master/resources/cadao.txt";
        String fileName = "download.txt";
        downloadResource(strUrl, fileName);

    }

    public static String read(String filename) throws IOException {

        String str = "";

        InputStream is = new FileInputStream(filename);
        int c;
        while ((c = is.read()) != -1) {
            str += (char) c;
        }

        is.close();
        return str;
    }

    public static String readUTF8(String filename) throws IOException {

        String str = "";

        Reader is = new FileReader(filename);
        int c;
        while ((c = is.read()) != -1) {
            str += (char) c;
        }

        is.close();
        return str;
    }

    public static String readByLine(String filename) throws IOException {

        String str = "";

        InputStream is = new FileInputStream(filename);
        DataInputStream dis = new DataInputStream(is);
        String line;
        while ((line = dis.readLine()) != null) {
            str += line + '\n';
        }
        is.close();

        return str;
    }

    public static String readUTF8ByLine(String filename) throws IOException {

        String str = "";

        Reader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            str += line + '\n';
        }
        reader.close();

        return str;
    }

    public static String readBuffer(String filename) throws IOException {
        String str = "";

        byte[] buffer = new byte[10];

        InputStream is = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int count;
        while ((count = bis.read(buffer)) != -1) {
            baos.write(buffer, 0, count);
        }
        str = new String(baos.toByteArray());
        baos.close();
        is.close();

        return str;
    }


    // https://raw.githubusercontent.com/nam-long/learning-java/master/resources/ca-dao.txt
    public static String readOnlineResource(String strUrl) throws IOException {

        String str = null;

        URL url = new URL(strUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

        int responseCode = conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[100];
            int count;
            while ((count = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            str = new String(baos.toByteArray());

            is.close();
        }

        return str;


    }

    public static void saveFile(String filename, byte[] data) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(data);
        fos.close();
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }

    public static void downloadResource(String strUrl, String filename) throws IOException{
        String str = null;

        URL url = new URL(strUrl);
        InputStream is = url.openStream();
        BufferedInputStream bis = new BufferedInputStream(is);

        byte[] buffer = new byte[100];
        int count; //so byte doc vao buffer
        FileOutputStream fos = new FileOutputStream(filename);
        while ((count = bis.read(buffer)) != -1){
            //Ghi buffer vao fileOuputStream
            fos.write(buffer,0, count);

        }
        fos.close();
        is.close();
    }




}