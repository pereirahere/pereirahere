package com.pereiralearning;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Playground {

    public static boolean isPalindrome(int number) {

        //defining the array length
        int arrLength = 0;
        int tempNumber = number;

        while(tempNumber > 0){
            arrLength++;
            tempNumber = tempNumber / 10;
        }

        //populating array with digits from number arg
        int[] numArr = new int[arrLength];

        for (int i = 0; i < arrLength;  i++){
            numArr[i] = number % 10;
            number = number / 10;
        }

        //palindrome logic
        int counter = 1;

        for (int i = 0; i < arrLength;  i++){
            if(numArr[i]==numArr[arrLength-counter]){
                counter++;
                continue;
            }
            return false;
        }
        return true;
    }

    public static int sumFirstAndLastDigit(int number){

        if(number<0){
            return -1;
        }

        //defining the array length
        int arrLength = 0;
        int tempNumber = number;

        while(tempNumber > 0){
            arrLength++;
            tempNumber = tempNumber / 10;
        }

        //populating array with digits from number arg
        int[] numArr = new int[arrLength];

        for (int i = 0; i < arrLength;  i++){
            numArr[i] = number % 10;
            number = number / 10;
        }

        return numArr[0]+numArr[arrLength-1];
    }

    public static int getEvenDigitSum(int number){

        if(number<0){
            return -1;
        }

        //defining the array length
        int arrLength = 0;
        int tempNumber = number;

        while(tempNumber > 0){
            arrLength++;
            tempNumber = tempNumber / 10;
        }

        //populating array with pair digits from number arg
        int[] numArr = new int[arrLength];

        for (int i = 0; i < arrLength;  i++){
            if((number % 10) % 2 == 0) {
                numArr[i] = number % 10;
            }
            number = number / 10;
        }

        int total = 0;

        for (int n : numArr) {
            total+=n;
        }

        return total;
    }

    public static boolean hasSharedDigit(int num1, int num2){

        if(num1<10 || num1>99 || num2<10 || num2>99){
            return false;
        }


        if(num1%10 == num2%10 || num1%10 == num2/10 || num1/10 == num2%10 || num1/10 == num2/10){
            return true;
        }

        return false;
    }

    public static boolean hasSameLastDigit(int n1, int n2, int n3){

        if (!isValid(n1) || !isValid(n2) || !isValid(n3)){
            return false;
        }

        return n1%10 == n2%10 || n1%10 == n3%10 || n2%10 == n3%10;
    }

    public static boolean isValid(int number){
        return number >= 10 && number <= 1000;
    }

    public static int getGreatestCommonDivisor(int first, int second){

        if(first<10 || second<10){
            return -1;
        }

        int divisor = -1;
        int min = Math.min(first, second);

        for (int i = 2; i <= min; i++) {
            if(first%i==0 && second%i==0){
                divisor = i;
            }
        }
        return divisor;
    }


    public static void printFactors(int number){

        if(number<1){
            System.out.println("Invalid Value");
        }

        for (int i = 1; i <= number; i++) {
            if(number%i==0){
                System.out.println(i);
            }
        }
    }

    public static boolean isPerfectNumber(int number){

        if(number<1){
            return false;
        }

        int sum = 0;

        for (int i = 1; i < number; i++) {
            if(number%i==0){
                sum+=i;
            }
        }
        return number == sum;
    }

    //Write a method named canPack with three parameters of type int named bigCount, smallCount, and goal.

    public static boolean canPackWrongExercisePrompt(int bigCount,int smallCount,int goal){

        if(bigCount<0 || smallCount<0 || goal<0){
            return false;
        }

        int bigCountCapacity = 0;
        int missingCapacity = 0;
        int smallCountCapacity = 0;

        if (bigCount!=0){
            bigCountCapacity = goal/bigCount;
            missingCapacity = goal - (bigCountCapacity*bigCount);
        }
        if (smallCount!=0){
            smallCountCapacity = missingCapacity/smallCount;
        }


        return true;
    }

    public static boolean canPack(int bigCount,int smallCount,int goal){

        int bigBag = 5;
        int totalKilos = bigBag*bigCount+smallCount;

        if(bigCount<0 || smallCount<0 || goal<0){
            return false;
        }

        if(totalKilos<goal){
            return false;
        }

        int fitBigBag = 0;
        for (int i = 1; i <= bigCount; i++) {
            if(i*bigBag <= goal){
                fitBigBag = i;
            }
        }

        if(fitBigBag*bigBag+smallCount < goal){
            return false;
        }

        return true;
    }

    public static int getLargestPrime(int number){

        if(number <= 1){
            return -1;
        }

        if(number==2 || number==3){
            return number;
        }

        int largestPrime = 0;

        for (int numToCheck = 3; numToCheck < number; numToCheck+=2){
            for (int factor = 1; factor < numToCheck; factor++){
                if(factor%numToCheck == 0){
                    continue;
                }
                largestPrime = factor-1;
            }
        }
        return largestPrime;
    }

    public static void printSquareStar(int number){

        if(number<5){
            System.out.println("Invalid Value");
            return;
        }

        String star = "* ";
        String space = "  ";
        String lineBreak = "";
        int counter = number;

        for (int x = 0; x < number; x++) {

            counter--;
            for (int y = 0; y < number; y++) {

                //drawing the square vertical lines logic
                if (y == 0 || y == number-1) {
                    System.out.print(star);
                    continue;
                }

                //drawing the square horizontal lines logic
                if (x == 0 || x == number-1){
                    System.out.print(star);
                    continue;
                }
                //drawing the square diagonal lines logic
                if (y==x || y==counter){
                    System.out.print(star);
                    continue;
                }
                System.out.print(space);
            }
            System.out.println(lineBreak);
        }
    }
}
