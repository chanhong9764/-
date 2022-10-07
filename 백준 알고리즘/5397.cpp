#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    stack <char> l, r;
    int n;
    
    cin >> n;
    
    for(int i=0; i<n; i++)
    {
        string input;
        cin >> input;
		
        for(int i=0; i < input.size(); i++)
        {
            switch(input[i])
            {
                case '<':
                    {
                        if(!l.empty())
                        {
                        	r.push(l.top());
                        	l.pop();
                        }
                        break;
                    }
                case '>':
                    {
                        if(!r.empty())
                        {
                        	l.push(r.top());
                        	r.pop();
                        }
                        break;
                    }
                case '-':
                    {
                        if(!l.empty())
                        	l.pop();
                        break;
                    }
                default:
                    {
                        l.push(input[i]);
                        break;
                    }
            }
        }
        while(!l.empty())
        {
            r.push(l.top());
            l.pop();
        }
        while(!r.empty())
        {
            cout << r.top();
            r.pop();
        }
        cout << endl;
    }
    return 0;
}