package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
)

func main() {
	array := []int{-85, 22, 0, 12, 15, 15, -54, 87, 64, 28}

	args := os.Args[1:]

	if len(args) < 3 {
		fmt.Println("Number of input arguments is less then 3! Default array is used:")
		fmt.Println(array)
	} else {
		fmt.Println(args)

		var parsedArray []int

		for i := 0; i < len(args); i++ {
			num, err := strconv.Atoi(args[i])
			if err != nil {
				panic(err)
			}
			parsedArray = append(parsedArray, num)
		}

		array = parsedArray
	}

	findMaximums(array)
}

func findMaximums(array []int) {
	firstMaximum := math.MinInt
	secondMaximum := math.MinInt
	thirdMaximum := math.MinInt

	for i := 0; i < len(array); i++ {
		var temp = array[i]
		if temp > firstMaximum {
			thirdMaximum = secondMaximum
			secondMaximum = firstMaximum
			firstMaximum = temp
		} else if temp < firstMaximum && temp > secondMaximum {
			thirdMaximum = secondMaximum
			secondMaximum = temp
		} else if temp < secondMaximum && temp > thirdMaximum {
			thirdMaximum = temp
		}
	}

	if thirdMaximum == math.MinInt {
		println("There are no three distinct numbers in array. \n" +
			"Or array contains minimal integer value: -9223372036854775808. \n" +
			"Or it contains only duplicates. \n" +
			"Please try again with another input!")
		return
	}

	fmt.Printf("First maximum is: %v\n", firstMaximum)
	fmt.Printf("Second maximum is: %v\n", secondMaximum)
	fmt.Printf("Third maximum is: %v\n", thirdMaximum)
}
