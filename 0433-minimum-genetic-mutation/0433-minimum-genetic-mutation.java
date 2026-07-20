class Pair{
    String word;
    int level;
    Pair(String word, int level){
        this.word=word;
        this.level=level;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> st=new HashSet<>();
        for(int i=0;i<bank.length;i++){
            st.add(bank[i]);
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(startGene,0));
        st.remove(startGene);
        while(!q.isEmpty()){
            String newword=q.peek().word;
            int steps=q.peek().level;
            q.remove();
            if(newword.equals(endGene)){
                return steps;
            }
            for(int i=0;i<newword.length();i++){
                for(char ch='A';ch<='Z';ch++){
                    char[] replacedCharArray=newword.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedword=new String(replacedCharArray);
                    if(st.contains(replacedword)){
                        st.remove(replacedword);
                        q.offer(new Pair(replacedword,steps+1));
                    }
                }
            }
        }
        return -1;
    }
}