class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int tempA = arrayA[0];
        for(int i = 1; i < arrayA.length; i++) {
            tempA = gcd(Math.max(tempA, arrayA[i]), Math.min(tempA, arrayA[i]));
        }
        boolean isValidA = true;
        for(int i = 0; i < arrayB.length; i++) {
            if(arrayB[i] % tempA == 0 || tempA == 1) {
                isValidA = false;
                break;
            }
        }
        int tempB = arrayB[0];
        for(int i = 1; i < arrayB.length; i++) {
            tempB = gcd(Math.max(tempB, arrayB[i]), Math.min(tempB, arrayB[i]));
        }
        boolean isValidB = true;
        for(int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] % tempB == 0 || tempB == 1) {
                isValidB = false;
                break;
            }
        }
        // System.out.println(tempA + " " + tempB + " " + isValidA + " " + isValidB);
        if(isValidA && isValidB) {
            answer = Math.max(tempA, tempB);
        } else if(isValidA) {
            answer = tempA;
        } else if(isValidB) {
            answer = tempB;
        } else {
            answer = 0;
        }
        return answer;
    }
    
    static public int gcd(int a, int b) {
        if(b == 0){
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}