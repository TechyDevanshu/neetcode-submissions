class Solution {
        public int findDuplicate(int[] nums) {

            //Treat array as a Linked List;
            int slow = nums[0];
            int fast = nums[0];
            
            //Detect a cycle in a Linked list; meetup point;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);
            
            //Reset slow to 0th index;
            slow=nums[0];
            
            //Move both one step at a time;
            while (slow!=fast){
                slow=nums[slow];
                fast=nums[fast];
            }
            return slow;
        }
    }