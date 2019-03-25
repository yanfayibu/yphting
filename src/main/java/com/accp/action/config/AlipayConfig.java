package com.accp.action.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500592576";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC0ivMK59XpEKQIARq6W5SLAUZIfwnwiHaPmLOKz9et9ESXkc/ZTcurI3LDC6GCUdGXORvT/zRCcPVkeS8y9uejHuY0P1isZu8A4zrAI3f7DdhjxJb9IRgkCKgTT1zn1MmsknPDw9Fw8+4Wl/wZgWaW0/aIRreIEcPgeMJRFeO25Gl3O7mac8RGk4srMvy65Sr+XKxYay900W1TQIGRMTlm2XD/ihnScmfXqOo+9DOC1H1ZxUU2HYlP8Z6XzPVOwsJ7j+gYF65Kiucn2/DqoPQoKx8637C3scgl0ddMXkFMnv8mh5hPMzz9dhb/37BlhzA7e8g6G7JZwUg+DWX45/oBAgMBAAECggEBAKnDXfWLOaEFfLfqEe/Z3Ts335abngUGzDUKKQkFlpCDd1vuR7rVZAVwN6EfdqbLuICxunEFL2aqQJRRPwh1EipYC65lQkQaJfJ3t+6ja1YuFqL5X+B1FfYMDb7aiUmU1G3o5+HUZ0QGmoG0N+DjxEte1BogJMNVsRGJe24zXwPA/aPK/njH6f+pf5S67dynfCEhC4nHC9QCqsgXSSBG5XOw9cyNGlsyl19q6G9xt4Yc2iU0B03BT+uRkaQvTZzkExmbgcf5Q7KlJ/RvbrZZalypR5K2bAm1oIrvOpfLX5+Gboq2ZIsXxqQtGNXfU6UNKAkZn38L23x2wItQZF/rGuECgYEA6UHOVy/4G6ClCu68bNroojlp1YkSy1VzifyFqsic2Hc71QLYjV14Su7YpQi5qFSv4Uc8YZr7RK4vnrSFM8v9N3EyH2SjfHl/ARHwUpr6nYO1FwFJ4xyG0z2p+7MESSGAiMHL+lufO6/6lZbzroyZ7QXMA/5XU3JrAu37xPCYry8CgYEAxiVfarVulhr/86ofz55+YB8wqvZ75Q6XBZ/m72ldWlhPCdXMRe79sQYuybSKm7K6Syw7ZwFKwaufP6O7vAKD8IvRW2ntlRpbUReEpaG8miX1REuKLS+dxSXFqYUN1UtMIj2hIfuz1fuLq2exC00CWEmFMQnE/dwPulIGmMGGHc8CgYEAy+IdPdBMCboNCNVMFcnydXnBrEg4CUsTxpTXMURQ9FSkE7h9GHOO5dCHxRkvTpdXdI4TlS0mXA30yb/4fiHbn05uBUquK+r2vDS13z5fuLaa3xTdRIp2vsWzgrIjGNkTxHXAmYDkWgOkAIUFUpjLIoZioUr7gZENQG5MFwRGMTkCgYAlpQYKvOuEox6LiX+/ryntUx+o62lAbFQu4mE6jPcKagqiILdNdglGr5kGA0HuMLeJ/p5OhIVSZCu+KHpLTuMIOVgOGQLlN/uvXVt7KE4vrxR45C0dRpWf1fxGp5uoMUUGoFTTowFYnxC7ANk2/2t5oIYoeeWuITfvuxO7w9CaKwKBgEVWIu4B/WNdxMwMVKVLHDwMnJMTbnoNDl7o/GQrgdsti8KBDygiHLc1IVa+I3wIrFbIEIKbVaTPJC+9iGbT1vYHOK4PNutV/3UxpdGXIa540iXFxD7biNVvh7YVbrP2lv1CFaZu3QwTgSHX6KIuHsiVGo1ZhGl8hWqSgC2FbxIB"; 
			;	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtIrzCufV6RCkCAEauluUiwFGSH8J8Ih2j5izis/XrfREl5HP2U3LqyNywwuhglHRlzkb0/80QnD1ZHkvMvbnox7mND9YrGbvAOM6wCN3+w3YY8SW/SEYJAioE09c59TJrJJzw8PRcPPuFpf8GYFmltP2iEa3iBHD4HjCURXjtuRpdzu5mnPERpOLKzL8uuUq/lysWGsvdNFtU0CBkTE5Ztlw/4oZ0nJn16jqPvQzgtR9WcVFNh2JT/Gel8z1TsLCe4/oGBeuSornJ9vw6qD0KCsfOt+wt7HIJdHXTF5BTJ7/JoeYTzM8/XYW/9+wZYcwO3vIOhuyWcFIPg1l+Of6AQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1/api/notify_url";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1/api/return_url";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl="https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "D:\\";



    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

