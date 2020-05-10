package Solutions;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {
    public static int solution(int[] A) {
        Discs.intersection(A);
        return 0;
    }

    private static class Discs {

        private static int numberOfIntersections;

        private static Disc initialDisc ;

        private static Disc followingDisc;


        private static boolean intersection(int distance){
            return (distance <= initialDisc.radius + followingDisc.radius);

        }

        private static void intersection(int[] array) {
            numberOfIntersections = 0;
            initialDisc = new Disc(0,0);
            followingDisc = new Disc(0,0);
            loop:
            for (int i = 0; i < array.length; i++) {
                initialDisc.setPosition(i);
                initialDisc.setRadius(array[i]);
                for (int j = i+1; j < array.length; j++) {
                    followingDisc.setPosition(j);
                    followingDisc.setRadius(array[j]);
                    int distance = followingDisc.position - initialDisc.position;
                    if (intersection(distance)) {
                        System.out.println(initialDisc.position + " " +
                                initialDisc.radius + " " +followingDisc.position + " "+
                                followingDisc.radius);
                        System.out.println("intersection");
                        numberOfIntersections ++;
                    }
                    if(numberOfIntersections >= 100_000_0000){
                        numberOfIntersections = -1;
                        break loop;
                    }

                }
            }
        }

        private static class Disc {

            private int position;

            private int radius;

            public Disc(int position, int radius) {
                this.position = position;
                this.radius = radius;
            }

            private void setPosition(int position) {
                this.position = position;

            }

            private void setRadius(int radius) {
                this.radius = radius;
            }
        }
    }

    private static class ProductOfTriplet {


        private static int answer;

        private static void setAnswer(int[] array) {
            int P;
            int Q;
            int R;
            int product;
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < array.length; i++) {
                P = array[i];

                for (int j = i + 1; j < array.length; j++) {
                    Q = array[j];

                    for (int k = j + 1; k < array.length; k++) {
                        R = array[k];

                        product = calculateProduct(P, Q, R);
                        if (temp < product) {
                            temp = product;
                        }
                    }
                }


            }
            answer = temp;
        }

        private static int calculateProduct(int P, int Q, int R) {
            return P * Q * R;
        }
    }


    private static class NumberOfDistinctElements {

        private static List<Integer> integers;

        private static int integersSize;

        private static void setAll(int[] array) {
            setIntegerList(array);
            serIntegersSize();
        }

        private static void serIntegersSize() {
            integersSize = integers.size();
        }

        private static void setIntegerList(int[] array) {
            integers = new ArrayList<>();
            for (int integer : array) {
                if (!integers.contains(integer)) {
                    integers.add(integer);
                }
            }
        }
    }

    private static class TriangularTask {

        private static int[] triplet;

        private static int[] inputArray;

        private static int[] sortedArray;

        private static int firstIndex;

        private static int answer;

        private static int setAnswer() {
            int P;
            int Q;
            int R;
            int digit;
            for (int i = firstIndex; i < sortedArray.length; i++) {
                P = sortedArray[i];
                if (i + 1 > sortedArray.length) {
                    return 0;
                } else {

                    for (int j = i + 1; j < sortedArray.length; j++) {
                        Q = sortedArray[j];
                        if (j + 1 > sortedArray.length) {
                            return 0;
                        } else {
                            for (int k = j + 1; k < sortedArray.length; k++) {
                                R = sortedArray[k];
                                if (condition(P, Q, R)) {

                                    digit = 1;
                                    return digit;
                                }

                            }
                        }
                    }
                }
            }
            return 0;
        }

        private static void setFirstIndex() {
            int index = 0;
            for (int integer : sortedArray) {
                if (0 <= integer) {
                    firstIndex = index;
                    break;
                } else {
                    index++;
                }
            }
        }

        private static boolean condition(int P, int Q, int R) {
            return (P + Q > R) && (Q + R > P) && (R + P > Q);
        }

        private static void setAll(int[] A) {
            TriangularTask.setInputArray(A);
            TriangularTask.setSortedArray(A);
            TriangularTask.setFirstIndex();
            answer = TriangularTask.setAnswer();
        }

        private static void setSortedArray(int[] array) {
            Arrays.sort(array);
            sortedArray = array;
        }

        private static void setInputArray(int[] array) {
            inputArray = array;
        }
    }

    private static class SliceTask {

        private static int answer;

        private static void sliceComparator(int[] array) {
            double sliceComparator = Double.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (calculateSlice(array, i, j) < sliceComparator) {
                        sliceComparator = calculateSlice(array, i, j);
                        index = i;
                    }
                }
            }
            answer = index;

        }

        private static double calculateSlice(int[] array, int startingPoint, int endingPoint) {
            double slice = 0;
            double sum = 0;
            for (int i = startingPoint; i <= endingPoint; i++) {
                sum = sum + array[i];
            }
            slice = sum / (endingPoint - startingPoint + 1);
            return slice;
        }
    }


    public static class PassingCars {

        private static int answer;

        private static int[] numberEast;

        private static int[] passingCars;

        private static void setAll(int[] array) {

            setNumberEast(array);
            setPassingCars(array);

            setAnswer();
        }

        private static void setPassingCars(int[] array) {
            int counter;
            int index = 0;
            int[] ints = new int[numberEast.length];
            for (int integer : numberEast) {
                counter = 0;
                for (int i = integer; i < array.length; i++) {
                    if (array[i] == 1) {
                        counter++;
                    }
                }
                ints[index] = counter;
                index++;
            }
            passingCars = ints;

        }

        private static void setNumberEast(int[] array) {
            int counter = 0;
            for (int integer : array) {
                if (integer == 0) {
                    counter++;
                }
            }

            int[] ints = new int[counter];
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    ints[index] = i;
                    index++;
                }
            }
            numberEast = ints;

        }

        private static void setAnswer() {
            int sum = 0;
            for (int integer : passingCars) {
                sum = sum + integer;
            }
            answer = sum;

        }
    }

    private static class DNA {

        private static String[] query;

        private static String[] sequenceToCheck;

        private static int[] values;

        private static Map<Character, Integer> characterIntegerMap;

        private static void setAll(String S, int[] P, int[] Q) {
            DNA.setQuery(P, Q);
            DNA.setSequenceToCheck(DNA.query, S);
            DNA.setCharacterIntegerMap();
            DNA.setValues(DNA.sequenceToCheck, DNA.characterIntegerMap);
        }

        private static void setCharacterIntegerMap() {
            characterIntegerMap = new HashMap<>();
            characterIntegerMap.put('A', 1);
            characterIntegerMap.put('C', 2);
            characterIntegerMap.put('G', 3);
            characterIntegerMap.put('T', 4);
        }

        private static void setValues(String[] sequenceToCheck, Map characterIntegerMap) {
            int[] integers = new int[sequenceToCheck.length];

            for (int i = 0; i < sequenceToCheck.length; i++) {
                int variable;
                int temporary = 10;
                String s = sequenceToCheck[i];
                for (int j = 0; j < s.length(); j++) {

                    variable = (int) characterIntegerMap.get(s.charAt(j));

                    if (variable < temporary) {
                        temporary = variable;

                    }
                }

                integers[i] = temporary;
            }

            values = integers;
        }

        private static void setSequenceToCheck(String[] query,
                                               String sequence) {

            String[] strings = new String[query.length];
            for (int i = 0; i < query.length; i++) {
                int firstValue = Integer.parseInt(query[i].substring(0, query.length / 2)); // long
                int secondValue = Character.getNumericValue(query[i].charAt(1)); // long
                try {
                    strings[i] = sequence.substring(firstValue, secondValue + 1);
                } catch (StringIndexOutOfBoundsException e) {

                    strings[i] = sequence;
                }
            }
            sequenceToCheck = strings;
            System.out.println(Arrays.toString(sequenceToCheck));
        }

        private static void setQuery(int[] P, int[] Q) {
            if (P.length > Q.length) {
                String[] strings = new String[P.length];

                for (int i = 0; i < P.length; i++) {
                    strings[i] = String.valueOf(P[i]) + Q[i];
                }
                query = strings;
            } else {
                String[] strings = new String[P.length];
                for (int i = 0; i < Q.length; i++) {
                    strings[i] = String.valueOf(P[i]) + Q[i];
                }
                query = strings;
            }
            System.out.println(Arrays.toString(query));


        }

    }

    private static class SmallestPositiveInteger {
        private static int[] sortedArray;

        private static int indexOfFirstPositiveInteger;

        private static int smallestPositiveMissingInteger;

        private static int[] sortedPositiveIntegersWithoutRepetitions;

        private static void setSmallestPositiveMissingInteger() {
            int valueOfSizeFactorial = 1;
            int tempDigit = 1;

            int actualFactorial = 1;

            if (sortedPositiveIntegersWithoutRepetitions[0] != -1) {
                smallestPositiveMissingInteger = 2;
                for (int i = 0; i < sortedPositiveIntegersWithoutRepetitions.length; i++) {
                    valueOfSizeFactorial = valueOfSizeFactorial *
                            tempDigit;
                    tempDigit++;
                    System.out.println(valueOfSizeFactorial);
                }
                for (int i = 0; i < sortedPositiveIntegersWithoutRepetitions.length; i++) {
                    actualFactorial = actualFactorial * sortedPositiveIntegersWithoutRepetitions[i];
                    System.out.println(actualFactorial);
                }

                if (valueOfSizeFactorial == actualFactorial) {
                    if (sortedPositiveIntegersWithoutRepetitions[0] != 1) {
                        smallestPositiveMissingInteger = 1;
                    } else {
                        smallestPositiveMissingInteger = sortedPositiveIntegersWithoutRepetitions[sortedPositiveIntegersWithoutRepetitions.length - 1] + 1;
                    }
                } else {
                    int digit = 1;
                    for (int i = 0; i < sortedPositiveIntegersWithoutRepetitions.length; i++) {
                        if (sortedPositiveIntegersWithoutRepetitions[i] != digit) {
                            smallestPositiveMissingInteger = digit;
                        } else {
                            digit++;
                        }
                    }

                }

            } else {
                smallestPositiveMissingInteger = 1;
            }

        }

        private static void setSortedPositiveIntegersWithoutRepetitions() {
            int counter = 0;
            for (int i = indexOfFirstPositiveInteger; i < sortedArray.length; i++) {
                counter++;

            }
            int[] tempInts = new int[counter];
            for (int i = indexOfFirstPositiveInteger; i < sortedArray.length; i++) {
                tempInts[i] = sortedArray[i];

            }
            System.out.println(Arrays.toString(tempInts));
            List<Integer> integerList = new ArrayList<>();
            for (int integers : tempInts) {
                if (!integerList.contains(integers)) {
                    integerList.add(integers);
                }
            }
            System.out.println(integerList);
            sortedPositiveIntegersWithoutRepetitions = new int[integerList.size()];
            System.out.println(sortedPositiveIntegersWithoutRepetitions.length);
            int counter2 = 0;
            for (Integer integer : integerList) {
                sortedPositiveIntegersWithoutRepetitions[counter2] = integer;
                counter2++;
            }
            System.out.println(Arrays.toString(sortedPositiveIntegersWithoutRepetitions));
        }

        private static void setAll(int[] array) {
            setSortedArray(array);
            setFirstPositiveInteger(sortedArray);
            if (indexOfFirstPositiveInteger == 0) {
                setSortedPositiveIntegersWithoutRepetitions();
            } else {
                sortedPositiveIntegersWithoutRepetitions = new int[1];
                sortedPositiveIntegersWithoutRepetitions[0] = -1;
            }
            setSmallestPositiveMissingInteger();


        }


        private static void setFirstPositiveInteger(int[] sortedArray) {

            for (int i = 0; i < sortedArray.length; i++) {
                if (sortedArray[i] > 0) {
                    indexOfFirstPositiveInteger = i;
                    break;
                }
            }
            if (sortedArray[indexOfFirstPositiveInteger] <= 0) {
                indexOfFirstPositiveInteger = -1;
            }


        }

        private static void setSortedArray(int[] array) {
            int counter = 0;
            Arrays.sort(array);
            sortedArray = new int[array.length];
            for (int integer : array) {
                sortedArray[counter] = integer;
                counter++;
            }

        }
    }

    private static class JumpingFrog {

        private static int earliestSecond;

        private static int[] sortedArray;

        private static List<Integer> integerList;

        private static boolean conditionChecker;

        private static int[] inputArray;

        private static void setIntegerList(int[] sortedArray) {

            integerList = new ArrayList<>();
            for (int integer : sortedArray) {
                if (!integerList.contains(integer)) {
                    integerList.add(integer);
                }
            }
            System.out.println(integerList);
        }

        private static void setInputArray(int[] array) {
            inputArray = new int[array.length];
            int counter = 0;
            for (int integer : array) {
                inputArray[counter] = integer;
                counter++;
            }

        }

        private static void setEarliestSecond(int[] array, int x) {

            if (conditionChecker) {
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == x) {
                        earliestSecond = i;

                    }
                }
            } else {
                earliestSecond = -1;
            }

        }

        private static void setConditionChecker(int[] sortedArray, int x) {
            int series = 1;

            for (int value : sortedArray) {
                if (value == series) {
                    series = series + 1;
                }

            }
            series--;
            conditionChecker = series == x;
        }

        private static void setSortedArray(int[] array) {
            sortedArray = new int[array.length];
            Arrays.sort(array);
            int counter = 0;
            for (int integer : array) {
                sortedArray[counter] = integer;
                counter++;
            }
        }

    }


    public static class PermChecker {

        private static int[] sortedArray;

        private static boolean permutable;

        private static int answer;

        private static void setAnswer(boolean permutable) {

            if (permutable == true) {
                answer = 1;
            } else {
                answer = 0;
            }
        }

        // check if there aRE REPETITIONS
        private static void setPermutable(int[] sortedArray) {

            int forceInteger = 1;

            int temporaryForce = 1;
            int temporaryArrayForce = 1;


            for (int i = 0; i < sortedArray.length; i++) {

                temporaryForce = temporaryForce * forceInteger;


                temporaryArrayForce = temporaryArrayForce * sortedArray[i];


                if (temporaryForce != temporaryArrayForce) {
                    permutable = false;
                    break;
                } else {
                    forceInteger++;
                    permutable = true;
                }


            }


        }


        private static void setSortedArray(int[] array) {

            Arrays.sort(array);
            sortedArray = new int[array.length];
            int counter = 0;
            for (int integer : array) {
                sortedArray[counter] = integer;
                counter++;

            }

        }

    }


    private static class ArrayManager {

        private static boolean flag;

        private static int[] sortedArray;

        private static int missingElement;

        private static void findMissingElement(int[] sortedArray) {

            if (sortedArray.length == 0) {
                missingElement = 1;
            }

            if (sortedArray.length == 1) {
                if (sortedArray[0] != 1) {
                    missingElement = sortedArray[0] - 1;
                } else {
                    missingElement = sortedArray[0] + 1;
                }
            } else {
                if (sortedArray[0] != 1) {
                    missingElement = 1;
                } else {
                    int counter = 1;


                    for (int integer : sortedArray) {
                        try {

                            if (integer + 1 != sortedArray[counter]) {
                                missingElement = integer + 1;
                                break;
                            } else {
                                if (integer == sortedArray[sortedArray.length - 1]) {
                                    missingElement = integer + 1;
                                    break;
                                }
                                counter++;
                            }
                        } catch (Exception e) {
                            missingElement = integer + 1;
                        }
                    }

                }
            }
        }


        private static void setFlag(int[] array) {

            if (array.length < 1 || array.length > 100_000 || array == null) {
                flag = false;
            } else {
                int counter = 0;
                int[] integers = new int[array.length];
                Arrays.sort(array);
                for (int integer : array) {
                    integers[counter] = integer;
                    counter++;
                }

                if (integers[0] >= 0 && integers[integers.length - 1] <= 100_000) {
                    for (int integer : integers) {
                        for (int i = 0; i < integers.length; i++) {
                            if (integer == integers[i]) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    flag = true;
                    sortedArray = new int[integers.length];
                    int counter2 = 0;
                    for (int integer : integers
                    ) {
                        sortedArray[counter2] = integer;
                        counter2++;
                    }
                } else {
                    flag = false;
                }

            }

        }

    }
}
/*
private static class DNA{

        private static String[] query;

        private static String [] sequenceToCheck;

        private static int [] values;

        private static Map<Character,Integer> characterIntegerMap;

        private static void setAll(String S, int[] P, int[] Q){
            DNA.setQuery(P,Q);
            DNA.setSequenceToCheck(DNA.query,S);
            DNA.setCharacterIntegerMap();
            DNA.setValues(DNA.sequenceToCheck,DNA.characterIntegerMap);
        }

        private static void setCharacterIntegerMap (){
            characterIntegerMap = new HashMap<>();
            characterIntegerMap.put('A',1);
            characterIntegerMap.put('C',2);
            characterIntegerMap.put('G',3);
            characterIntegerMap.put('T',4);
        }

        private static void setValues (String [] sequenceToCheck, Map characterIntegerMap){
            int [] integers = new int [sequenceToCheck.length];

            for (int i = 0; i <sequenceToCheck.length ; i++) {
                int variable;
                int temporary = 10;
                String s = sequenceToCheck[i];
                for (int j = 0; j <s.length() ; j++) {

                    variable = (int) characterIntegerMap.get(s.charAt(j));

                    if (variable<temporary ){
                        temporary = variable;

                    }
                }

                integers [i] = temporary;
            }

            values = integers;
        }

        private static void setSequenceToCheck(String [] query,
                                               String sequence ){

            String [] strings = new String[query.length];
            for (int i = 0; i < query.length; i++) {
                 int firstValue =Integer.parseInt(query[i].substring(0,query.length/2)); // long
                int secondValue = Integer.parseInt(query[i].substring(query.length/2,query.length-1)); // long
                try {
                    strings[i] = sequence.substring(firstValue, secondValue+1);
                }catch (StringIndexOutOfBoundsException e){
                    strings[i] = sequence;
                }
            }
            sequenceToCheck = strings;
            System.out.println(Arrays.toString(sequenceToCheck));
        }

        private static void setQuery(int[] P, int [] Q){
            if (P.length > Q.length){
                String[] strings = new String[P.length];

                for (int i = 0; i <P.length; i++) {
                    strings[i] = String.valueOf(P[i]) + Q[i];
                }
                query = strings;
            }else{
                String[] strings = new String[P.length];
                for (int i = 0; i <Q.length; i++) {
                    strings[i] = String.valueOf(P[i]) + Q[i];
                }
                query = strings;
            }
            System.out.println(Arrays.toString(query));


        }

    }
 */