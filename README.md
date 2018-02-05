# CPUCrawler
## Teacher's Requests

Go to the geekbench website, and plot the “speedup” achieved every year in the results for geekbench 3.

For each semester of a given Year, plot the fastest score for single core and multicore.

If a semester has only slower results or no results, use the data from last semester. This means that the line should never decrease.

The main plot is from 2006 to 2017, and the mobile (android) is from 2012 (not older data available).

To find the CPU per Year, look at this:
<br>
https://browser.geekbench.com/processor-benchmarks
<br>
https://browser.geekbench.com/android-benchmarks


## Potential Problems
Problem1:
Getting the performance score is easy, but it is a little bit tricky to get the released date. <br>
<br>
Problem2:
There are too much data. Maybe we should use multi-thread crawler. Be careful about thread safe.


## My Plan and Implement
### ( I was using geekbench 4 )

First thing first, I will crawl all the performance score for each PC/mobile CPU, and store it in four different .csv files.

Then I will crawl all the PC/mobile CPU names and their released dates, and store it in other four different .csv files.

For those released dates, I found that there are some
missing and maybe need more processing. Luckily, there wasn't much, so I fixed them by hand.

Next step is finding best score for each semester, then
store the result in four different .csv files.

Finally, visualize results based on .csv files.


## Final Visualization

I'm using d3.js to do the visualization. It has many useful APIs for drawing line charts.

But before that, I need to convert those .csv score files to one .csv file suitable for d3.js. I wrote another java class to help me with this job.(See web/finalCSV.csv)

After adding javascript codes to the html, the final plot chart looks like this: (See web/scorePlot.html)

![Score Plot](https://github.com/ZiyeHan/CPUCrawler/tree/master/src/main/java/com/chris/cpu/web/scorePlot.png)


<br>
