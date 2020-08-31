package heima;
/*
    练习：转换文件编码
        将GBK编码的文本文件，转换为UTF-8的文本文件。
     字节输入流：FileInputStream 字符输入流：FileReader 缓冲流:BufferedInputStream  转换流：InputReader
     分析：
        1.创建InputStreamReader对象，构造方法中传递字节输入流和指定的编码表名称GBK。
        2.创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称UTF-8。
        3.使用InputStreamReader对象中的方法read读取文件。
        4.使用OutputSteamWriter对象中的方法write，把读取的文件写入到指定文件中。
        5.释放资源
      注意：缓冲流Buffered和转换流InputStreamReader/Writer都需要在构造方法中创建字节流的对象。
 */



import java.io.*;

public class DemoTransfor {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\IdeaProjects\\hello\\src\\heima\\b.txt"), "GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\IdeaProjects\\hello\\src\\heima\\c.txt"),"UTF-8");

        int len = 0;
        while ((len = isr.read()) != -1){
            osw.write(len);
        }
        osw.close();
        isr.close();
    }
}
