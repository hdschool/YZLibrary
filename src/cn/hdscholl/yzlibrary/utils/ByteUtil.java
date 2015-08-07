package cn.hdscholl.yzlibrary.utils;

import java.util.Locale;

public class ByteUtil {
	
	/**
	 * byte[]数组转换为16进制的字符串。
	 * 
	 * @param data
	 *            要转换的字节数组。
	 * @param flag
	 * 			  true表示带冒号,比如ee:22:44,否则形如ee2244
	 * @return 转换后的结果。
	 */
	public static final String byteArrayToHexString(byte[] data, boolean isNeedColon)
	{
		StringBuilder result = new StringBuilder();
		for(byte b : data)
		{
			//此处与的目录避免强转出错，比如b = 255,直接赋值给int类型的v,则v最终为-1,错误
			int v = b & 0xff;
			if(v < 16)
			{
				result.append("0");
			}
			if(isNeedColon)
			{
				result.append(Integer.toHexString(v) + ":");
			}
			else
			{
				result.append(Integer.toHexString(v));
			}
		}
		if(isNeedColon)
		{
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString().toUpperCase(Locale.getDefault());
	}
	
	/**
	 * 合并两个数组,产生一个新数组
	 * 
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static byte[] addAll(byte[] array1, byte... array2) {
		byte[] resultBytes = new byte[array1.length + array2.length];
		System.arraycopy(array1, 0, resultBytes, 0, array1.length);
		System.arraycopy(array2, 0, resultBytes, array1.length, array2.length);
		return resultBytes;
	}
	
	
	/**
	 * 将多个byte[]合并成为一个byte[]
	 * 
	 * @param byteArrays
	 * @return
	 */
	public static byte[] mergeByteArray(byte[]... byteArrays) {
		byte[] first = byteArrays[0];
		for (int i = 1; i < byteArrays.length; i++) {
			first = addAll(first, byteArrays[i]);
		}
		return first;
	}
	
	/**
	 * 截取byte数组
	 * 
	 * @param b
	 *            被截取的数组源
	 * @param offset
	 *            截取位置
	 * @param count
	 *            截取数组大小
	 * @return 截取出的新数组
	 */
	public static byte[] subBytes(byte[] b, int offset, int count) {
		byte[] resultByte = new byte[count];
		for (int i = 0; i < count; i++) {
			resultByte[i] = b[offset + i];
		}
		return resultByte;
	}
	
	/**
	 * 将byte表示的底层二进制转化成字符串,比如byte型的-1,转成字符串为11111111
	 * @param b
	 * @return
	 */
	public static String byteToBinaryString(byte b) {
		StringBuilder sb = new StringBuilder();
		int v = b & 0xff;
		String result = Integer.toBinaryString(v);
		int diff = 8 - result.length();
		for(int i = 0 ; i < diff; i ++ )
		{
			sb.append("0");
		}
		sb.append(result);
		return sb.toString();
	}
}
