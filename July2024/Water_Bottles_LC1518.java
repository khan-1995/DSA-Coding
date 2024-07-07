class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        if(numExchange>numBottles){
            return numBottles;
        }
        
        
        int exchanged_bottles = 0;
        int count = 0;

        while(numBottles>=numExchange){
           exchanged_bottles = (numBottles/numExchange);
           count += (numExchange*exchanged_bottles);
           numBottles = (numBottles % numExchange) + exchanged_bottles;
        }

        return count + numBottles;

    }
}
