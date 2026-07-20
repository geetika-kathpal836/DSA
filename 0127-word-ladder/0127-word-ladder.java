class Pair{
    String word;
    int level;
    Pair(String word, int level){
        this.word=word;
        this.level=level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        q.offer(new Pair(beginWord,1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            String newword=q.peek().word;
            int steps=q.peek().level;
            q.remove();
            if(newword.equals(endWord)){
                return steps;
            }
            for(int i=0;i<newword.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedcharArray=newword.toCharArray();
                    replacedcharArray[i]=ch;
                    String replacedword=new String(replacedcharArray);
                    if(st.contains(replacedword)){
                        st.remove(replacedword);
                        q.offer(new Pair(replacedword,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}