class Solution {
    public int countVowelSubstrings(String word) {
        int first=lessthanequalto(word,5);
        int second=lessthanequalto(word,4);
        return first-second;
    }
    public int lessthanequalto(String word, int k){
        int cnt=0;
        HashMap<Character,Integer> mpp=new HashMap<>();
        int l=0;
        int r=0;
        while(r<word.length()){
            if(word.charAt(r)=='a' || word.charAt(r)=='e' || word.charAt(r)=='i' || word.charAt(r)=='o' || word.charAt(r)=='u'){
                if(mpp.containsKey(word.charAt(r))){
                    mpp.put(word.charAt(r),mpp.get(word.charAt(r))+1);
                }
                else{
                    mpp.put(word.charAt(r),1);
                }
            }else{
                mpp.clear();
                l=r+1;
            }
            while(mpp.size()>k){
                mpp.put(word.charAt(l),mpp.get(word.charAt(l))-1);
                if(mpp.get(word.charAt(l))==0){
                    mpp.remove(word.charAt(l));
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}

// isme just remember that aapko map ka size exact 5 chahiye so therefore sliding window ka concept can be used here 