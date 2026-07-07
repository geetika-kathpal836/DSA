class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        String[] arr=new String[numRows];
        for(int i=0;i<numRows;i++){
            arr[i]="";  //to avoid any null pointer exception
        }
        int i=0;
        int currentrow=0;
        boolean goingdown=true;
        arr[currentrow]=arr[currentrow]+s.charAt(i++);
        currentrow++;
        while(i!=s.length()){
            arr[currentrow]=arr[currentrow]+s.charAt(i++);
            if((currentrow==numRows-1 || currentrow==0 ) ){
                goingdown=!goingdown;
            }
            if(goingdown){
                currentrow+=1;
            }
            else{
                currentrow-=1;
            }
        }
        String ans="";
        for(int j=0;j<numRows;j++){
            ans=ans+arr[j];
        }
        return ans;
    }
}