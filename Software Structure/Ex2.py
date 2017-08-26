import hashlib
import json
import time
from memory_profiler import profile

'''------------------------------------------------------------------
This class encrypts the passwords read from a json file using SHA256.
This is the same program as the Java program with the same name,
except for the password encryption protocol.
------------------------------------------------------------------'''

class Hash_Pwds_JSON:
    @profile # this label is used by the memory profiler, it tells the profiler what to analyze.
    def __init__(self):
        pass

    # This function reads a file and encrypts the password of each user.
    @profile # this label is used by the memory profiler, it tells the profiler what to analyze.
    def hashPasswords(self):
        try:

            # Read json file.
            with open('files/j.json', 'r') as data_file:
                json_data = data_file.read()

                # Load the file as json objects.
                data = json.loads(json_data)
                for element in data:

                    # Encrypt the each user's password with SHA256 algorithm.
                    hashed_password = hashlib.sha256(str(element["password"]))

                    # Replace original password with hashed password.
                    element["password"] = hashed_password.hexdigest() # Hexdigest() is used to make the hashed password readable.

            # Write username and hashed password to a file.
            with open('files/data.txt', 'w') as outfile:
                json.dump(data, outfile)

        # Catch a general exception if one is thrown.
        except Exception, e:
            print(e.message)

# Main function.
if __name__ == '__main__':
	
    arr = [] # An array of execution durations.

    # run the program 10 times and collect execution durations.
    for i in range(0, 9):
        start_time = time.time()
        Hash_Pwds_JSON().hashPasswords()
        end_time = time.time()

        result = end_time - start_time
        arr.append(result)


    # Print execution durations results.
    for i in arr:
        print("{}").format(i)


'''--------------------------------------------
Execution duration and memory used results.
--------------------------------------------'''

'''Program Duration

0.0195410251617
0.00702500343323
0.00257086753845
0.00359606742859
0.00931715965271
0.00266599655151
0.00362277030945
0.00270104408264
0.00675106048584

'''

'''Memory Profiler results

Line #    Mem usage    Increment   Line Contents
================================================
    16     29.7 MiB      0.0 MiB       @profile
    17                                 def hashPasswords(self):
    18     29.7 MiB      0.0 MiB           try:
    19                             
    20                                         # Read json file.
    21     29.7 MiB      0.0 MiB               with open('files/j.json', 'r') as data_file:
    22     29.7 MiB      0.0 MiB                   json_data = data_file.read()
    23                             
    24                                             # Load the file as json objects.
    25     29.7 MiB      0.0 MiB                   data = json.loads(json_data)
    26     29.7 MiB      0.0 MiB                   for element in data:
    27                             
    28                                                 # Encrypt the each user's password with SHA256 algorithm.
    29     29.7 MiB      0.0 MiB                       hashed_password = hashlib.sha256(str(element["password"]))
    30                             
    31                                                 # Replace original password with hashed password.
    32     29.7 MiB      0.0 MiB                       element["password"] = hashed_password.hexdigest() # Hexdigest() is used to make the hashed password readable.
    33                             
    34                                         # Write username and hashed password to a file.
    35     29.7 MiB      0.0 MiB               with open('files/data.txt', 'w') as outfile:
    36     29.7 MiB      0.0 MiB                   json.dump(data, outfile)
    37                             
    38                             
    39                                     except Exception, e:
    40                                         print(e.message)

'''