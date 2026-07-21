class Solution {
    String b;
    HashMap<String,Integer> mpp;
    List<List<String>> ans;
    public void dfs(String word, ArrayList<String> seq){
        if(word.equals(b)){
            List<String> arrl=new ArrayList<>(seq);
            Collections.reverse(arrl);
            ans.add(arrl);
            return;
        }
        else{
            int steps=mpp.get(word);
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedcharArray=word.toCharArray();
                    replacedcharArray[i]=ch;
                    String replacedword=new String(replacedcharArray);
                    if(mpp.containsKey(replacedword) && mpp.get(replacedword)+1 == steps){
                        seq.add(replacedword);
                        dfs(replacedword,seq);
                        seq.remove(seq.size()-1);
                    }
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        b=beginWord;
        mpp=new HashMap<>();
        Queue<String> q=new LinkedList<>();
        b=beginWord;
        q.offer(beginWord);
        mpp.put(beginWord,1);
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.remove();
            int steps=mpp.get(word);
            if(word.equals(endWord)){
                break;
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.offer(replacedWord);
                        mpp.put(replacedWord,steps+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        if(mpp.containsKey(endWord)){
            ArrayList<String> seq=new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }
}