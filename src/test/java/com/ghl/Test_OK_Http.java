package com.ghl;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class Test_OK_Http {

    /**
     * 发送get请求
     */
    @Test
    public void test_get() throws IOException {
        //发送请求对象
        OkHttpClient client = new OkHttpClient();
        //请求数据
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();
        //发送请求
        Response response = client.newCall(request).execute();
        //打印相应数据
        if (response.isSuccessful()) {
            System.out.println("返回结果:" + response.body().string());
        }
        response.close();

    }

    @Test
    public void test_post() throws IOException {
        OkHttpClient client = new OkHttpClient();

        String data = "{\"goods_id\":11,\"stock\":200}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), data);

        Request request = new Request.Builder()
                .url("http://shop-xo.hctestedu.com/index.php?s=api/cart/save&application=app&application_client_type=weixin&token=eaa0dacd17c4c20802ef8a00f63dceca")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println("返回结果:" + response.body().string());
        }
    }

    @Test
    public void test_upload() throws IOException {
        OkHttpClient client = new OkHttpClient();

        //String data = "{\"goods_id\":11,\"stock\":200}";
        File file = new File("E:\\wlhy-service\\vehicle_type_info.xlsx");
        //RequestBody requestBody = RequestBody.create(MediaType.parse("form-data"), file);
        //MediaType.parse("form-data")
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("file","vehicle_type_info",RequestBody.create(file,MediaType.parse("form-data")));

//        Request request = new Request.Builder()
//                .url("http://shop-xo.hctestedu.com/index.php?s=api/cart/save&application=app&application_client_type=weixin&token=eaa0dacd17c4c20802ef8a00f63dceca")
//                .post(new RequestBody.create(file,MediaType.parse("form-data")))
//                .build();

//        Response response = client.newCall(request).execute();
//        if (response.isSuccessful()) {
//            System.out.println("返回结果:" + response.body().string());
//        }
    }
}
