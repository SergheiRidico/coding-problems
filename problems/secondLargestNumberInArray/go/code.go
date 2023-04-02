package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
)

func main() {
	array := []int{99, 82, -34, 3, 15, 76, 102, 14, 82, 82, 99}

	// Argument with index zero is always program name
	args := os.Args[1:]

	if len(args) < 2 {
		fmt.Println("Number of input arguments is less then 2! Default array is used:")
		fmt.Println(array)
	} else {
	    fmt.Println(args)

		var array2 []int

		for i:=0; i<len(args); i++ {
			num, err := strconv.Atoi(args[i])
			if err != nil {
				panic(err)
			}
			array2 = append(array2, num)

		}

		array = array2
	}


	findMaximums(array)
}

func findMaximums(array []int) {
	firstMaximum := math.MinInt
	secondMaximum := math.MinInt

	for i:=0; i<len(array); i++ {
		if array[i]> firstMaximum {
			secondMaximum = firstMaximum
			firstMaximum = array[i]
		} else if array[i]<firstMaximum && array[i]> secondMaximum {
			secondMaximum = array[i]
		}
	}

	if (secondMaximum == math.MinInt32) {
        println("There is no second largest number in array. \n" +
                "Or array contains minimal integer value: -9223372036854775808. \n" +
                "Or it contains only duplicates. \n" +
                "Please try again with another input!")
        return
    }

	fmt.Printf("First maximum is: %v\n", firstMaximum)
	fmt.Printf("Second maximum is: %v\n", secondMaximum)
}
