package easy.everyday2696;

class Solution {
    /**
     * 给你一个仅由 大写 英文字符组成的字符串 s 。
     *
     * 你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。
     *
     * 通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。
     *
     * 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。
     * @param s
     * @return
     */
    public int minLength(String s) {
        while(s.contains("AB") || s.contains("CD")){
            if(s.contains("AB")){
                String[] sp = s.split("AB");
                StringBuilder sb = new StringBuilder();
                for (String tmp: sp){
                    sb.append(tmp);
                }
                s = sb.toString();
            }
            if(s.contains("CD")){
                String[] sp = s.split("CD");
                StringBuilder sb = new StringBuilder();
                for (String tmp: sp){
                    sb.append(tmp);
                }
                s = sb.toString();
            }
        }
        return s.length();
    }
}
