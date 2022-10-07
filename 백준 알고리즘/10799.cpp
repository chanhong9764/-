#include <iostream>
#include <stack>

using namespace std;

int main(int argc, char **argv)
{
    string input;
    int total=0;
    stack <char> s;
    
    cin >> input;
    
    for(int i=0; i < input.size(); i++)
    {
        if(input[i] == '(')
            s.push(input[i]);
        else
        {
            s.pop();
            if(input[i-1] == '(')
                total += s.size();
            else
                total += 1;
        }
    }
    cout << total;
    
    return 0;
}