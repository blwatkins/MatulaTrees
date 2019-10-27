# Brittni Watkins
# CSE 8355
# Nth Prime Request
# 25 October 2018

# Use requests to send a POST request to https://primes.utm.edu/nthprime/index.php
# Use BeautifulSoup to scrape the HTML response for correct information
# Information on sending POST requests found at https://www.geeksforgeeks.org/get-post-requests-using-python/

import requests
import bs4
import re
from bs4 import BeautifulSoup


URL = 'https://primes.utm.edu/nthprime/index.php'


def outputNthPrime(num):
    nthPrime = getNthPrime(num)
    print('Prime number ' + str(num) + ' is ' + str(nthPrime))

    with open('nthPrime.txt', 'w') as myFile:
        myFile.write(str(nthPrime) + '\n')
        myFile.close()


def printNthPrime(num):
    nthPrime = getNthPrime(num)
    print(nthPrime)


def outputPiOf(n):
    piOfN = getPiOf(n)
    print('Pi(' + str(n) + ') = ' + str(piOfN))

    with open('piOfN.txt', 'w') as myFile:
        myFile.write(str(piOfN) + '\n')
        myFile.close()


def printPiOf(n):
    piOfN = getPiOf(n)
    print(piOfN)


def getNthPrime(num):
    html = getNthPrimeHTML(num)
    nthPrime = findNthPrime(html)
    return nthPrime


def getPiOf(n):
    html = getPiHTML(n)
    piOfN = findPi(html)
    return piOfN


def getNthPrimeHTML(num):
    data = {'n': num}
    r = requests.post(url = URL, data = data, verify=False)
    return r.text


def getPiHTML(n):
    data = {'x': n}
    r = requests.post(url = URL, data = data, verify=False)
    return r.text


def findNthPrime(html):
    bs = getBeautifulSoup(html)
    nthPrimeTag = findNthPrimeTag(bs)

    if (nthPrimeTag != None):
        nthPrime = extractNthPrime(nthPrimeTag)
        return nthPrime
    else:
        return -1


def findPi(html):
    bs = getBeautifulSoup(html)
    piTag = findPiTag(bs)

    if (piTag != None):
        piOfN = extractPiOfN(piTag)
        return piOfN
    else:
        return -1


def getBeautifulSoup(html):
    bs = BeautifulSoup(html, 'html.parser')
    return bs


def findNthPrimeTag(bs):
    boldTags = bs.find_all('b')

    if len(boldTags) >= 6:
        nthPrimeTag = boldTags[5]
        return nthPrimeTag
    else:
        return None


def findPiTag(bs):
    boldTags = bs.find_all('b')

    if (len(boldTags) >= 6):
        piTag = boldTags[5]
        return piTag
    else:
        return None


def extractNthPrime(nthPrimeTag):
    nthPrime = -1
    nthString = nthPrimeTag.getText().strip()
    primeMatch = re.match(r'The \d+(,\d{3})*?(st|nd|rd|th) prime is (?P<primeNum>\d+(,\d{3})*?)[.]', nthString)

    if (primeMatch != None):
        primeString = primeMatch.group('primeNum')
        primeString = re.sub(r',', '', primeString)
        nthPrime = int(primeString)

    return nthPrime


def extractPiOfN(piTag):
    piOfN = -1
    piString = piTag.getText().strip()
    piMatch = re.match(r'There (are|is) (?P<pi>\d+(,\d{3})*?) prime(s)? less than or equal to \d+(,\d{3})*?[.]', piString)
    
    if (piMatch != None):
        piOfNString = piMatch.group('pi')
        piOfNString = re.sub(r',', '', piOfNString)
        piOfN = int(piOfNString)

    return piOfN


def main():
    print('Nth Prime Request Module')


if __name__ == '__main__':
    main()
