#include <iostream>
#include <string>
#include <stack>
using namespace std;

int solution(string s)
{
    int answer = 0;
    stack<char> st;
    
    for(int i = 0; i < s.size(); i++)
    {
        if(st.empty())                  // 스택에 없으면 push
        {
            st.push(s[i]);
        }
        else
        {
            if(st.top() == s[i])        // 스택 가장 위 원소와 들어올 원소 비교
            {
                st.pop();
            }
            else
            {
                st.push(s[i]);
            }
        }
    }
    
    if(st.empty())                      
    {
        answer = 1;
    }
    
    return answer;
}
