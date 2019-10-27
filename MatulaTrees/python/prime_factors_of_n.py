# Brittni Watkins
# CSE 8355
# Prime Factors of N Module
# 6 December 2018

import sys
from prime_factorization_request import printPrimeFactorization

def main():

    if (len(sys.argv) >= 2):
        n = sys.argv[1]
        printPrimeFactorization(n)
    else:
        print('Invalid number of command line arguments.')

if __name__ == '__main__':
    main()
