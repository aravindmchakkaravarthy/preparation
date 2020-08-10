package leetcode.array.easy;

/**
 * A bus has n stops numbered from 0 to n - 1 that form a circle. We know the distance between all pairs of neighboring stops where distance[i] is the distance between the stops number i and (i + 1) % n.
 *
 * The bus goes along both directions i.e. clockwise and counterclockwise.
 *
 * Return the shortest distance between the given start and destination stops.
 *
 * Input: distance = [1,2,3,4], start = 0, destination = 1
 * Output: 1
 * Explanation: Distance between 0 and 1 is 1 or 9, minimum is 1.
 *
 * Input: distance = [1,2,3,4], start = 0, destination = 2
 * Output: 3
 * Explanation: Distance between 0 and 2 is 3 or 7, minimum is 3.
 */
public class DistanceBetweenBusStops {
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start == destination) return 0;

        int distanceBtw = 0;
        int l = Math.min(start, destination);
        int r = Math.max(start, destination);

        while (l < r){
            distanceBtw +=distance[l];
            l++;
        }
        int reverseDistance = 0;
        l = Math.max(start, destination);
        r = Math.min(start, destination);
        while(l != r){
            reverseDistance += distance[l];
            if(l == distance.length -1){
                l = 0;
            }else{
                l++;
            }
            if(reverseDistance >= distanceBtw){
                return distanceBtw;
            }
        }
        return reverseDistance;
    }

    public static void main(String[] args){
        int[] distance = {7,10,1,12,11,14,5,0};
        System.out.println(distanceBetweenBusStops(distance, 7, 2));
    }
}
