# Brittni Watkins
# CSE 8355
# Prime Factorization Request
# 6 December 2018

import requests
import bs4
import re
from bs4 import BeautifulSoup

URL = 'https://www.calculatorsoup.com/calculators/math/prime-factors.php'

def printPrimeFactorization(string):
    num = getInteger(string)

    if (num is not None):
        html = getPrimeFactorizationHTML(num)

        if (html is not None):
            primeFactors = findPrimeFactorization(html)
            printFactors(primeFactors)
        else:
            print('Not a valid number')

    else:
        print('Not a number')

def printFactors(factors):

    for factor in factors:
        print(factor)

def getInteger(numString):
    x = -1

    try:
        x = int(numString)
    except (Exception):
        x = None

    return x

def getPrimeFactorizationHTML(num):
    if (num > 0 and num <= 1000000000000):
        data = {'x': num, 'action': 'solve'}
        r = requests.post(url = URL, data = data, verify=False)
        return r.text
    else:
        return None

def findPrimeFactorization(html):
    bs = getBeautifulSoup(html)
    primeFactorsText = findPrimeFactorizationText(bs)
    primeFactors = extractPrimeFactorization(primeFactorsText)
    return primeFactors

def getBeautifulSoup(html):
    bs = BeautifulSoup(html, 'html.parser')
    return bs

def findPrimeFactorizationText(bs):
    answerDiv = bs.find('div', id='answer')
    innerDivs = answerDiv.find_all('div')
    numDivs = len(innerDivs)
    text = ''

    if (numDivs == 0):
        text = answerDiv.text.strip()
    else:
        text = innerDivs[2].text.strip()

    return text

def extractPrimeFactorization(text):
    factors = []
    compositeMatch = re.match(r'CSV Format:(?P<primes>\d+(, \d+)*)', text)
    primeMatch = re.match(r'(?P<prime>\d+) is a prime number', text)

    if compositeMatch is not None:
        factorsString = compositeMatch.group('primes')
        factorsString = re.sub(r' ', '', factorsString)
        factors = [int(x) for x in factorsString.split(',')]
    else:
        primeString = primeMatch.group('prime')
        factors = [int(primeString)]

    return factors

def main():
    "Prime Factorization Module"

if __name__ == '__main__':
    main()
