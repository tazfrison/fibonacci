package tazfrison.fibonacci;

import java.util.Scanner;

public class fibonacci
{
	/***
	 * Function to calculate the log base 2 for an integer. Taken from stack
	 * overflow:
	 * http://stackoverflow.com/questions/3305059/how-do-you-calculate-log
	 * -base-2-in-java-for-integers
	 * 
	 * @param n
	 *          The integer to get the log of.
	 * @return The log base 2 of n.
	 */
	public static int log2 ( int n )
	{
		if ( n <= 0 )
			throw new IllegalArgumentException();
		return 31 - Integer.numberOfLeadingZeros( n );
	}

	/***
	 * Calculate the an odd Fibonacci number Fib(x) using midway points.
	 * 
	 * @param m
	 *          Fib((x+1)/2)
	 * @param n
	 *          Fib((x-1)/2)
	 * @return Fib(x)
	 */
	public static long oddFibonacci ( long m, long n )
	{
		return (long) (Math.pow( m, 2 ) + Math.pow( n, 2 ));
	}

	/***
	 * Calculate the an even Fibonacci number Fib(x) using midway points.
	 * 
	 * @param m
	 *          Fib(x/2)
	 * @param n
	 *          Fib((x/2)-1)
	 * @return Fib(x)
	 */
	public static long evenFibonacci ( long m, long n )
	{
		return (long) Math.pow( m, 2 ) + 2 * m * n;
	}

	public static void main ( String[] args )
	{
		Scanner in = new Scanner( System.in );
		int goal = in.nextInt();
		long midpoints[];
		long tempMidpoints[];
		int iterations;
		float midpoint;
		long iterMidpoint;
		int seeds[] = {
				0, 1, 1, 2
		};
		while ( goal > 0 )
		{
			midpoints = new long[] {
					0, 1, 1
			};
			iterations = log2( goal ) - 1;
			midpoint = goal / (float) (1 << (int) iterations);

			if ( goal < seeds.length )
			{// For small values
				System.out.print( "Fib(" + goal + ") = " + seeds[goal] + "\n"  );
			}
			else
			{
				iterMidpoint = (int) Math.ceil( midpoint );

				if ( iterMidpoint % 2 == 0 )
				{
					if ( iterMidpoint == 2 )
					{
						midpoint *= 2;
						--iterations;
					}
					midpoints[0] = seeds[2]; // Fib(2)
					midpoints[1] = seeds[3]; // Fib(3)
					midpoints[2] = seeds[2] + seeds[3]; // Fib(4)
				}
				else
				// iterMidpoint == 3
				{
					midpoints[0] = seeds[1]; // Fib(1)
					midpoints[1] = seeds[2]; // Fib(2)
					midpoints[2] = seeds[3]; // Fib(3)
				}
				midpoint *= 2;
				for ( int i = 0; i < iterations; ++i )
				{
					tempMidpoints = new long[3];
					iterMidpoint = (int) Math.ceil( midpoint );
					if ( iterMidpoint % 2 == 0 )
					{
						tempMidpoints[0] = evenFibonacci( midpoints[1], midpoints[0] );
						tempMidpoints[1] = oddFibonacci( midpoints[2], midpoints[1] );
						tempMidpoints[2] = evenFibonacci( midpoints[2], midpoints[1] );
					}
					else
					{
						tempMidpoints[0] = oddFibonacci( midpoints[1], midpoints[0] );
						tempMidpoints[1] = evenFibonacci( midpoints[1], midpoints[0] );
						tempMidpoints[2] = oddFibonacci( midpoints[2], midpoints[1] );
					}
					midpoints = tempMidpoints;
					midpoint *= 2;
				}
				System.out.print( "Fib(" + goal + ") = " + midpoints[2] + "\n" );
			}

			goal = in.nextInt();
		}
		in.close();
	}

}
