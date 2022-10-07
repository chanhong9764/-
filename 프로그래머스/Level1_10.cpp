#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 0;
    string tmp;
    
    while(1)
    {
        if(n < 3)
        {
            tmp += to_string(n % 3);
            break;
        }
        else
        {
            tmp += to_string(n % 3);
            n /= 3;
        }
    }
    for(int i = 0; i < tmp.size(); i++)
    {
        answer += (tmp[i]-'0') * pow(3,tmp.size() - i - 1);
    }
    return answer;
}
