package easy.everyday1154;

public class Solution {
    /**
     * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
     *
     * @param date
     * @return
     */
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int ans = 0;
        for (int i = 1; i < month; i++) {
            ans += days[i];
            if (i == 2 && (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)){
                ans++;
            }
        }
        ans += day;
        return ans;
    }
}
