#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(string s) {
    string answer = "";
    int init = 0;
    
    for(int i = 0; i < s.size(); i++)
    {
        if(s[i] == ' ')
        {
            init = 0;
        }
        else
        {
            if(init % 2 == 0)
            {
                if(s[i] >= 97 && s[i] <= 122)
                    s[i] = s[i] - 32;
            }
            else
            {
                if(s[i] >= 65 && s[i] <= 90)
                     s[i] = s[i] + 32;
            }
            init++;
        }
    }
    answer = s;
    return answer;
}
