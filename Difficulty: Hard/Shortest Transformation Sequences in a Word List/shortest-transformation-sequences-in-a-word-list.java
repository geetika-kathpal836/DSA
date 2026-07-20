class Solution {
    public ArrayList<ArrayList<String>> findSequences(String[] words, String s,
                                                      String e) {
        // code here
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        HashSet<String> st=new HashSet<>();
        for(int i=0;i<words.length;i++){
            st.add(words[i]);
        }
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> usedOnLevel=new ArrayList<String>();
        int level=0;
        ArrayList<String> ls=new ArrayList<>();
        ls.add(s);
        q.offer(ls);
        usedOnLevel.add(s);
        while(!q.isEmpty()){
            ArrayList<String> vec=q.peek();
            q.remove();
            if(vec.size()>level){
                level++;
                for(String it: usedOnLevel){
                    st.remove(it);
                }
                usedOnLevel.clear();
            }
            String word=vec.get(vec.size()-1);
            if(word.equals(e)){
                if(ans.size()==0){
                    ans.add(vec);
                }
                else{
                    if(ans.get(0).size()==vec.size()){
                        ans.add(vec);
                    }
                }
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);
                    if(st.contains(replacedWord)){
                        vec.add(replacedWord);
                        usedOnLevel.add(replacedWord);
                        ArrayList<String> temp=new ArrayList<>(vec);
                        q.offer(temp);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}