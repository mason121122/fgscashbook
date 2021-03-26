package com.fgs.fgscashbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class test03 {
    /**
     * CSV文件生成方法
     *
     * @param head       文件头
     * @param dataList   数据列表
     * @param outPutPath 文件输出路径
     * @param filename   文件名
     * @return
     */
    public static File createCSVFile(List<Object> head, List<List<Object>> dataList, String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(outPutPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "GB2312"), 1024);
            // 写入文件头部
            writeRow(head, csvWtriter);

            // 写入文件内容
            for (List<Object> row : dataList) {
                writeRow(row, csvWtriter);
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    /**
     * 写一行数据方法
     *
     * @param row
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
        // 写入文件头部
        for (Object data : row) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append("\"").append(data).append("\",").toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
    }


    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        List<Object> exportData = new ArrayList<Object>();
        exportData.add("广场id");
        exportData.add("广场名称");
        exportData.add("门店id");
        exportData.add("门店名称");
        exportData.add("昨日新增注册用户数");
        exportData.add("昨日新增微信授权人数");
        List<List<Object>> datalist = new ArrayList<List<Object>>();
        List<Object> data = new ArrayList<Object>();
        data.add("111");
        data.add("222");
        data.add("222");
        data.add("333");
        data.add("333");
        data.add("333");
        List<Object> data1 = new ArrayList<Object>();
        data1.add("444");
        data1.add("555");
        data1.add("666");
        data1.add("444");
        data1.add("555");
        data1.add("666");
        datalist.add(data);
        datalist.add(data1);
        String path = "D:\\";
        String fileName = "文件导出";

        File file = new test03().createCSVFile(exportData, datalist, path, fileName);
//        String fileName2 = file.getName();
//        System.out.println("文件名称：" + fileName2);
    }
}
