import pylab as pl

'''-------------------------------------------------------------------------------------------------------
A script to compare and plot execution duration and memory usage by a program written in Java and Python.
-------------------------------------------------------------------------------------------------------'''

# Make x, y arrays for each graph
java_x_axis = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] # Java program execution count
javaDurations = [8, 2, 1, 1, 2, 1, 2, 2, 2, 3] # Java program execution durations
python_x_axis = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] # Python program execution count
pythonDurations = [195, 70, 25, 35, 93, 26, 36, 27, 67, 67] # Python program execution durations

# use pylab to plot x and y
pl.plot(java_x_axis, javaDurations, 'r')
pl.plot(python_x_axis, pythonDurations, 'g')

# give plot a title
pl.title('Plot of Java vs. Python')

# make axis labels
pl.xlabel('Number of Execution')
pl.ylabel('Program Duration (in ms.)')

# set axis limits
pl.xlim(0.0, 12.0)
pl.ylim(0.0, 200.0)

# show the plot on the screen
pl.show()

