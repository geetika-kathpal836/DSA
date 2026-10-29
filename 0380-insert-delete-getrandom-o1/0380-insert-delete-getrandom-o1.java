class RandomizedSet {
    HashSet<Integer> st;
    ArrayList<Integer> arrl;
    Random rand;
    public RandomizedSet() {
       st=new HashSet<>(); 
       arrl=new ArrayList<>();
       rand=new Random();
    }
    
    public boolean insert(int val) {
        if(st.contains(val)) return false;
        st.add(val);
        arrl.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(st.contains(val)){
            st.remove(val);
            arrl.remove(Integer.valueOf(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int index=rand.nextInt(arrl.size());
        return arrl.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */