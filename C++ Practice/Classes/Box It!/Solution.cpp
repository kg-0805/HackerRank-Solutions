#include<bits/stdc++.h>

using namespace std;
//Implement the class Box  
//l,b,h are integers representing the dimensions of the box

//Implement the class Box  
//l,b,h are integers representing the dimensions of the box

// The class should have the following functions : 

// Constructors: 
// Box();
// Box(int,int,int);
// Box(Box);

// Destructor
// ~Box()
// {

// }

// int getLength(); // Return box's length
// int getBreadth (); // Return box's breadth
// int getHeight ();  //Return box's height
// long long CalculateVolume(); // Return the volume of the box

//Overload operator < as specified

//Overload operator << as specified
class Box {
 public:
int BoxesCreated;
int BoxesDestroyed;
  Box()
    : l {0},
      b {0},
      h {0}
  {
    BoxesCreated++;
  }
  
  Box(
      int length
    , int breadth
    , int height)
    : l {length},
      b {breadth},
      h {height}
  {
    ++BoxesCreated;
  }
  
  Box(Box& B)
    : l {},
      b {},
      h {}
  {
    l = B.getLength();
    b = B.getBreadth();
    h = B.getHeight();
    
    ++BoxesCreated;
  }
    
  ~Box()
  {
    ++BoxesDestroyed;
  }
  
  int getLength() const
  {
    return l;
  }
  
  int getBreadth() const
  {
    return b;
  }
  
  int getHeight() const
  {
    return h;
  }
  
  long long CalculateVolume()
  {
    return static_cast<long long>(l) * static_cast<long long>(b) *
        static_cast<long long>(h);
  }
  
 private:
  int l;
  int b;
  int h;
};

bool operator<(const Box& A, const Box& B)
{
  auto al = A.getLength();
  auto ab = A.getBreadth();
  auto ah = A.getHeight();
  auto bl = B.getLength();
  auto bb = B.getBreadth();
  auto bh = B.getHeight();
  return (al < bl) || (ab < bb && al == bl) ||
      (ah < bh && ab == bb && al == bl);
}

std::ostream& operator<<(std::ostream& out, Box B)
{
  auto bl = B.getLength();
  auto bb = B.getBreadth();
  auto bh = B.getHeight();
  return out << bl << " " << bb << " " << bh;
}

void check2()
{
	int n;
	cin>>n;
	Box temp;
	for(int i=0;i<n;i++)
	{
		int type;
		cin>>type;
		if(type ==1)
		{
			cout<<temp<<endl;
		}
		if(type == 2)
		{
			int l,b,h;
			cin>>l>>b>>h;
			Box NewBox(l,b,h);
			temp=NewBox;
			cout<<temp<<endl;
		}
		if(type==3)
		{
			int l,b,h;
			cin>>l>>b>>h;
			Box NewBox(l,b,h);
			if(NewBox<temp)
			{
				cout<<"Lesser\n";
			}
			else
			{
				cout<<"Greater\n";
			}
		}
		if(type==4)
		{
			cout<<temp.CalculateVolume()<<endl;
		}
		if(type==5)
		{
			Box NewBox(temp);
			cout<<NewBox<<endl;
		}

	}
}

int main()
{
	check2();
}