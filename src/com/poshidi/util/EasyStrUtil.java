package com.poshidi.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 说明：常用字符串及数组操作
 */

public final class EasyStrUtil {

	/**
	 * 判断字符串是否为Null或空字符串
	 * 
	 * @param String
	 *            要判断的字符串
	 * @return String true-是空字符串,false-不是空字符串
	 */
	public static boolean nil(String s) {
		if (s == null || s.equals("")) {
			return true;
		}
		return false;
	}
	

	/**
	 * 判断字符串是否为数字
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isNum(String s) {
		if (s == null || s.equals("")) {
			return false;
		} else {
			String regEx = "[0-9]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(s);
			boolean falg = m.find();
			return falg;
		}
	}

	/**
	 * 字符串数组转换为字符串,使用逗号分隔
	 */
	public static String split(String[] s, String spliter) {
		if (EasyStrUtil.nil(s))
			return "";
		if (s.length == 1)
			return s[0];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length; i++) {
			sb.append(s[i]).append(spliter);
		}
		sb.deleteCharAt(sb.lastIndexOf(spliter));
		return sb.toString();
	}

	/**
	 * 如果第一个字符串不为空则返回该字符串,否则返回第二个
	 */
	public static String nil(String s, String _default) {
		if (EasyStrUtil.nil(s))
			return _default;
		else
			return s;
	}

	/**
	 * 判断字符串数组是否为空
	 */
	public static boolean nil(String[] s) {
		return (s == null || s.length == 0);
	}

	/**
	 * 如果数组为空,则返回空数组
	 */
	public static String[] notNil(String[] s) {
		if (s == null || s.length == 0) {
			return new String[0];
		}
		return s;
	}

	/**
	 * 改变字符串编码到gbk
	 */
	public static String toGBK(String src) {
		if (nil(src))
			return "";
		String s = null;
		try {
			s = new String(src.getBytes("ISO-8859-1"), "GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 改变字符串编码到utf8
	 */
	public static String toUTF8(String src) {
		if (nil(src))
			return "";
		String s = null;
		try {
			s = new String(src.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 转换String到boolean
	 */
	public static boolean parseBoolean(String flag) {
		if (nil(flag))
			return false;
		else if (flag.equals("true") || flag.equals("1") || flag.equals("是")
				|| flag.equals("yes"))
			return true;
		else if (flag.equals("false") || flag.equals("0") || flag.equals("否")
				|| flag.equals("no"))
			return false;
		return false;
	}

	/**
	 * 转换boolean到String
	 */
	public static String parseString(boolean flag) {
		return (String.valueOf(flag));
	}

	/**
	 * 转换String到int <br>
	 * null或空字符,返回0 <br>
	 * true返回1 <br>
	 * false返回0
	 */
	public static int parseInt(String flag) {
		if (nil(flag))
			return 0;
		else if (flag.equals("true"))
			return 1;
		else if (flag.equals("false"))
			return 0;
		return Integer.parseInt(flag);
	}

	/**
	 * 转换String到long
	 */
	public static long parseLong(String flag) {
		if (nil(flag))
			return 0;
		return Long.parseLong(flag);
	}

	/**
	 * 字符填充
	 * 
	 * @param source
	 *            源字符串
	 * @param filler
	 *            填充字符,如0或*等
	 * @param length
	 *            最终填充后字符串的长度
	 * @return 最终填充后字符串
	 */
	public static String fill(String source, String filler, int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length - source.length(); i++) {
			sb.append(filler);
		}
		sb.append(source);
		return sb.toString();
	}

	/**
	 * 从开头到spliter字符,截取字符串数组中的每一项
	 * 
	 * @param arr
	 *            源字符串数组
	 * @param spliter
	 *            切割符
	 * @return 切割后的字符串数组
	 */
	public static String[] subStrBefore(String[] arr, String spliter) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].substring(0, arr[i].indexOf(spliter));
		}
		return arr;
	}

	/**
	 * 
	 * 将字串转成日期，字串格式: yyyy-MM-dd
	 * 
	 * @param string
	 *            String
	 * @return Date
	 */

	public static Date parseDate(String string) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return (Date) formatter.parse(string);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @param caseSensitive
	 *            是否大小写敏感
	 * @return 包含时返回true，否则返回false
	 */

	public static boolean contains(String[] strings, String string,
			boolean caseSensitive) {
		for (int i = 0; i < strings.length; i++) {
			if (caseSensitive == true) {
				if (strings[i].equals(string)) {
					return true;
				}
			} else {
				if (strings[i].equalsIgnoreCase(string)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 字符串数组中是否包含指定的字符串。大小写敏感。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @return 包含时返回true，否则返回false
	 */

	public static boolean contains(String[] strings, String string) {
		return contains(strings, string, true);
	}

	/**
	 * 不区分大小写判定字符串数组中是否包含指定的字符串。
	 * 
	 * @param strings
	 *            字符串数组
	 * @param string
	 *            字符串
	 * @return 包含时返回true，否则返回false
	 */

	public static boolean containsIgnoreCase(String[] strings, String string) {
		return contains(strings, string, false);
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String[]
	 * @return int[]
	 */
	public static int[] parseInt(String[] s) {
		if (s == null) {
			return (new int[0]);
		}
		int[] result = new int[s.length];
		try {
			for (int i = 0; i < s.length; i++) {
				result[i] = Integer.parseInt(s[i]);
			}
		} catch (NumberFormatException ex) {
		}
		return result;
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String
	 * @return int[]
	 */
	public static int[] split(String s) {
		if (nil(s))
			return new int[0];
		if (s.indexOf(",") > -1) {
			return EasyStrUtil.split(s, ",");
		} else {
			int[] i = new int[1];
			i[0] = Integer.parseInt(s);
			return i;
		}
	}

	public static String[] splitEx(String s) {
		if (nil(s))
			return new String[0];
		if (s.indexOf(",") > -1) {
			String[] ary = s.split(",");
			String[] result = new String[ary.length];
			try {
				for (int i = 0; i < ary.length; i++) {
					result[i] = ary[i];
				}
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return new String[0];
			}
		} else {
			String[] i = new String[1];
			i[0] = (s);
			return i;
		}
	}

	/**
	 * 返回一个整数数组
	 * 
	 * @param s
	 *            String
	 * @param spliter
	 *            分隔符如逗号
	 * @return int[]
	 */
	public static int[] split(String s, String spliter) {
		if (s == null || s.indexOf(spliter) == -1) {
			return (new int[0]);
		}
		String[] ary = s.split(spliter);
		int[] result = new int[ary.length];
		try {
			for (int i = 0; i < ary.length; i++) {
				result[i] = Integer.parseInt(ary[i]);
			}
		} catch (NumberFormatException ex) {
		}
		return result;
	}

	/**
	 * 将整型数组合并为用字符分割的字符串
	 * 
	 * @param int[]
	 * @return String
	 */
	public static String join(int[] arr) {
		if (arr == null || arr.length == 0)
			return "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0, len = arr.length; i < len; i++) {
			sb.append(",").append(arr[i]);
		}
		sb.deleteCharAt(0);
		return sb.toString();
	}

	public static String joinEx(String[] arr) {
		if (arr == null || arr.length == 0)
			return "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0, len = arr.length; i < len; i++) {
			sb.append(",").append("'" + arr[i] + "'");
		}
		sb.deleteCharAt(0);
		return sb.toString();
	}

	/**
	 * 将字符串的第一个字母大写
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String firstCharToUpperCase(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		char[] arrC = s.toCharArray();
		arrC[0] = Character.toUpperCase(arrC[0]);
		return String.copyValueOf(arrC);
	}

	/**
	 * 根据当前字节长度取出加上当前字节长度不超过最大字节长度的子串
	 * 
	 * @param str
	 * @param currentLen
	 * @param MAX_LEN
	 * @return
	 */
	public static String getSubStr(String str, int currentLen, int MAX_LEN) {
		int i;
		for (i = 0; i < str.length(); i++) {
			if (str.substring(0, i + 1).getBytes().length + currentLen > MAX_LEN) {
				break;
			}
		}
		if (i == 0) {
			return "";
		} else {
			return str.substring(0, i);
		}
	}

	/**
	 * 把带有HTML标签的控制字符替换成普通的文本
	 * 
	 * @param sourceString
	 *            包含HTML格式的源字串
	 * @return 目标字串
	 */
	public static String html2text(String src) {
		StringBuffer strbuf = new StringBuffer();

		if (src == null) {
			return "";
		}

		char ch;
		int i;

		for (i = 0; i < src.length(); i++) {
			ch = src.charAt(i);

			switch (ch) {
			case '<':
				strbuf.append("&lt;");

				break;

			case '>':
				strbuf.append("&gt;");

				break;

			case '&':
				strbuf.append("&amp;");

				break;

			case '\"':
				strbuf.append("&quot;");

				break;

			default:
				strbuf.append(ch);

				break;
			}
		}

		return strbuf.toString();
	}

	/**
	 * 返回分隔符左边的字符串
	 * 
	 * @param src
	 * @param separator
	 *            分隔符
	 * @return
	 */
	public static String leftSubStr(String src, String separator) {
		int i;
		try {
			i = src.indexOf(separator);
			return src.substring(0, i);
		} catch (RuntimeException e) {
			return src;
		}
	}

	/**
	 * 返回分隔符右边的字符串
	 * 
	 * @param src
	 * @param separator
	 *            分隔符
	 * @return
	 */
	public static String rightSubStr(String src, String separator) {
		int i;
		i = src.indexOf(separator);
		return src.substring(i + 1, src.length() - 1);
	}

	/**
	 * 返回限定长度的字符串加上"..."
	 * 
	 * @param src
	 * @return
	 */
	public static String displayShortStr(String src) {
		int displayLength = 18; // 限定长度
		StringBuffer strbuf = new StringBuffer();
		if (src.length() > displayLength) {
			strbuf.append(src.substring(0, displayLength - 1) + "...");
		} else {
			strbuf.append(src);
		}
		return strbuf.toString();
	}

	/**
	 * 返回限定长度的字符串加上"..."
	 * 
	 * @param src
	 * @param displayLength
	 *            //限定长度
	 * @return
	 */
	public static String displayShortStr(String src, int displayLength) {
		StringBuffer strbuf = new StringBuffer();
		if (src.length() > displayLength) {
			strbuf.append(src.substring(0, displayLength - 1));
			strbuf.append("...");
		} else {
			strbuf.append(src);
		}
		return strbuf.toString();
	}

	/**
	 * 格式化月份
	 * 
	 * @param month
	 * @return
	 */
	public static String formatMonth(String month) {
		StringBuffer strbuf = new StringBuffer();
		if (month.length() == 1) {
			strbuf.append("0");
			strbuf.append(month);
		} else {
			strbuf.append(month);
		}
		return strbuf.toString();
	}

	/**
	 * 格式化日期中的天
	 * 
	 * @param month
	 * @return
	 */
	public static String formatDay(String day) {
		StringBuffer strbuf = new StringBuffer();
		if (day.length() == 1) {
			strbuf.append("0");
			strbuf.append(day);
		} else {
			strbuf.append(day);
		}
		return strbuf.toString();
	}

	/**
	 * 返回系统当前日期 YYYY-MM-DD
	 * 
	 * @return
	 */
	public static String getNowDate() {
		Calendar currentDay = new GregorianCalendar();
		int today = currentDay.get(Calendar.DAY_OF_MONTH);
		String strToday = EasyStrUtil.formatDay(Integer.toString(today));
		int month = currentDay.get(Calendar.MONTH) + 1;
		String strMonth = EasyStrUtil.formatMonth(Integer.toString(month));
		int year = currentDay.get(Calendar.YEAR);
		String strCurrentDay = year + "-" + strMonth + "-" + strToday;
		return strCurrentDay;
	}

	/**
	 * 判断字符串是否为Null或空字符串
	 * 
	 * @param String
	 *            要判断的字符串
	 * @return
	 */
	public static String nilStr(Object s) {
		if (s == null || s.equals("")) {
			return "";
		}
		return s.toString();
	}

	/**
	 * 判断字符串是否为Null或空字符串
	 * 
	 * @param String
	 *            要判断的字符串
	 * @return
	 */
	public static String nilStr0(Object s) {
		if (s == null || s.equals("")) {
			return "0";
		}
		return s.toString();
	}

	/**
	 * get the true length of the string, a chinese's length is 2 eg. "a大" 's
	 * char length is 3. while "ab" 's char length is 2
	 * 
	 * @param str
	 * @return
	 */
	public static int getCharLength(String str) {
		int length = 0;

		try {
			length = (new String(str.getBytes("GBK"), "iso-8859-1")).length();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		return length;
	}

	/**
	 * 把带中文的字符串按targetByteSize截取（不会造成双字节字符的误截）
	 * 
	 * @param origiStr
	 * @param targetByteSize
	 * @param detectUnicodeLength
	 *            每次截取的字符长度（unicode字符数)
	 * @return
	 */
	public static String truncateToByteSize(String origiStr,
			int targetByteSize, int detectUnicodeLength) {
		if (null == origiStr) {
			return null;
		}

		int origiSize = getCharLength(origiStr);

		if (origiSize <= targetByteSize) {
			return origiStr;
		} else {
			String targetStr = origiStr;

			while (getCharLength(targetStr) > targetByteSize) {
				if ((targetStr.length() - detectUnicodeLength) < 0) {
					targetStr = "";

					break;
				}

				targetStr = targetStr.substring(0, targetStr.length()
						- detectUnicodeLength);
			}

			return targetStr;
		}
	}
	
	 /**
     * 功能：身份证的有效验证
     * 
     * @param IDStr
     *            身份证号
     * @return 有效：返回"" 无效：返回String信息
     * @throws java.text.ParseException
     */
    public static String IDCardValidate(String IDStr) {
        String errorInfo = "";// 记录错误信息
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        String Ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "身份证号码长度应该为15位或18位;";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 数字 除最后以为都为数字 ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字;";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ 出生年月是否有效 ================
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "身份证生日无效;";
            return errorInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                            strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                errorInfo = "身份证生日不在有效范围;";
                return errorInfo;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "身份证月份无效;";
            return errorInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "身份证日期无效;";
            return errorInfo;
        }
        // =====================(end)=====================

        // ================ 地区码时候有效 ================
        @SuppressWarnings("rawtypes")
		Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "身份证地区编码错误;";
            return errorInfo;
        }
        // ==============================================

        // ================ 判断最后一位的值 ================
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
        	if("X".equals(IDStr.substring(17, 18))){
        		IDStr=IDStr.substring(0, 17)+"x";
            }
            if (Ai.equals(IDStr) == false) {
                errorInfo = "身份证无效，不是合法的身份证号码;";
                return errorInfo;
            }
        } else {
            return "";
        }
        // =====================(end)=====================
        return "";
    }

    /**
     * 功能：设置地区编码
     * 
     * @return Hashtable 对象
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static Hashtable GetAreaCode() {
		Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * 功能：判断字符串是否为数字
     * 
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (isNum.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能：判断字符串是否为日期格式
     * 
     * @param str
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    /*
     * 判断申请时间格式
     */
    public static boolean valSqsj(String strDate) {
    	DateFormat format = new SimpleDateFormat("yyyyMMdd");
    	boolean flag = false;
    	try {
    		Date sDate = new Timestamp(format.parse(strDate).getTime());
			flag = true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return flag;
		}
		return flag;
    }
    
    /**
     * 登录用户的单位是否包含输入单位
     * @param dept
     * @param userdept
     * @return
     */
    public static boolean IsUserDeptIncludeDept(String dept,String userdept){
		boolean flag = false;
		String _userdept = userdept;
		for (int i = _userdept.length(); i > 0; i--) {
			if (!"0".equals(_userdept.substring(i - 1,i))) {
				_userdept = _userdept.substring(0, i);
				break;
			}
		}
		//System.out.println("dept:"+dept);
		//System.out.println("userdept:"+userdept);
		//System.out.println("_userdept:"+_userdept);
		if (dept.substring(0, _userdept.length()).equals(_userdept)) {
			flag = true;
		}
		//System.out.println("dept.substring(0, _userdept.length():"+dept.substring(0, _userdept.length()));
		//System.out.println("flag:"+flag);
		return flag;
    }
    
    /**
	 * 获取几天后的日期
	 * 
	 * @param n  // 天数
	 * @return
	 */
	public static Date afterNDay(int n){   
		Calendar c=Calendar.getInstance();   
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		c.setTime(new Date());   
		c.add(Calendar.DATE,n);   
		Date date=c.getTime();   
		// String s=df.format(d2);    // 字符串的日期
		return date;   
	}
	
	/**
	 * byte(字节)根据长度转成kb(千字节)和mb(兆字节) 
	 * @param bytes
	 * @return
	 */
	public static String bytes2kb(long bytes) {  
        BigDecimal filesize = new BigDecimal(bytes);  
        BigDecimal megabyte = new BigDecimal(1024 * 1024);  
        float returnValue = filesize.divide(megabyte, 2, BigDecimal.ROUND_UP)  
                .floatValue();  
        if (returnValue > 1)  
            return (returnValue + "MB");  
        BigDecimal kilobyte = new BigDecimal(1024);  
        returnValue = filesize.divide(kilobyte, 2, BigDecimal.ROUND_UP)  
                .floatValue();
        if(returnValue < 1)
        	returnValue = 1;
        return (returnValue + "KB");  
    } 
}
