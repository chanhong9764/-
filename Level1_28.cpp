#include <iostream>

using namespace std;

int solution(int n)
{
    int answer = 0;
    string tmp = to_string(n);
    for(int i=0; i < tmp.size(); i++)
    {
        answer += (int)tmp[i]-48;
    }
    return answer;
}
