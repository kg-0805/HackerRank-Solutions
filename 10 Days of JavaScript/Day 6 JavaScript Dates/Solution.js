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

// The days of the week are: "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
function getDayName(dateString) {
    let dayName;
    // Write your code here
    var date = new Date(dateString),
        getDay = date.getDay();
    switch(getDay) {
        case 0:
            return dayName = 'Sunday';
        case 1:
            return dayName = 'Monday';
        case 2:
            return dayName = 'Tuesday';
        case 3:
            return dayName = 'Wednesday';
        case 4:
            return dayName = 'Thursday';
        case 5:
            return dayName = 'Friday';
        case 6:
            return dayName = 'Saturday';
        default:
            return 'invalid date';
    }
}

function main() {
    const d = +(readLine());
    
    for (let i = 0; i < d; i++) {
        const date = readLine();
        
        console.log(getDayName(date));
    }
}