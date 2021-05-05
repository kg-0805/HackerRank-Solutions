#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

#include <string>

int currentIDStudent= 0;
int currentIDProff = 0;


class Person
{
public:
    Person();
    ~Person();

    string name;
    int age;
    virtual void getdata() = 0;
    virtual void putdata() = 0;

private:

};

Person::Person()
{
    age = 0;
    name = "";

}

Person::~Person()
{
}
class Professor : public Person
{
public:
    Professor();
    ~Professor();
    int publications;
    int id;


    void getdata()
    {
        std::cin >> name;
        std::cin >> age;
        std::cin >> publications;


    }
    void putdata()
    {
        std::cout << name << " " << age << " " << publications << " " << id << "\n";


    }
private:

};

Professor::Professor()
{
    id = ++currentIDProff;
}

Professor::~Professor()
{
}

class Student : public Person
{
public:
    Student();
    ~Student();
    int marks[6];
    int id;
    void getdata()
    {
        std::cin >> name;
        std::cin >> age;
        for (int i = 0; i < 6; i++)
        {

            std::cin >> marks[i];
        }

    }
    void putdata()
    {
        std::cout << name << " " << age << " ";

        int sum = 0;
        for (auto& num : marks)
        sum += num;

        std::cout << sum << ' ' <<  id << endl;
    }
private:

};

Student::Student()
{
    id = ++currentIDStudent;

}

Student::~Student()
{
}
int main(){

    int n, val;
    cin>>n; //The number of objects that is going to be created.
    Person *per[n];

    for(int i = 0;i < n;i++){

        cin>>val;
        if(val == 1){
            // If val is 1 current object is of type Professor
            per[i] = new Professor;

        }
        else per[i] = new Student; // Else the current object is of type Student

        per[i]->getdata(); // Get the data from the user.

    }

    for(int i=0;i<n;i++)
        per[i]->putdata(); // Print the required output for each object.

    return 0;

}
