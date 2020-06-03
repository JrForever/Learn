package com.qianlong.learn;

import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {


    private TextView content, tv;
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private AtomicInteger first = new AtomicInteger(0);
    private AtomicInteger second = new AtomicInteger(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = findViewById(R.id.content);
        tv = findViewById(R.id.tv);
        content.setText(str2HexStr("WX|10056068"));
        first.incrementAndGet();

    }

    public void clickEvent(View view) {
//        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)content.getLayoutParams();
//        layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
//        content.setText("呵呵哒");
//        content.setCompoundDrawablesWithIntrinsicBounds(null,
//                null, ContextCompat.getDrawable(this, R.mipmap.anpan), null);

//        String url = "http://121.14.143.51:9090/sams/loginController.do?registerTcuuserinfo&source=01&pwd=123456&sourceid=wx%1003475";
//        String cont = null;
//        try {
//            cont = URLEncoder.encode(url,"utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        content.setText(cont);


//        int[][] arrs = new int[][]{{8, 10}, {2, 6}, {1, 3}, {15, 18}};
//
//        merge(arrs);
//
//        ListNode listNode = new ListNode(2);
//        listNode.next = new ListNode(4);
//        listNode.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//
//        addTwoNumbers(listNode, l2);

//        lengthOfLonge(" ");
//        CircleSqQueue sqQueue = new CircleSqQueue(10);
//        for (int i = 0; i < 11; i++) {
//            try {
//                sqQueue.offer(i);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

//        findMedianSortedArrays(new int[]{1, 3}, new int[]{2});

//        gen(4);
//        longestPalindrome("abcda");
//        reverse("-91283472332");
//        isPalindrome(123321);
        isMatch("aab","c*a*b");
    }


    //合并区间
    private int[][] merge(int[][] intervals) {
        if (intervals == null)
            return new int[1][2];

        int[][] result = new int[intervals.length][2];
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int pos = -1;
        for (int[] arr : intervals) {
            if (pos == -1 || result[pos][1] < arr[0]) {
                result[++pos] = arr;
            } else {
                result[pos][1] = Math.max(result[pos][1], arr[1]);
            }
        }
        return Arrays.copyOf(result, pos + 1);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int iMin = 0, iMax = m;
        //0<=iMin<=m
        int halfPos = (m + n + 1) / 2;
        //bStart = halfPos - aStart;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfPos - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    /**
     * 字符串转换成十六进制字符串
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        byte[] out = new byte[bs.length];
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString();
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode p = l1, q = l2, current = listNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return listNode.next;
    }

    public int lengthOfLonge(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int maxLength = 0;
        int startIndex = 0;
        int length = s.length();
        for (int i = 1; i < length; i++) {
            String substring = s.substring(startIndex, i);
            char c = s.charAt(i);

            String str = new String(new char[]{c});
            int containIndex = substring.indexOf(str);

            if (containIndex == -1) {
                maxLength = Math.max(i - startIndex + 1, maxLength);
            } else {
                maxLength = Math.max(i - startIndex, maxLength);
                startIndex += (containIndex + 1);
            }
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        List<Character> maxArr = new ArrayList<>();
        List<Character> tempArr = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (Character character : chars) {
            if (tempArr.contains(character)) {
                if (tempArr.size() > maxArr.size()) {
                    maxArr.clear();
                    maxArr.addAll(tempArr);
                }
                int i = 0;
                for (; i < tempArr.size(); i++) {
                    if (tempArr.get(i) == character) {
                        break;
                    }
                }
                for (int j = 0; j <= i; j++) {
                    tempArr.remove(0);
                }

            }
            tempArr.add(character);
        }
        return Math.max(tempArr.size(), maxArr.size());
    }

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static int toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    /**
     * 用于建立十六进制字符的输出的大写字符数组
     */
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] encodeHex(byte[] data) {
        return encodeHex(data, true);
    }

    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }


    protected static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

    private List<String> gen(int n) {
        List<String> result = new ArrayList<>();
        _gen("", result, n, n);
        return result;
    }

    private void _gen(String value, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(value);
            return;
        }

        if (left > 0) {
            _gen(value + "(", result, left - 1, right);
        }

        if (right > left) {
            _gen(value + ")", result, left, right - 1);
        }
    }

    public String longestPalindrome(String s) {
        String reslut = "";
        if (s == null || s.length() == 0) {
            return reslut;
        }

        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char theChar = s.charAt(i);
            if (!map.containsKey(theChar)) {
                map.put(theChar, i);
                if (reslut.length() < 2) {
                    reslut = theChar + "";
                }
            } else {
                Integer index = map.get(theChar);
                int offset = i - index + 1;
                if (offset >= reslut.length()) {
                    String subValue = s.substring(index, i + 1);
                    String reverseValue = new StringBuffer(subValue).reverse().toString();
                    if (subValue.equals(reverseValue)) {
                        reslut = subValue;
                    }
                }
                map.put(theChar, i);
            }
        }
        return reslut;
    }

    private int reverse(String str) {
        if (str == null) {
            return 0;
        }

        str = str.trim();
        int pos = 0, nav = 1;
        long var = 0;
        while (pos < str.length() && isLegal(str.charAt(pos))) {
            char c = str.charAt(pos);
            pos++;
            if (c == 45 || c == 43) {
                if (pos == 1) {
                    nav = (c == 45) ? -1 : 1;
                    continue;
                } else {
                    break;
                }
            }
            var = var * 10 + (c - '0');
            if (var * nav > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (var * nav < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) var * nav;
    }

    private boolean isLegal(Character c) {
        if (c == 45 || (c >= 48 && c <= 57) || c == 43) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x > 0) {
            int last = x % 10;
            int first = x / div;
            if (first != last) {
                return false;
            }
            x = x % div;
            x /= 10;
            div /= 100;
        }

        return true;
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        }else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
