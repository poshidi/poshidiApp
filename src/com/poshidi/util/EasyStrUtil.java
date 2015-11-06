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
 * ˵���������ַ������������
 */

public final class EasyStrUtil {

	/**
	 * �ж��ַ����Ƿ�ΪNull����ַ���
	 * 
	 * @param String
	 *            Ҫ�жϵ��ַ���
	 * @return String true-�ǿ��ַ���,false-���ǿ��ַ���
	 */
	public static boolean nil(String s) {
		if (s == null || s.equals("")) {
			return true;
		}
		return false;
	}
	

	/**
	 * �ж��ַ����Ƿ�Ϊ����
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
	 * �ַ�������ת��Ϊ�ַ���,ʹ�ö��ŷָ�
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
	 * �����һ���ַ�����Ϊ���򷵻ظ��ַ���,���򷵻صڶ���
	 */
	public static String nil(String s, String _default) {
		if (EasyStrUtil.nil(s))
			return _default;
		else
			return s;
	}

	/**
	 * �ж��ַ��������Ƿ�Ϊ��
	 */
	public static boolean nil(String[] s) {
		return (s == null || s.length == 0);
	}

	/**
	 * �������Ϊ��,�򷵻ؿ�����
	 */
	public static String[] notNil(String[] s) {
		if (s == null || s.length == 0) {
			return new String[0];
		}
		return s;
	}

	/**
	 * �ı��ַ������뵽gbk
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
	 * �ı��ַ������뵽utf8
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
	 * ת��String��boolean
	 */
	public static boolean parseBoolean(String flag) {
		if (nil(flag))
			return false;
		else if (flag.equals("true") || flag.equals("1") || flag.equals("��")
				|| flag.equals("yes"))
			return true;
		else if (flag.equals("false") || flag.equals("0") || flag.equals("��")
				|| flag.equals("no"))
			return false;
		return false;
	}

	/**
	 * ת��boolean��String
	 */
	public static String parseString(boolean flag) {
		return (String.valueOf(flag));
	}

	/**
	 * ת��String��int <br>
	 * null����ַ�,����0 <br>
	 * true����1 <br>
	 * false����0
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
	 * ת��String��long
	 */
	public static long parseLong(String flag) {
		if (nil(flag))
			return 0;
		return Long.parseLong(flag);
	}

