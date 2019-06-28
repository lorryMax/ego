package com.sxt;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class TestFast {

    static {
        try {
            //初始化静态资源
            ClientGlobal.init("fastdfs/fastdfs.conf");
            String s = ClientGlobal.configInfo();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            uploadFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     *
     * @throws Exception
     */
    public static void uploadFile() throws Exception {
        //获取trakerClient
        TrackerClient trackerClient = new TrackerClient();
        //自动配置
        TrackerServer connection = trackerClient.getConnection();
        //获取storagerClient
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(connection, storageServer);

        String[] strings = storageClient.upload_file("本地文件地址", "后缀", null);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     *
     */
    public static void dowload() {
        //连接TrackerClient
        TrackerClient trackerClient = new TrackerClient();
//        自动配置文件
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
            //获取storageClient
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            //下载文件
            int jpg = storageClient.download_file("a.jpg", "1.jpg", "d://text/");
            System.out.println(jpg);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
