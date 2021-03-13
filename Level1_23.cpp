#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    
    for(int i = 0; i < s.size(); i++)
    {
        if(s[i] >= 'A' && s[i] <= 'Z')
        {
            if(s[i] + n > 'Z')
                answer += char(s[i] - 26 + n);
            else
                answer += char(s[i] + n);
        }
        else if(s[i] >= 'a' && s[i] <= 'z')
        {
            if(s[i] + n > 'z')
                answer += char(s[i] - 26 + n);
            else
                answer += char(s[i] + n);
        }
        else
        {
            answer += ' ';
        }
    }
    return answer;
}
