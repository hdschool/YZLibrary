package cn.hdscholl.yzlibrary.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import android.util.Base64;


public class CipherUtil {
	/**
	 * md5摘要字节数组
	 * 
	 * @param data
	 * @return 返回摘要数组，16字节
	 */
	public static byte[] md5(byte[] data) {
		try {
			byte[] hash = MessageDigest.getInstance("MD5").digest(data);
			return hash;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5摘要算法");
		}
	}
	

	/**
	 * MD5摘要文本, utf-8格式
	 * @param string
	 * @return md5摘要16进制字符串表示
	 */
	public static String md5(String string) {
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(
					string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("不支持md5", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("不支持md5摘要时utf-8编码", e);
		}

		ByteUtil.byteArrayToHexString(hash, false);
		return ByteUtil.byteArrayToHexString(hash, false);
	}

	private final static String DES = "DES";
	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) {
		try {
			// 生成一个可信任的随机数源
			SecureRandom sr = new SecureRandom();
			// 从原始密钥数据创建DESKeySpec对象
			DESKeySpec dks = new DESKeySpec(key);
			// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
			SecretKey securekey = keyFactory.generateSecret(dks);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance(DES);
			// 用密钥初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
			byte[] ret = cipher.doFinal(data);
			// 截取掉最后8个字节,不知道为什么会有这8个字节的区别
			return ByteUtil.subBytes(ret, 0, ret.length - 8);
		} catch (Exception e) {
			throw new RuntimeException("加密失败");
		}
	}

	private static final String KEY_ALGORITHM = "DES";
	private static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";
	public static String encrypt(String data, String key) {
		try {
			byte[] dateBytes = data.getBytes();
			byte[] keyBytes = key.getBytes();
			// 生成密钥
			DESKeySpec dks = new DESKeySpec(keyBytes);
			//实例化密钥工厂
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			//生成私密密钥
			SecretKey secretKey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			//初始化,设置为加密模式
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.encodeToString(cipher.doFinal(dateBytes), Base64.DEFAULT);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static String decrypt(String data, String key) {
		try {
			byte[] dateBytes = Base64.decode(data, Base64.DEFAULT);
			byte[] keyBytes = key.getBytes();
			// 生成密钥
			DESKeySpec dks = new DESKeySpec(keyBytes);
			//实例化密钥工厂
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			//生成私密密钥
			SecretKey secretKey = keyFactory.generateSecret(dks);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			//初始化,设置为加密模式
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(dateBytes));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
