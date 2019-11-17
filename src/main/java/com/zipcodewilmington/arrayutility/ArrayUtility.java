package com.zipcodewilmington.arrayutility;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    private T[] array;

    public ArrayUtility(T[] inputArray){
        this.array = inputArray;
    }

    private T[] mergeArrays(T[] array1, T[] array2){
        Integer newArrayLength = array1.length + array2.length;
        T[] mergedArray = Arrays.copyOf(array1, newArrayLength);
        for (int i = 0; i < array2.length; i++){
            mergedArray[array1.length+i] = array2[i];
        }
        return mergedArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] mergedArray = mergeArrays(this.array, arrayToMerge);

        return Collections.frequency(Arrays.asList(mergedArray), valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove) {
        Integer index = 0;
        Integer counter = Collections.frequency(Arrays.asList(this.array), valueToRemove);
        T[] newArray = Arrays.copyOf(this.array, this.array.length- counter);
        for (int i = 0; i < array. length; i++){
            if (this.array[i] == valueToRemove){
                this.array[i] = null;
            }
        }
        for (int i =0; i < array.length; i++){
            if (this.array[i] != null){
                newArray[index] = this.array[i];
                index++;
            }
        }
        return newArray;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] mergedArray = mergeArrays(this.array, arrayToMerge);
        Integer counter = 0;
        T mostCommon = null;
        for (T t : mergedArray){
            if (Collections.frequency(Arrays.asList(mergedArray), t) > counter){
                mostCommon = t;
                counter = Collections.frequency(Arrays.asList(mergedArray), t);
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer counter = 0;
        for (T t : this.array){
            if (t == valueToEvaluate){
                counter++;
            }
        }
        return counter;
    }
}
