class Solution {
    public double angleClock(int hour, int min) {
        
        // pure maths 
        // but we goona use trick i.e -> angle = | (30 h + 5.5 m) |


        double angle = Math.abs( ( 30 * hour ) - ( 5.5 * min ) ) ;

        if(angle > 180 ) angle = 360 - angle;
         
        return angle ;

    }
}

