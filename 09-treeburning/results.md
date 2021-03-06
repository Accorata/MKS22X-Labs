1. Why did you choose the board size for your finalized table?

I choose 100 as the finalized board size for three reasons. One, 100 is a common number and directly correlates to percentages making comparison to density easier. Two, 100 created a size in which the density that led to the maximum burn size was close to what it reaches as size increases but still far enough away to show the density isn't exactly 0.6. Finally, 100 is a small enough number to allow for numerous tests and therefore more accurate results.

2. Why did you choose the number of repetitions size for your finalized table?

I choose 5000 repetitions as the variations between averages of different tests were very minor with this amount of repetitions, and it didn't seem necessary to increase repetitions as the time necessary would end up quite high.

3. What did your testing show about changing the board size?

At smaller sizes, changing the size had larger effects, making densities like 0.80 the best. But as the board sized got larger and larger, the best density converged on 0.60.

Size | Best Density
:---:|:---:
5 | 0.79
10 | 0.71
20 | 0.68
50 | 0.62
100 | 0.61
200 | 0.60

4. Knowing that there were differences based on boardsize, what was the relationship between the board size and the maximum burn time? How did you test this?

I found that the relationship between maximum burn time and size to be y = x * (1 + the 14th root of x) where y is the maximum burn time and x is the size. I found this by taking the points below and plotting them in Desmos. Then I applied transformations to each of them, keeping track of what I had done, to get a sense of what the line of best fit might look like. I tested what I found afterwards against those points and made a few more adjustments to arrive at that relationship.

Size | Maximum Burn Time
:---:|:---:
5 | 6.629
10 | 14.967
20 | 33.314
50 | 93.034
100 | 205.081
300 | 708.045
500 | 1266.342

5. What density of trees yields the maximum burn time?

The optimal density is 0.60 for large numbers (over 100 or so) and up to that point the optimal density generally follows the equation y = (3x + 5)/5x where y is the density and x is the size.

Exact Results:

Density: (100x100 Size)|Average Maximum Time: (5000 Repetitions)
:---:|:---:
|Size 100
0.05 | 1.2592
0.10 | 1.9344
0.15 | 2.7864
0.20 | 3.8024
0.25 | 4.9976
0.30 | 6.5726
0.35 | 8.8842
0.40 | 12.4428
0.45 | 18.462
0.50 | 30.5662
0.55 | 66.3846
0.60 | 191.7994
0.65 | 173.7554
0.70 | 145.158
0.75 | 131.184
0.80 | 122.1704
0.85 | 115.7058
0.90 | 110.624
0.95 | 106.1658

Density: (100x100 Size)|Average Maximum Time: (5000 Repetitions)
:---:|:---:
0.60 | 191.648
0.61 | 205.2198
0.62 | 203.7632
0.63 | 193.8608
0.64 | 183.7104
0.65 | 173.897
