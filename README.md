fibonacci
=========

Basic program to implement an O(log2(n)) Fibonacci algorithm

The logic for this algorithm is as follows:
<table>
      <tr>
            <td>F(x)</td>
            <td>=</td>
            <td>1F(x-1) + 1F(x-2)</td>
      </tr>
      <tr>
            <td>F(x)</td>
            <td>=</td>
            <td>2F(x-2) + 1F(x-3)</td>
      </tr>
      <tr>
            <td>F(x)</td>
            <td>=</td>
            <td>3F(x-3) + 2F(x-4)</td>
      </tr>
      <tr>
            <td>F(x)</td>
            <td>=</td>
            <td>5F(x-4) + 3F(x-5)</td>
      </tr>
      <tr>
            <td colspan="3">...</td>
      </tr>
</table>

Remembering that F(1) = 1, F(2) = 1, F(3) = 2, F(4) = 3, F(5) = 5)...<br/>
<br/>
F(x)  = F(n)F(x-n+1) + F(n-1)F(x-n)<br/>
<br/>
If x is odd, we can choose n such that:<br/>
n     = x - n + 1<br/>
2n    = x + 1<br/>
2n-1  = x<br/>
<br/>
This results in the formula for odd x:<br/>
F(x) = F(n)F(2n-1-n+1) + F(n-1)F(2n-1-n)<br/>
F(x) = F(n)F(n) + F(n-1)F(n-1)<br/>
F(x) = F(n)^2 + F(n-1)^2<br/>
<br/>
For even x, we choose n:<br/>
n = x - n<br/>
2n = x<br/>
<br/>
The formula for even x:<br/>
F(x) = F(n)F(2n-n+1) + F(n-1)F(2n-n)<br/>
F(x) = F(n)F(n+1) + F(n-1)F(n)<br/>
F(x) = F(n)(F(n+1) + F(n-1))<br/>
F(x) = F(n)(F(n) + F(n-1) + F(n-1))<br/>
F(x) = F(n)^2 + 2F(n)F(n-1)<br/>
<br/>
Since these formulas use midway Fibonacci numbers, the time efficiency is roughly O(log2(n)).<br/>
See the attached spreadsheet for the midpoints used for each of the first 100 Fibonacci numbers.
