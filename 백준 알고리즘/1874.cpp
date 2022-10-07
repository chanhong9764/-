#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n, j=0;
    stack <int> s;
    
    cin >> n;
    int input[n];
    string answer;
    
    for(int i=0; i<n; i++)
        cin >> input[i];
    
    for(int i=0; i<n; i++)
    {
        if(s.empty()) 
        {
            s.push(++j);
            answer += "+";
        }
        while(s.top() != input[i])
        {
            if(j > n)
            {
                cout << "NO"<<"\n";
                return 0;
            }
            s.push(++j);
            answer += "+";
        }
        s.pop();
        answer += "-";
    }
    for(int i=0; i < answer.size(); i++)
        cout << answer[i]<<"\n";
    
    return 0;
}