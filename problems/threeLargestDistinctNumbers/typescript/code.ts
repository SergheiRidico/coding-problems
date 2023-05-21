// The first two elements are 'node' and 'yourScript.ts', so we slice them off
const args: string[] = process.argv.slice(2)
let array: number[] = []

if (args.length < 3) {
    console.log("Number of input arguments is less then 3! Default array is used:")
    array = [-22, 18, -14, 0, 0, 15, 76, 83, 9]
    console.log(array)
} else {
    for (let argument of args) {
        array.push(Number(argument))
    }
    console.log(array)
}

findMaximums(array)


function findMaximums(array: number[]) {
    let firstMaximum = Number.NEGATIVE_INFINITY
    let secondMaximum = Number.NEGATIVE_INFINITY
    let thirdMaximum = Number.NEGATIVE_INFINITY

    for (let i = 0; i < array.length; i++) {
        let temp = array[i]

        if (temp > firstMaximum) {
            thirdMaximum = secondMaximum
            secondMaximum = firstMaximum
            firstMaximum = temp
        } else if (temp < firstMaximum && temp > secondMaximum) {
            thirdMaximum = secondMaximum
            secondMaximum = temp
        } else if (temp < secondMaximum && temp > thirdMaximum) {
            thirdMaximum = temp
        }
    }

    if (thirdMaximum === Number.NEGATIVE_INFINITY) {
        console.log("There are no three distinct numbers in array. \n" +
            `Or array contains minimal numeric value: ${Number.NEGATIVE_INFINITY}. \n` +
            "Or it contains only duplicates. \n" +
            "Please try again with another input!")

        return
    }

    console.log(`First maximum is: ${firstMaximum}`)
    console.log(`Second maximum is: ${secondMaximum}`)
    console.log(`Third maximum is: ${thirdMaximum}`)
}