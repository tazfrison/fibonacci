fibonacci
=========

Basic program to implement an O(log2(n)) Fibonacci algorithm

The logic for this algorithm is as follows:

F(x)  = 1F(x-1) + 1F(x-2)
      = 2F(x-2) + 1F(x-3)
      = 3F(x-3) + 2F(x-4)
      = 5F(x-4) + 3F(x-5)
      ...

Remembering that F(1) = 1, F(2) = 1, F(3) = 2, F(4) = 3, F(5) = 5)...

F(x)  = F(n)F(x-n+1) + F(n-1)F(x-n)

If x is odd, we can choose n such that:
n     = x - n + 1
2n    = x + 1
2n-1  = x

This results in the formula for odd x:
F(x)  = F(n)F(2n-1-n+1) + F(n-1)F(2n-1-n) Replace x's with 2n-1
F(x)  = F(n)F(n) + F(n-1)F(n-1)           Cancel out
F(x)  = F(n)^2 + F(n-1)^2                 Clean up

For even x, we choose n:
n   = x - n
2n  = x

The formula for even x:
F(x)  = F(n)F(2n-n+1) + F(n-1)F(2n-n)     Replace x's with 2n
F(x)  = F(n)F(n+1) + F(n-1)F(n)           Cancel out
F(x)  = F(n)(F(n+1) + F(n-1))             Factor out F(n)
F(x)  = F(n)(F(n) + F(n-1) + F(n-1))      Expand F(n+1) = F(n) + F(n-1)
F(x)  = F(n)^2 + 2F(n)F(n-1)              Clean up

Since these formulas use midway Fibonacci numbers, the time efficiency is roughly O(log2(n)).
See the attached spreadsheet for the midpoints used for each of the first 100 Fibonacci numbers.
