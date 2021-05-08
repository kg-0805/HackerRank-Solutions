'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}


function main() {
    // Declare a variable i and initialize with integer value
    var i = 4;
    
    // Declare a variable d and initialize with decimal value
    var d = 4.0;
    
    // Declare a variable s and initialize with string value
    var s = "HackerRank ";

    // Read the integer from the stdin and save to your variable.
    var int = readLine();
    var num = parseInt(int)
    //console.log(int);
    
    // Read the decimal from the stdin and save to your variable.
    var dec = parseFloat(readLine());
    //console.log(dec);
    
    // Read the string from the stdin and save to your variable.
    var string = readLine()
    //console.log(string);
    
    // Print the sum of both the integer variables on a new line.
    var intSum = i + num;
    console.log(intSum)
    
    // Print the sum of the double variables on a new line.
    var decSum = dec + d;
    console.log(decSum)
    
    // Concatenate and print the String variables on a new line. The variable 's' should be printed first.
    var stringSum = s + string;
    console.log(stringSum)
}
-

function main() {
    const secondInteger = readLine();
    const secondDecimal = readLine();
    const secondString = readLine();
    
    performOperation(secondInteger, secondDecimal, secondString);
}