class TimeMap {
    HashMap<String, TreeMap<Integer,String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> arr;
        if(!timeMap.containsKey(key)){
            arr = new TreeMap<>();
            timeMap.put(key, arr);
        }

        
        arr = timeMap.get(key);
        arr.put(timestamp, value);    
    }

    public int bs(List<Integer> list, int t){

        int start = 0, end = list.size() - 1, mid = 0;

        while(start <= end){
            mid = start + (end - start)/2;

            if(t == list.get(mid))
                return mid;
            else if(t > list.get(mid))
                start = mid + 1;
            else 
                end = mid -1;
        }
        return list.get(mid);
    }
    
    public String get(String key, int timestamp) {
        
        if(timeMap.containsKey(key)){
            TreeMap<Integer, String> arr = timeMap.get(key);
            if(!arr.isEmpty()){
                if(!arr.containsKey(timestamp)){
                    Map.Entry<Integer, String> e= arr.floorEntry(timestamp);
                    if(e != null)
                        return e.getValue();
                    return "";
                }
                return arr.get(timestamp);
            }
                
        }
        return "";
    }
}
