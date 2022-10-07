#include <iostream>
#include <string>
#include <stack>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    stack<char> l,r;
    char mode;
    string input;
    int N;
    
    cin >> input;
    
    for(int i=0; i < input.size(); i++)
        l.push(input[i]);
    
    cin >> N;
    
    for(int i=0; i < N; i++)
    {
        cin >> mode;
        switch(mode)
        {
            case 'L': {
                if(!l.empty())
                {
                    r.push(l.top());
                    l.pop();
                }
                break;
            }
            case 'D': {
                if(!r.empty())
                {
                    l.push(r.top());
                    r.pop();
                }
                break;
            }
            case 'B': {
                if(!l.empty())
                {
                    l.pop();
                }
                break;
            }
            case 'P': {
                char input_c;
                cin >> input_c;
                l.push(input_c);
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
    
    return 0;
}