	/**
	 * �ַ����
	 * 
	 * @param source
	 *            Դ�ַ���
	 * @param filler
	 *            ����ַ�,��0��*��
	 * @param length
	 *            ���������ַ����ĳ���
	 * @return ���������ַ���
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
	 * �ӿ�ͷ��spliter�ַ�,��ȡ�ַ��������е�ÿһ��
	 * 
	 * @param arr
	 *            Դ�ַ�������
	 * @param spliter
	 *            �и��
	 * @return �и����ַ�������
	 */
	public static String[] subStrBefore(String[] arr, String spliter) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].substring(0, arr[i].indexOf(spliter));
		}
		return arr;
	}

	/**
	 * 
	 * ���ִ�ת�����ڣ��ִ���ʽ: yyyy-MM-dd
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
	 * �ַ����������Ƿ����ָ�����ַ�����
	 * 
	 * @param strings
	 *            �ַ�������
	 * @param string
	 *            �ַ���
	 * @param caseSensitive
	 *            �Ƿ��Сд����
	 * @return ����ʱ����true�����򷵻�false
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
	 * �ַ����������Ƿ����ָ�����ַ�������Сд���С�
	 * 
	 * @param strings
	 *            �ַ�������
	 * @param string
	 *            �ַ���
	 * @return ����ʱ����true�����򷵻�false
	 */

	public static boolean contains(String[] strings, String string) {
		return contains(strings, string, true);
	}

	/**
	 * �����ִ�Сд�ж��ַ����������Ƿ����ָ�����ַ�����
	 * 
	 * @param strings
	 *            �ַ�������
	 * @param string
	 *            �ַ���
	 * @return ����ʱ����true�����򷵻�false
	 */

	public static boolean containsIgnoreCase(String[] strings, String string) {
		return contains(strings, string, false);
	}

	/**
	 * ����һ����������
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
	 * ����һ����������
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
	 * ����һ����������
	 * 
	 * @param s
	 *            String
	 * @param spliter
	 *            �ָ����綺��
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
	 * ����������ϲ�Ϊ���ַ��ָ���ַ���
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
	 * ���ַ����ĵ�һ����ĸ��д
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
	 * ���ݵ�ǰ�ֽڳ���ȡ�����ϵ�ǰ�ֽڳ��Ȳ���������ֽڳ��ȵ��Ӵ�
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
	 * �Ѵ���HTML��ǩ�Ŀ����ַ��滻����ͨ���ı�
	 * 
	 * @param sourceString
	 *            ����HTML��ʽ��Դ�ִ�
	 * @return Ŀ���ִ�
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
	 * ���طָ�����ߵ��ַ���
	 * 
	 * @param src
	 * @param separator
	 *            �ָ���
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
	 * ���طָ����ұߵ��ַ���
	 * 
	 * @param src
	 * @param separator
	 *            �ָ���
	 * @return
	 */
	public static String rightSubStr(String src, String separator) {
		int i;
		i = src.indexOf(separator);
		return src.substring(i + 1, src.length() - 1);
	}

	/**
	 * �����޶����ȵ��ַ�������"..."
	 * 
	 * @param src
	 * @return
	 */
	public static String displayShortStr(String src) {
		int displayLength = 18; // �޶�����
		StringBuffer strbuf = new StringBuffer();
		if (src.length() > displayLength) {
			strbuf.append(src.substring(0, displayLength - 1) + "...");
		} else {
			strbuf.append(src);
		}
		return strbuf.toString();
	}

	/**
	 * �����޶����ȵ��ַ�������"..."
	 * 
	 * @param src
	 * @param displayLength
	 *            //�޶�����
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
	 * ��ʽ���·�
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
	 * ��ʽ�������е���
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
	 * ����ϵͳ��ǰ���� YYYY-MM-DD
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
	 * �ж��ַ����Ƿ�ΪNull����ַ���
	 * 
	 * @param String
	 *            Ҫ�жϵ��ַ���
	 * @return
	 */
	public static String nilStr(Object s) {
		if (s == null || s.equals("")) {
			return "";
		}
		return s.toString();
	}

	/**
	 * �ж��ַ����Ƿ�ΪNull����ַ���
	 * 
	 * @param String
	 *            Ҫ�жϵ��ַ���
	 * @return
	 */
	public static String nilStr0(Object s) {
		if (s == null || s.equals("")) {
			return "0";
		}
		return s.toString();
	}

	/**
	 * get the true length of the string, a chinese's length is 2 eg. "a��" 's
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
	 * �Ѵ����ĵ��ַ�����targetByteSize��ȡ���������˫�ֽ��ַ�����أ�
	 * 
	 * @param origiStr
	 * @param targetByteSize
	 * @param detectUnicodeLength
	 *            ÿ�ν�ȡ���ַ����ȣ�unicode�ַ���)
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
     * ���ܣ����֤����Ч��֤
     * 
     * @param IDStr
     *            ���֤��
     * @return ��Ч������"" ��Ч������String��Ϣ
     * @throws java.text.ParseException
     */
    public static String IDCardValidate(String IDStr) {
        String errorInfo = "";// ��¼������Ϣ
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        String Ai = "";
        // ================ ����ĳ��� 15λ��18λ ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            errorInfo = "���֤���볤��Ӧ��Ϊ15λ��18λ;";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ ���� �������Ϊ��Ϊ���� ================
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            errorInfo = "���֤15λ���붼ӦΪ���� ; 18λ��������һλ�⣬��ӦΪ����;";
            return errorInfo;
        }
        // =======================(end)========================

        // ================ ���������Ƿ���Ч ================
        String strYear = Ai.substring(6, 10);// ���
        String strMonth = Ai.substring(10, 12);// �·�
        String strDay = Ai.substring(12, 14);// �·�
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
            errorInfo = "���֤������Ч;";
            return errorInfo;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                            strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                errorInfo = "���֤���ղ�����Ч��Χ;";
                return errorInfo;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            errorInfo = "���֤�·���Ч;";
            return errorInfo;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            errorInfo = "���֤������Ч;";
            return errorInfo;
        }
        // =====================(end)=====================

        // ================ ������ʱ����Ч ================
        @SuppressWarnings("rawtypes")
		Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            errorInfo = "���֤�����������;";
            return errorInfo;
        }
        // ==============================================

        // ================ �ж����һλ��ֵ ================
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
                errorInfo = "���֤��Ч�����ǺϷ������֤����;";
                return errorInfo;
            }
        } else {
            return "";
        }
        // =====================(end)=====================
        return "";
    }

    /**
     * ���ܣ����õ�������
     * 
     * @return Hashtable ����
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static Hashtable GetAreaCode() {
		Hashtable hashtable = new Hashtable();
        hashtable.put("11", "����");
        hashtable.put("12", "���");
        hashtable.put("13", "�ӱ�");
        hashtable.put("14", "ɽ��");
        hashtable.put("15", "���ɹ�");
        hashtable.put("21", "����");
        hashtable.put("22", "����");
        hashtable.put("23", "������");
        hashtable.put("31", "�Ϻ�");
        hashtable.put("32", "����");
        hashtable.put("33", "�㽭");
        hashtable.put("34", "����");
        hashtable.put("35", "����");
        hashtable.put("36", "����");
        hashtable.put("37", "ɽ��");
        hashtable.put("41", "����");
        hashtable.put("42", "����");
        hashtable.put("43", "����");
        hashtable.put("44", "�㶫");
        hashtable.put("45", "����");
        hashtable.put("46", "����");
        hashtable.put("50", "����");
        hashtable.put("51", "�Ĵ�");
        hashtable.put("52", "����");
        hashtable.put("53", "����");
        hashtable.put("54", "����");
        hashtable.put("61", "����");
        hashtable.put("62", "����");
        hashtable.put("63", "�ຣ");
        hashtable.put("64", "����");
        hashtable.put("65", "�½�");
        hashtable.put("71", "̨��");
        hashtable.put("81", "���");
        hashtable.put("82", "����");
        hashtable.put("91", "����");
        return hashtable;
    }

    /**
     * ���ܣ��ж��ַ����Ƿ�Ϊ����
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
     * ���ܣ��ж��ַ����Ƿ�Ϊ���ڸ�ʽ
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
     * �ж�����ʱ���ʽ
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
     * ��¼�û��ĵ�λ�Ƿ�������뵥λ
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
	 * ��ȡ����������
	 * 
	 * @param n  // ����
	 * @return
	 */
	public static Date afterNDay(int n){   
		Calendar c=Calendar.getInstance();   
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		c.setTime(new Date());   
		c.add(Calendar.DATE,n);   
		Date date=c.getTime();   
		// String s=df.format(d2);    // �ַ���������
		return date;   
	}
	
	/**
	 * byte(�ֽ�)���ݳ���ת��kb(ǧ�ֽ�)��mb(���ֽ�) 
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
