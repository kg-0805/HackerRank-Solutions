#include <iostream>
using namespace std;
enum class Fruit { apple, orange, pear };
enum class Color { red, green, orange };

template <typename T> struct Traits;
#include <string>

template <typename T> struct Traits
{
    static std::string name(int index) { return "unknown"; }
};

template<> struct Traits<Fruit>
{
    static std::string name(int index)
    {
        switch((Fruit)index) {
        case Fruit::apple:      return "apple";
        case Fruit::orange:     return "orange";
        case Fruit::pear:       return "pear";
        default:                return "unknown";
        }
    }
};

template<> struct Traits<Color>
{
    static std::string name(int index)
    {
        switch((Color)index) {
        case Color::red:        return "red";
        case Color::green:      return "green";
        case Color::orange:     return "orange";
        default:                return "unknown";
        }
    }
};
// Define specializations for the Traits class template here.


int main()
{
	int t = 0; std::cin >> t;

    for (int i=0; i!=t; ++i) {
        int index1; std::cin >> index1;
        int index2; std::cin >> index2;
        cout << Traits<Color>::name(index1) << " ";
        cout << Traits<Fruit>::name(index2) << "\n";
    }
}
