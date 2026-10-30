class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            int pos=haystack.indexOf(needle);
            return pos;
        }
        return -1;
    }
}