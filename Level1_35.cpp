#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, int m) {
    vector<int> answer;
    long long num=n*m;
    int tmp;
    if(m < n)
    {
        int c = m;
        m = n;
        n = c;
    }
    while(n != 0)
    {
        tmp = m % n;
        m=n;
        n=tmp;
    }
    answer.push_back(m);
    answer.push_back(num/m);
    
    return answer;
}
