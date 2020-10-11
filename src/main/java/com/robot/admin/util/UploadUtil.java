package com.robot.admin.util;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.UUID;

@Slf4j
public class UploadUtil {

    /*七牛云上传*/

    public static String upload(InputStream stream, String accessKey,
                                String secretKey, String bucket, String resourceHost) {
        // 构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone2());
        // 其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        String key= UUID.randomUUID().toString().replace("-","");
        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            Response response = uploadManager.put(stream, key, upToken, null, null);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            /*retMap.put("url", "上传的连接" + putRet.key)*/
            ;
            return resourceHost + putRet.key;
        } catch (Exception ex) {
            log.error("upload error", ex);
        }
        return null;
    }
}
