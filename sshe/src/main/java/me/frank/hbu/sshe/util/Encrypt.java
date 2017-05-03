package me.frank.hbu.sshe.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

/**
 * 加密工具类
 * 
 * md5加密出来的长度是32位
 * 
 * sha加密出来的长度是40位
 * 
 */
public class Encrypt {

	private static Logger logger = Logger.getLogger(Encrypt.class);
	
	/**
	 * 
	 * 加密(MD5方式)
	 * 
	 */
	public static String encrypt(String inputText) {
		return md5(inputText);
	}

	/**
	 * 
	 * 二次加密(先MD5在SHA)
	 * 
	 */
	public static String md5AndSha(String inputText) {
		return sha(md5(inputText));
	}

	/**
	 * md5加密
	 */
	public static String md5(String inputText) {
		return encrypt(inputText, "md5");
	}

	/**
	 * sha加密
	 */
	public static String sha(String inputText) {
		return encrypt(inputText, "sha-1");
	}

	/**
	 * md5或者sha-1加密
	 * 
	 * @param inputText
	 *            要加密的内容
	 * @param algorithmName
	 *            加密算法名称：md5或者sha-1，不区分大小写
	 * @return
	 * 			密文
	 */
	private static String encrypt(String inputText, String algorithmName) {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		String encryptText = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithmName);
			messageDigest.update(inputText.getBytes("UTF8"));
			byte s[] = messageDigest.digest();
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			logger.error("找不到加密算法",e);
		} catch (UnsupportedEncodingException e) {
			logger.error("编码格式错误",e);
		}
		return encryptText;
	}

	/**
	 * 返回十六进制字符串
	 * 
	 * @param arr
	 * @return
	 */
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return sb.toString();
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		// md5加密测试
		String md5_1 = md5("123456");
		String md5_2 = md5("孙宇");
		System.out.println(md5_1 + "\n" + md5_2);
		// sha加密测试
		String sha_1 = sha("123456");
		String sha_2 = sha("孙宇");
		System.out.println(sha_1 + "\n" + sha_2);

	}
	
}
