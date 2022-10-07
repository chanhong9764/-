#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(int argc, char **argv)
{
    int n;
    stack <char> s;
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        string input;
        cin >>input;
        
        for(int j=0; j < input.size(); j++)
        {
            if(input[j] == '(')
            {
                s.push(input[j]);
            }
            else if(input[j] == ')')
            {
                if(s.empty())
                    s.push(input[j]);
                else if(s.top() == '(')
                	s.pop();
                else
                    s.push(input[j]);
            }
            else
                cout << "Input Error !" <<endl;
        }
        if(s.empty())
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
        while(!s.empty())
            s.pop();
    }
    
    return 0;
}