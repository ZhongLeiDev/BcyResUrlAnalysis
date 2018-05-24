package common.linkshandle;

import javax.net.ssl.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * Created by ZhongLeiDev at 2018/5/24
 */
public class WebLinksCatcher {

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }


    /**
     * 以Byte数组的形式获取Get操作结果，针对 HTTPS 协议
     *
     * @param url 用Get方法去访问的链接
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     */
    private static byte[] httpsGetByte(String url) {

        SSLContext sc = null;
        URL console = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
            console = new URL(url);
        } catch (NoSuchAlgorithmException | KeyManagementException | MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
            conn.setDoInput(true);
            conn.setConnectTimeout(40000);
            conn.setReadTimeout(40000);
            InputStream is = conn.getInputStream();
            if (is != null) {
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }
                is.close();
                return outStream.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * 以Byte数组的形式获取Get操作结果,针对 HTTP 协议
     *
     * @param url 用Get方法访问去访问的链接
     * @return
     * @throws IOException
     */
    private static byte[] httpGetByte(String url) throws IOException {
        URL console = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) console.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
        conn.setDoInput(true);
        conn.setConnectTimeout(40000);
        conn.setReadTimeout(40000);
        InputStream is = conn.getInputStream();
        if (is != null) {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            is.close();
            return outStream.toByteArray();
        }
        return null;
    }

    /**
     * 获取对应 Url 的访问结果，并以 Charset 的编码格式编码返回 String
     * 针对 HTTP 协议的 Url 链接
     * @param url   带解析的 Url
     * @param charset   编码格式
     * @return  编码后的 String 结果
     */
    public static String getResponseFromHttpUrl(String url, String charset) {
        String src = "";
        try {
            byte[] b = httpGetByte(url);
            src = new String(b,charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return src;
    }

    /**
     * 获取对应 Url 的访问结果，并以 Charset 的编码格式编码返回 String
     * 针对 HTTPS 协议的 Url 链接
     * @param url   待解析的 Url
     * @param charset   编码格式
     * @return  编码后的 String 结果
     */
    public static String getResponseFromHttpsUrl(String url, String charset) {
        String src = "";
        try {
            byte[] b = httpsGetByte(url);
            src = new String(b,charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return src;
    }

}