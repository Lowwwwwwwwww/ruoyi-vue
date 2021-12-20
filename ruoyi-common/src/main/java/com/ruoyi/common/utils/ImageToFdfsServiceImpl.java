package com.ruoyi.common.utils;



import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageToFdfsServiceImpl {

    @Autowired
    private ThumbImageConfig thumbImageConfig;
    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    public  Map<String, Object> saveImageToFdfs(String image) throws IOException {
        // 上传并且生成缩略图 1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他

        //上传图片base64编码格式到fastDFS
        byte[] byteArr = PicUtil.stringToInputStream(image);
        ByteArrayInputStream stream = new ByteArrayInputStream(byteArr);

        // 1\上传并且生成缩略图 1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他
//        StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(stream, byteArr.length, "jpg", null);

        //2\上传不生成缩略图
        StorePath storePath = fastFileStorageClient.uploadFile(stream, byteArr.length, "jpg", null);

//        3\直接上传图片
//        StorePath storePath = this.fastFileStorageClient.uploadImageAndCrtThumbImage(image.getInputStream(), image.getSize(), "jpg", null);


        Map<String, Object> resultMap = new HashMap<>();

        //交换路径  注意!!!!!
//        resultMap.put("fullPath", thumbImageConfig.getThumbImagePath(storePath.getFullPath()));// 获取图像路径
        resultMap.put("thumbFullPath", storePath.getFullPath());// 获取缩略图路径

        return resultMap;
    }
}
