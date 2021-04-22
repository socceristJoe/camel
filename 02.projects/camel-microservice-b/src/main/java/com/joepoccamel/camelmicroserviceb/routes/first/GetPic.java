package com.joepoccamel.camelmicroserviceb.routes.first;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GetPic {
    private static final Integer ONE = 1;

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        /* 读取数据 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("files/javabean/link.txt")),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                URL url = new URL(lineTxt);
                java.io.BufferedInputStream bis = new BufferedInputStream(url.openStream());
                byte[] bytes = new byte[100];
                OutputStream bos = new FileOutputStream(new File("files/javabean/pearson/" + lineTxt));
                int len;
                while ( (len = bis.read(bytes)) > 0) {
                    bos.write(bytes, 0, len);
                }
                bis.close();
                bos.flush();
                bos.close();


//                for (String name : names) {
//                    if (map.keySet().contains(name)) {
//                        map.put(name, (map.get(name) + ONE));
//                    } else {
//                        map.put(name, ONE);
//                    }
//                }
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }

    }

    private void getHttps(URL url) throws Exception {
        HttpsURLConnection httpURLConnection = null;
        try {
            // 1. 得到访问地址的URL

            // 2. 得到网络访问对象java.net.HttpURLConnection
            httpURLConnection = (HttpsURLConnection) url.openConnection();
            /* 3. 设置请求参数（过期时间，输入、输出流、访问方式），以流的形式进行连接 */
            // 设置是否向HttpURLConnection输出
            httpURLConnection.setDoOutput(false);
            // 设置是否从httpUrlConnection读入
            httpURLConnection.setDoInput(true);
            // 设置请求方式　默认为GET
            httpURLConnection.setRequestMethod("GET");
            // 设置是否使用缓存
            httpURLConnection.setUseCaches(false);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            httpURLConnection.setInstanceFollowRedirects(true);
            // 设置连接超时时间
            httpURLConnection.setConnectTimeout(3000);
            // 设置读取返回超时时间
            httpURLConnection.setReadTimeout(3000);
            // 连接
            httpURLConnection.connect();
            // 4. 得到响应状态码的返回值 responseCode
            int code = httpURLConnection.getResponseCode();
            // 5. 如果返回值正常，数据在网络中是以流的形式得到服务端返回的数据
            String msg = "";
            if (code == 200) { // 正常响应
                // 从流中读取响应信息
                File file = File.createTempFile(new Date().getTime() + "", ".png");
                OutputStream os = new FileOutputStream(file);

                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                while ((bytesRead = httpURLConnection.getInputStream().read(buffer, 0, 8192)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }

                httpURLConnection.getInputStream().close();
                os.close();

            }else{
                // 显示响应结果
                // 从流中读取响应信息
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
                String line = null;
                while ((line = reader.readLine()) != null) { // 循环从流中读取
                    msg += line;
                }
                reader.close(); // 关闭流

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally {
            // 6. 断开连接，释放资源
            if (null != httpURLConnection){
                try {
                    httpURLConnection.disconnect();
                }catch (Exception e){
                    e.printStackTrace();
                    throw e;
                }
            }
        }
    }
}
