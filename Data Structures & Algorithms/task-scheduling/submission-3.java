class Solution {
    public int leastInterval(char[] tasks, int n) {

        int []freq= new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }

        PriorityQueue<Integer>maxHeap= new PriorityQueue<>((a,b)->b-a);

        for(int f:freq){
            if(f>0){
                maxHeap.add(f);
            }
        }

        int time=0;

        while(!maxHeap.isEmpty()){
            
            int cycles=n+1;
            List<Integer>temp= new ArrayList<>();

            while(cycles>0 && !maxHeap.isEmpty()){
                int top=maxHeap.poll();
                if(top-1>0){
                    temp.add(top-1);
                }
                cycles--;
                time++;
            }
            maxHeap.addAll(temp);

            if(!maxHeap.isEmpty()){
                time+=cycles;
            }
        }

        return time;
        
    }
}
