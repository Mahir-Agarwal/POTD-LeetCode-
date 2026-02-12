//  Brute force is that li hum even ko +1 treat karenge and odd ko -1 phir phir jaha se khade hai vaha se left ki taraf move karnge zero mila toh vaha tak subarray possible toh max ko update kar denge then left me move karne kya pata koi bada subaaray ho toh hume left most nikalna hai 
import java.util.HashMap;

class Solution {


    public int longestBalanced(int[] nums) {
        int n = nums.length;

        segMin = new int [4*nums.length];
        segMax = new int [4*nums.length];
        lazy = new int [4*nums.length];
        //  int maxLen = 0 ;

        // int cumsum[] = new int [nums.length];

        // HashMap<Integer,Integer> map = new HashMap<>();

        // for(int r = 0 ; r < nums.length ; r++){
            
        //   int val = nums[r]%2 == 0 ? 1 : -1 ;

        //     int prev = -1;

        //     if(map.containsKey(nums[r]) ){
        //         prev = map.get(nums[r]);
        //     }
        //     if(prev !=-1){
        //         for(int l = 0 ; l<= prev ; l++){
        //             cumsum[l]-=val;
        //         }
        //     }

        //     for(int l =0 ; l<=r ; l++){
        //         cumsum[l] +=val;
        //     }

        //     for(int l = 0;  l<=r ; l++){
        //         if(cumsum[l]==0){
        //             maxLen = Math.max(maxLen, r-l+1);
        //             break;
        //         }
        //     }
        //     map.put(nums[r],r);
        // }

        // return maxLen;

         int maxLen = 0 ;
        //  int n = nums.length;

        //int cumsum[] = new int [nums.length];

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int r = 0 ; r < nums.length ; r++){
            
          int val = nums[r]%2 == 0 ? 1 : -1 ;

            int prev = -1;

            if(map.containsKey(nums[r]) ){
                prev = map.get(nums[r]);
            }
            if(prev !=-1){
                
                rangeUpdate(0,prev ,0, 0, n-1, -val);
            }

            rangeUpdate(0,r ,0, 0, n-1, val);

            // finding left most zero in range [0...r]
            int l = findLeftMostZero(0,0,n-1);
            if(l !=-1) maxLen = Math.max(maxLen ,r-l+1);

            map.put(nums[r],r);
        }

        return maxLen;
        
    }
// Brute force give us TLE last ke 9 testcase is giving us TLE, so if you see brute force we are using too many nested loops one for check prev me present hai ya nahi one for if present uski value dec karnge ke liye taaki baad me dikat na de and one for adding value jo bhi hai then one for max find so too many loops we are using 
// Its optimised approach is Using Segment Tree Why??!!
// Because if we see above we have to do range update and search queries efficently so for that segment tree is best here to do that task efficently.

    int segMax[];
    int segMin[];
    int lazy[];
    
    public void rangeUpdate(int s, int e, int i , int l , int r , int val){

        propagate (i,l,r);

        if( l >e || r <s ) return ;

        if( l>=s && r<=e){
            lazy[i] +=val;
            propagate(i,l,r);
            return;
        }

        int mid = l + (r-l)/2;

        rangeUpdate(s , e , 2*i+1, l ,mid, val );
        rangeUpdate(s,e,2*i+2,mid+1,r ,val);

        segMax[i] = Math.max(segMax[2*i+1],segMax[2*i+2]);
        segMin[i]=  Math.min(segMin[2*i+2],segMin[2*i+1]);
    }   

    public void propagate(int i , int l , int r){

        if( lazy[i]!=0){
            segMax[i] +=lazy[i];
            segMin[i] +=lazy[i];

            if(l!=r){
                lazy[2*i+1] += lazy[i];
                lazy[2*i+2] += lazy[i];
            }
            lazy[i]=0;
        }
    }

    public int findLeftMostZero(int idx, int l, int r){

        
        propagate(idx ,l , r);

        if( segMin[idx] >0 || segMax[idx] < 0) return -1;

        if( l== r) return  l;

        int mid = l + (r-l)/2;

        int left = findLeftMostZero(2*idx+1 , l ,mid);
        if(left !=-1) return left;
        return findLeftMostZero(2*idx+2, mid+1,r);

    }
    

}



