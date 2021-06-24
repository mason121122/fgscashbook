package com.fgs.fgscashbook;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class CsvDemo {

    public static void main(String[] args) {
        char separator = ',';
        CsvReader reader = null;
//        List<String[]> dataList = new ArrayList<>();
        try {
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            reader = new CsvReader("E:\\商户门店映射表.csv", separator, Charset.forName("gbk"));

            // 读取表头
            reader.readHeaders();
//            String[] headArray = reader.getHeaders();//获取标题

//            reader.readRecord();
            // 逐条读取记录，直至读完
            while (reader.readRecord()) {
                // 读一整行
                String record = reader.getRawRecord().trim();

                String[] data = record.split(",");
                if (data.length == 0) {
                    System.out.println("空");
                    continue;
                }
                System.out.println(data[0]);
                System.out.println(data[1]);
                System.out.println(data[2]);
                System.out.println(data[3]);
                System.out.println(data[4]);
                System.out.println(data[5]);
//                 读这行的第一列
//                System.out.println(reader.get("广场名称"));
                // 读这行的第二列
//                System.out.println(reader.getRawRecord());
//                if(reader.getColumnCount() == 0){
//                    continue;
//                }
//                if(reader.getColumnCount()!=7){
//                    System.out.println("文件不完整");
//                }else{
//                    String str = reader.getRawRecord();
//                    String[] sp = str.split(",");
//                    System.out.println("****************************************");
//                    System.out.println(sp[0]);
//                    System.out.println(sp[1]);
//                    System.out.println(sp[2]);
//                    System.out.println(sp[3]);
//                    System.out.println(sp[4]);
//                    System.out.println("****************************************");
//                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                reader.close();
            }
        }
    }

    public void newFile() {
        char separator = ',';
        CsvWriter writer = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("E:\\CsvCreater.csv", true);
            String[] q = {"广场id", "广场名称", "对接平台", "商圈id", "商圈名称"};
            String[] w = {"111", "广场测试名称", "1", "12333", "商圈测试"};
            String[] e = {"222", "广场测试名称2", "2", "23455", "商圈测试2"};
            String[] r = {"222"};
            writer = new CsvWriter(out, separator, Charset.forName("GBK"));
            writer.writeRecord(q);
            writer.writeRecord(w);
            writer.writeRecord(r);
            writer.writeRecord(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
