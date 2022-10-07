#include <iostream>
#include <stack>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    stack <int> s,id;
    
    int n, temp;
    cin >> n;
    for(int i=1; i<=n; i++)
    {
        cin >> temp;
        if(s.empty())
        {
            cout << 0 << " ";
            s.push(temp);
            id.push(i);
        }
        else
        {
            while(s.top() <= temp)
            {
                s.pop();
                id.pop();
                if(s.empty())
                    break;
            }
            if(id.empty())
                cout << 0 << " ";
            else
                cout << id.top() << " ";
            s.push(temp);
            id.push(i);
        }
    }
    return 0;
}