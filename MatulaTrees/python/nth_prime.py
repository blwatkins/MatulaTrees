# Brittni Watkins
# CSE 8355
# Nth Prime Module
# 25 October 2018

# Use command line arguments from the user to send nth prime request
# Information on using command line arguments found at https://www.tutorialspoint.com/python/python_command_line_arguments.htm


import sys
from nth_prime_request import printNthPrime


def main():

    if (len(sys.argv) >= 2):
        n = sys.argv[1]
        printNthPrime(n)
    else:
        print('Invalid number of command line arguments.')


if __name__ == '__main__':
    main()
