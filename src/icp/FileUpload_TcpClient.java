package icp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
    题目：
        文件上传案例的客户端：读取本地文件，上传到服务器然后再读取服务器回写的数据
    明确：
        数据源：
            d:\\a.gif
        目的地：服务器
     实现步骤：
        1.创建一个本地字节输入流选择要上传的文件
        2.创建一个客户端Socket对象，用对象里的方法创建一个网络输出流对象，对象构造参数里绑定服务器的ip地址和端口号
        3.使用本地字节输入流对象中的方法读取要上传的文件
        4.把文件上传到服务器
        5.用socket对象里的方法创建一个网络输入流对象接收服务器回传的信息
        6.用网络输入流对象里的方法read接收回传信息
        7.释放资源（一个是自己创建的本地输入流对象，一个是socket对象）
     总结：
        客户端和服务器端文件的传输依赖于socket类
        os和is流都是socket的方法创建出来的流对象，只作用于客户端和服务器端数据的传输
        而客户端和服务器端对于硬盘文件的读写都需要重新new 字节流输出输入对象fis和fos
 */
public class FileUpload_TcpClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\a.gif");
        Socket socket = new Socket("127.0.0.1",8888);//PS:127.0.0.1为本机IP地址，这里输入的IP地址为上传文件目的地，只要上传文件目的地的端口和本机端口相同即可进行传输交流
        OutputStream os = socket.getOutputStream();
        int len = 0;
        byte []bytes = new byte[1024];
        while ((len = fis.read(bytes)) !=-1){
            os.write(bytes,0,len);//这一步已经把文件上传到服务器了
        }
        /*

            客户端上传文件以后执行一直没有结束，且服务器端的回复信息也没有打印到控制台上
            是因为os流一直读文件，读到-1的时候不会读取-1，就会陷入阻塞状态，需要用到socket
            对象里的方法 shutdownOutput来关闭os流即可
         */
        socket.shutdownOutput();
        //接下来是接收服务器回传信息的代码
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes))!= -1){//注意：变量len和bytes里都是存放的a.gif里的数据，现在数据已经上传到服务器了，所以变量
                                            //len和数组bytes就可以改变数据了，就可以存放接收的信息的字节了
            System.out.println(new String(bytes,0,len));//现在bytes数组里存放的都是接收的信息的字节，用new String方法变为汉字
        }
        fis.close();
        socket.close();
    }
}
