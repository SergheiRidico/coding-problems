const args: string[] = process.argv.slice(2);
let array: Array<number> = []

if(args.length < 2) {
    console.log("Number of input arguments is less then 2! Default array is used:")
    array = [18, 2, 3, 3, 44, 0, 77, -99, -42, 82]
    console.log(array)
} else {
    for(let argument of args) {
        array.push(Number(argument))
    }
}

findMaximums(array)


function findMaximums(array: number[]) {
    let firstMaximum = Number.MIN_VALUE
    let secondMaximum = Number.MIN_VALUE

    for(let i: number = 0; i < array.length; i++) {
        let value = array[i]

        if(value > firstMaximum) {
            secondMaximum = firstMaximum
            firstMaximum = value
        } else if(value != firstMaximum && value > secondMaximum) {
            secondMaximum = value
        }
    }

    if(secondMaximum == Number.MIN_VALUE) {
        console.log("There is no second largest number in array.\n" +
        `Or array contains minimal numeric value: ${Number.MIN_VALUE}.\n` +
        `Or it contains only duplicates.\n` +
        `Please try again with another input!\n`)

        return
    }

    console.log(`First maximum is: ${firstMaximum}`)
    console.log(`Second maximum is: ${secondMaximum}`)
}
