package global.com.util;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class uuid {
    public static void main(String[] args) throws IOException {
      //  List<StringBuffer> list1 = new ArrayList<StringBuffer>();
       // String files="ct";
       // list1 = Radom1(10000, 1000);
        //WriterFun(files);
        //WriterFun(files);
    }

    /**
     * 测试生成随机数
     * @param n
     * @param m
     * @return
     */
    public static List<StringBuffer> Radom1(int n, int m) {
        List<StringBuffer> list = new ArrayList<StringBuffer>();
        int count = 0;
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'};
        //  double code = Math.random() * (n - m) + m;
        for (int j = 0; j < 20; j++) {
            for (int y = 0; y < letters.length; y++) {
                double code = Math.random() * (10000 - 1000) + 1000;
                StringBuffer pwd = new StringBuffer("");
                pwd.append(letters[y]);
                Integer x = (int) code;
                pwd.append(x);
                list.add(pwd);
            }
        }
        List newList = list.stream().distinct().collect(Collectors.toList());
        //System.out.println("java8新特性stream去重:"+newList);
        return list;
    }

    /**
     * 获取编号
     * @throws IOException
     */

    public static void WriterFun (String files,Integer numbers) throws IOException {
        try {

            FileSystemView fsv = FileSystemView.getFileSystemView();
            File com=fsv.getHomeDirectory(); //这便是读取桌面路径的方法了
            List<StringBuffer> list = new ArrayList<StringBuffer>();
            //获得路径
            String filepath = "C:\\Users\\zhouping\\Desktop\\file.txt";
            File file = new File(com+"\\"+files+".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter(file));
            char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                    'W', 'X', 'Y', 'Z'};
            for (int j = 0; j < numbers; j++) {
                for (int y = 0; y < letters.length; y++) {
                    StringBuffer pwd = new StringBuffer("");
                    pwd.append(letters[y]);
                    double code = Math.random() * (10000 - 1000) + 1000;
                    Integer x = (int) code;
                    pwd.append(x);
                    list.add(pwd);
                }
            }
            Set set1 = new HashSet();
            List newList1 = new ArrayList();
            for (StringBuffer integer : list) {
                if (set1.add(integer)) {
                    newList1.add(integer);
                }
             }
            for (Object stringBuffer : newList1) {
            bw.write(stringBuffer.toString());
            bw.write("\r\n");
            }
            bw.newLine();
            bw.close();
            }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取uuid
     * @throws IOException
     */
    public static void Writeruuid (String files,Integer numbers) throws IOException {
        try {
            FileSystemView fsv = FileSystemView.getFileSystemView();
            File com=fsv.getHomeDirectory(); //这便是读取桌面路径的方法了
        List<String> list = new ArrayList<String>();
        //获得路径
        String filepath ="C:\\Users\\zhouping\\Desktop\\uuid.txt";
            File file = new File(com+"\\"+files+"UUID.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bw = null;
        bw = new BufferedWriter(new FileWriter(file));
        int number=numbers*26;
        for (int x = 0; x < number; x++) {
            String uuid = UUID.randomUUID().toString();
            //System.out.println(uuid);
            list.add(uuid);
        }
        Set set1 = new HashSet();
        List newList1 = new ArrayList();
        for (String integer : list) {
            if(set1.add(integer)) {
                newList1.add(integer);
            }
        }
        for (Object stringBuffer:newList1) {
            bw.write(stringBuffer.toString());
            bw.write("\r\n");
        }
        bw.newLine();
        bw.close();
        }catch (IOException e) {
        e.printStackTrace();}
    }
}
