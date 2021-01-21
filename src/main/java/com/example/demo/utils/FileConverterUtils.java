package com.example.demo.utils;

import org.springframework.util.StringUtils;

import java.io.*;
import java.util.logging.Logger;

/**
 * @author : coder
 * @create 2021/1/17 21:24
 */

    public class FileConverterUtils {

        private static Logger log = Logger.getLogger(String.valueOf(FileConverterUtils.class));

        /**
         * 将csv文件转换为txt文件
         * @param csvFileName	被转换的csv文件
         * @param txtFileName		转换后的txt文件，若txt文件不存在，则该方法会按照路径新建txt文件，转换后返回该文件
         * @param encoding			CSV文件的编码
         * @return						若传入的csvFileName名或者txtFileName名为空或“”，则返回空
         * @throws IOException
         */
        public static File CsvConversionToTxt(String csvFileName, String txtFileName, String encoding) throws IOException {
            if( StringUtils.isEmpty(csvFileName) || StringUtils.isEmpty(txtFileName) ){
                return null;
            }
            BufferedReader br = null;
            BufferedWriter bw = null;
            File txtFile	=	new File(txtFileName);
            if( !txtFile.isFile() ){
                txtFile.createNewFile();
            }
            try{
                DataInputStream in = new DataInputStream(new FileInputStream(new File(csvFileName)));
                br	= new BufferedReader(new InputStreamReader(in,encoding));
                bw = new BufferedWriter(new FileWriter(txtFileName));
                String stemp;
                while ((stemp = br.readLine()) != null) {
                    bw.write(stemp);
                    bw.newLine();
                }
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                if(br != null){
                    br.close();
                }
                if(bw != null){
                    bw.flush();
                    bw.close();
                }
            }
            return txtFile;
        }

    public static void main(String[] args) throws IOException {
        FileConverterUtils.CsvConversionToTxt(
                "E:\\R\\1.csv",
                "d:\\1.txt","utf-8");
    }
    }



