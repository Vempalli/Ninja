package com.Algorithms.Ninja;

public class MathPow {

	public static double pow(double a, int b){
        //check the validity of a and b
        if(a == 0 && b == 0)
            return Integer.MIN_VALUE;
        
        if(a == 0)
            return 0;

        if(b == 0)
            return 1;
        
        if(b == 1)
            return a;

        boolean aMinus = a < 0? true: false;
        boolean bMinus = b < 0? true : false;

        int bAbs = Math.abs(b);
        double aAbs = Math.abs(a);
        
        //check if b is odd
        double tempAnswer;
        if( (b & 1) != 0){
            tempAnswer = pow(aAbs, bAbs - 1) * aAbs;
        }
        else{
            tempAnswer = pow(aAbs * aAbs, bAbs / 2);
        }

        if(bMinus)
            tempAnswer = 1.0 / tempAnswer;
        if(aMinus && (b&1)!= 0)
            tempAnswer *= -1;

        return tempAnswer;

    }

    public static void main(String[] args){

        System.out.println(MathPow.pow(-2,9));
        return ;
    }

}
