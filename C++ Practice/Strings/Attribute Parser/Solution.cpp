#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

vector<string> tag_stack;
map<string, string> attrs;
    

void insert_attr(string & name, string & val) {
    string full;
    for(string & str : tag_stack)
        full += str + ".";
    full.pop_back();
    full += "~" + name;
    attrs[full] = val;
    
}

int main() {
    int n, q;
    cin >> n >> q;
    
    for(int i = 0; i < n; ++i) {
        char c; cin >> c;
        if(cin.peek() == '/') { // close
            string cn; cin >> cn;
            tag_stack.pop_back();
        }
        else { //open'
            string name;
            cin >> name;
            if(name.back() == '>') { //no attrs
                name.pop_back();
                tag_stack.push_back(name);
            }
            else {
                tag_stack.push_back(name);
                 
                for(;;) { 
                    string attr_name, attr_val, eq;
                    cin >> attr_name >> eq >> attr_val;
                    if(attr_val.back() == '>') { //last attr
                        attr_val.pop_back();
                        attr_val.pop_back();
                        attr_val = attr_val.substr(1);
                        insert_attr(attr_name, attr_val);
                        break;
                    }
                    else {
                        attr_val.pop_back();
                        attr_val = attr_val.substr(1);
                        insert_attr(attr_name, attr_val);
                    }
                }
            }
                
        }
    }
    
    for(int i = 0; i < q; ++i) {
        string quer;
        cin >> quer;
        if(attrs.find(quer) != attrs.end())
            cout << attrs[quer] << endl;
        else 
            cout << "Not Found!" << endl;
    }
    
    
    return 0;
}
