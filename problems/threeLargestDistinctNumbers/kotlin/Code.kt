fun main(args: Array<String>) {
    var array = intArrayOf(1, 22, 43, -87, -99, 99, 99, 14, 83, -25, 0, 15)

    if (args.size < 3) {
        println("Number of input arguments is less then 3! Default array is used:")
        println(array.contentToString())
    } else {
        val intArray = IntArray(args.size)

        for (i in args.indices) {
            intArray[i] = args[i].toInt()
        }

        array = intArray
    }

    findThreeLargestDistinctNumbers(array)
}

fun findThreeLargestDistinctNumbers(array: IntArray) {
    var first = Int.MIN_VALUE
    var second = Int.MIN_VALUE
    var third = Int.MIN_VALUE

    for (i in array) {
        if (i > first) {
            third = second
            second = first
            first = i
        } else if (i > second && i != first) {
            third = second
            second = i
        } else if (i > third && i != first && i != second) {
            third = i
        }
    }

    if (third == Int.MIN_VALUE) {
        println("There are no three largest distinct numbers in your array. \n" +
                "Or array contains minimal integer value: -2147483648. \n" +
                "Or it contains only duplicates. \n" +
                "Please try again with another input!")
        return
    }

    println("First largest distinct number: $first")
    println("Second largest distinct number: $second")
    println("Third largest distinct number: $third")
}
