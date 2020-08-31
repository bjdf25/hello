package icp;
/*
    文件上传案例的服务端：读取客户端上传的文件，保存到服务器的硬盘，给客户端回写"上传成功"

    明确：
        数据源：客户端上传的文件
        目的地:服务器的硬盘 d:\\upload\\1.gif(服务器也有专属于它的硬盘)
     操作步骤：
        1.创建一个服务端ServerSocket对象，绑定端口号8888；
        2.使用ServerSocket对象中的方法accept来接收客户端的创建的socket对象并使用其中的方法（ServerSocket并没有io流的方法，使用的是客户端socket的方法）
        3.使用socket对象中的方法getInputStream获取到网络字节输入流InputStream对象
        4.判断服务器d盘中是否存在文件upload，如果不存在则创建一个
        5.使用inputstream对象中的read方法接收数据并写在upload文件中
        6.使用网络字节输出流回传给客户端信息"上传成功"
        7.释放资源
 */

import heima.RunnableImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class FileUpload_IcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        /*
            因为客户端会不时地上传文件到服务器端，所以服务器端应一直处于监听状态，即一直运行状态
            （死循环accept方法），有一个客户端上传文件，就读取其中文件数据并保存文件
            这样一来上传文件没必要每次都先开服务器端再开客户端，直接运行客户端就能上传文件，且速度更快
         */
       while(true){
           Socket socket = serverSocket.accept();//一旦检测到有客户端创建socket对象传输文件，即调用server socket的方法accept来接收它的is和os方法
           /*
                还可以使用多线程技术，提高程序的效率
                有一个客户端上传文件，就开启一个线程，完成文件的上传
            */
           new Thread(new Runnable(){//创建新线程代码放在accept方法下面是起到一但accept方法执行就开启多线程来完成任务的目的
               @Override
               public void run() {//run方法内放线程执行的任务，在这里任务就是读到文件并保存然后回复客户端，即下面的所有代码
                try{//因为Runnable接口里的run方法没有抛出异常，所以重写方法也不能抛出异常，只能try...catch
                    InputStream is = socket.getInputStream();

                    //接下来是判断文件Upload是否存在的代码
                    File file = new File("D:\\upload");
                    if(!file.exists()){
                        file.mkdir();
                    }

                    String fileName = System.currentTimeMillis()+new Random().nextInt(10000)+ ".gif";
                    FileOutputStream fos = new FileOutputStream("D:\\upload\\"+fileName);
        /*
        如果每次写入的文件名字都一样的话，那么每次运行都只是写入相同的文件，所以应该设置一个随机数作为被写入文件的名字
         */
                    //接下来是读取信息的代码
                    int len = 0;
                    byte []bytes = new byte[1024];
                    while ((len = is.read(bytes))!= -1){
                        fos.write(bytes,0,len);

                    }
                    //接下来是回传信息的代码
                    OutputStream os = socket.getOutputStream();
                    os.write("上传成功".getBytes());
                    fos.close();
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
               }
           }).start();

       }
        //serverSocket.close();因为服务器端一直在运行，所以不用关闭服务器端的流
    }
}
