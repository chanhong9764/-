#include<string>
#include <stack>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<char> st;
    
    for(int i = 0; i < s.size(); i++)
    {
        if(s[i] == '(')                     // 스택에 넣기
        {
            st.push('(');
        }
        else if(s[i] == ')')                
        {
            if(!st.empty())                 // 비어있지 않으면 () 이렇게 되므로 스택에서 제거
            {
                if(st.top() == '(')
                    st.pop();
            }
            else
            {
                st.push(')');
            }
        }
    }
    if(st.empty())                          // 비어있으면 올바른 괄호
        answer = true;
    else
        answer = false;

    return answer;
}
