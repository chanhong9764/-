#include <string>
#include <vector>
#include <iostream>
using namespace std;

bool solution(int x) {
    bool answer = true;
    string tmp = to_string(x);
    int num = 0;
    
    for(int i = 0; i < tmp.size(); i++)
    {
        num += tmp[i] - '0';
    }
    if(x % num != 0) answer=false;
    
    return answer;
}
