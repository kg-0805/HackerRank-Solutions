#!/bin/python3

import math
import os
import random
import re
import sys


n = int(input())
if n%2==1 or n in range (5,21):
    print("Weird")
else:
    print("Not Weird")
