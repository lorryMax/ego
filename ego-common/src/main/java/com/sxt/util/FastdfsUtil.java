package com.sxt.util;


import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

/**
 * 文件上传工具类
 */
public class FastdfsUtil {


    private static final StorageServer storageServer = null;

    private static TrackerClient trackerClient = null;

    private static StorageClient storageClient = null;

    static {
//        初始化文件
        try {
            ClientGlobal.init("fastdfs/fastdfs.conf");
            //获取连接
            trackerClient = new TrackerClient();
//        初始化
            TrackerServer connection = trackerClient.getConnection();
            //StorageClient
            storageClient = new StorageClient(connection, storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }
    public static String uploadFile(byte[] bytes, String rex) {
        String  imgUrl=null;
        try {
            String[] s = storageClient.upload_file(bytes, rex, null);
            //拼接地址g1/地址
            imgUrl=s[0]+"/"+s[1];
            System.out.println(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return imgUrl;
    }
}
