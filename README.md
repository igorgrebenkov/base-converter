* * *

# base-converter

* * *

mouse-free base conversion between binary/octal/decimal/hex

* * *

**Author:** Igor Grebenkov

**Source:** [https://github.com/igorgrebenkov/base-converter](https://github.com/igorgrebenkov/base-converter)

* * *

### Why another base converter?

* * *

Many of the base converters I've used possess a few annoying traits:

1.  The user must interact with some gui element to select the desired base for conversion.
2.  The user must interact with some gui element to specify the base of the input digits.

This application aims to solve these problems by,

1.  Displaying result of conversion to binary/octal/decimal/hex simultaneously.
2.  Indicating the input base using a one character prefix before the input digits.

In addition, a number of keyboard shortcuts have been implemented for copying input/output fields to the clipboard, as well as clearing the input field.

This enables the user to quickly convert between bases and save the results, without ever having to use a mouse.

* * *

### How to Use It

* * *

The first character in the input field must be one of the following:

*   % - binary input
*   @ - octal input
*   # - decimal input
*   $ - hex input

Valid input digits following the prefix character will be converted as they are entered in real-time.

For example, to enter the binary digit 1010 for conversion, the user must input:

*   %1010

To enter the hex number 3A,

*   $3A

and so on.

Using a digit incompatible with a prefix will present the user with the error message, "invalid number".

For example,

*   %10012

is invalid because there is no 2 digit in binary.

**Note:** Whitespace is ignored in user input, so the following are also valid inputs:

*   %1010 0110
*   $3A 4E 6F
*   %1 0 111 0 1111

* * *

### Keyboard Shortcuts

* * *

A number of keyboard shortcuts are available to copy the input/output fields to the clipboard.

*   CTRL + 5 - copy binary output field
*   CTRL + 2 - copy octal output field
*   CTRL + 3 - copy decimal output field
*   CTRL + 4 - copy hex output field
*   CTRL + i - copy input field
*   CTRL + c - clear input field

The first four keyboard shortcuts were chosen because they correspond to the number keys associated with input prefixes.

For example, *SHIFT+5* is the *%* character, and so *CTRL+5* is its associated copy shortcut.

* * *

### Output Formatting

* * *

The conversion output is automatically spaced accordingly

#### Binary

Groups of 4 bits, with zero padding.

*   10100111 becomes 1010 0111
*   111101101 becomes 0001 1110 1101

#### Octal

Groups of 3 digits, with zero padding.

*   134252 becomes 134 252
*   1634152 becomes 001 634 152

#### Decimal

Grouped in thousands. No zero padding.

*   10000 becomes 10 000
*   1100000 becomes 1 100 000.

#### Hex

Groups of 2 digits (8 bits), with zero padding.

*   3A6F becomes 3A 6F
*   5B7A1 becomes 05 B7 A1