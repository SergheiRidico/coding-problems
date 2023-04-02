fun main(args: Array<String>) {
    var array = intArrayOf(-23, 99, 1, 2, 3, 4, 5, 6, 7, 8, 8)

    if (args.size < 2) {
        println("Number of input arguments is less then 2! Default array is used:")
        println(array.contentToString())
    } else {
        val intArray = IntArray(args.size)

        for(i in args.indices) {
            intArray[i] = args[i].toInt()
        }

        array = intArray
    }

    findMaximums(array)
}

fun findMaximums(array: IntArray) {
    var firstMaximum = Int.MIN_VALUE
    var secondMaximum = Int.MIN_VALUE

    for (i in array) {
        if (i > firstMaximum) {
            secondMaximum = firstMaximum
            firstMaximum = i
        } else if (i < firstMaximum && i > secondMaximum) {
            secondMaximum = i
        }
    }

    if (secondMaximum == Int.MIN_VALUE) {
        println("There is no second largest number in array. \n" +
                "Or array contains minimal integer value: -2147483648. \n" +
                "Or it contains only duplicates. \n" +
                "Please try again with another input!")
        return
    }
    println("First maximum is: $firstMaximum")
    println("Second maximum is: $secondMaximum")
}

