# CPUCrawler

## Teacher's Requests

Go to the geekbench website, and plot the “speedup” achieved every year in the results for geekbench 3.

For each semester of a given Year, plot the fastest score for single core and multicore.

If a semester has only slower results or no results, use the data from last semester. This means that the line should never decrease.

The main plot is from 2006 to 2017, and the mobile (android) is from 2012 (not older data available).

To find the CPU per Year, look at this:
https://browser.geekbench.com/processor-benchmarks

## Potential Problems
Problem1:
Getting the performance score is easy, but it is a little bit tricky to get the released date. <br>
<br>
Problem2:
There are too much data.

## My Plan
First thing first, I will crawl all the performance score for each CPU, and store it in two different .csv files.

Then I will crawl all the CPU names and their released dates, and store it in two different .csv files.


<br>
