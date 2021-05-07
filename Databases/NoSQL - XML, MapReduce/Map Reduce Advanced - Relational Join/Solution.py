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
        self.result.append(value) 

    def execute(self, data, mapper, reducer):
        for record in data:
            mapper(record)

        for key in self.intermediate:
            reducer(key, self.intermediate[key])

        self.result.sort()
        
        for item in self.result:
            print item

mapReducer = MapReduce()

def mapper(record):
    recSplit = record.split(",")
    t1, t2, t3 = recSplit
    
    if t1 == "Department": #Department [SSN] [Department_Name]
        ssn = t2
    elif t1 == "Employee": #Employee [Person_Name] [SSN]
        ssn = t3
    mapReducer.emitIntermediate(ssn, recSplit)
        

def reducer(key, list_of_values):
    depPiece = []
    empPiece = []
    for t1, t2, t3 in list_of_values:
        if t1 == "Department":
            depPiece.append((t1,t2,t3))
        elif t1 == "Employee":
            empPiece.append((t1,t2,t3))
    
    for t1Emp, person_name, ssnEmp in empPiece:
        for t1Dep, ssnDep, department_name in depPiece:
            mapReducer.emit((key, person_name, department_name))
    
            
if __name__ == '__main__':
    inputData = []
    for line in sys.stdin:
        inputData.append(line.strip())
    mapReducer.execute(inputData, mapper, reducer)
