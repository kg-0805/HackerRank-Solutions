import sys
from collections import OrderedDict

class MapReduce:
    def __init__(self):
        self.intermediate = OrderedDict()
        self.result = []

    def emitIntermediate(self, key, value):
        self.intermediate.setdefault(key, [])       
        self.intermediate[key].append(value)

    def emit(self, value):
        self.result[value[0]][value[1]] = value[2] 

    def execute(self, matrix1, matrix2, mapper, reducer):
        n = len(matrix1) #number of rows in new matrix
        m = len(matrix2[0]) #number of columns in new matrix
        for i in xrange(0,n):
            self.result.append([0]*m)
        
        mapper(matrix1, matrix2)

        for key in self.intermediate:
            reducer(key, self.intermediate[key])

        for i in xrange(0,n):
            row = ""
            for j in xrange(0,m):
                 row += str(self.result[i][j]) + " "
            print row

mapReducer = None

def mapper(matrix1, matrix2):
    numRowsMatrix1, numColsMatrix1 = len(matrix1), len(matrix1[0])
    numRowsMatrix2, numColsMatrix2 = len(matrix2), len(matrix2[0])
    
    for i in xrange(numRowsMatrix1):
        for j in xrange(numColsMatrix1):
            for k in xrange(numColsMatrix2):
                key = (i,k)
                value = matrix1[i][j]
                mapReducer.emitIntermediate(key, value)
    for j in xrange(numRowsMatrix2):
        for k in xrange(numColsMatrix2):
            for i in xrange(numRowsMatrix1):
                key = (i,k)
                value = matrix2[j][k]
                mapReducer.emitIntermediate(key, value)


def reducer(key, list_of_values):
    L = len(list_of_values)
    s = sum(list_of_values[i]*list_of_values[L/2+i] for i in xrange(L/2))
    mapReducer.emit((key[0],key[1],s))
    
    
if __name__ == '__main__':
    testcases = int(raw_input())
    
    for t in xrange(testcases):
        mapReducer = MapReduce()
        
        numRows1, numCols1 = map(int,raw_input().split())
        matrix1 = [map(int,raw_input().split()) for i in xrange(numRows1)]  
        numRows2, numCols2 = map(int,raw_input().split())
        matrix2 = [map(int,raw_input().split()) for i in xrange(numRows2)] 
        
        mapReducer.execute(matrix1, matrix2 , mapper, reducer)
