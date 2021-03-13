#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

long long solution(long long n) {
    long long answer = 0;
    string temp = to_string(n);
    sort(temp.rbegin(),temp.rend());
    answer = stoll(temp);
    return answer;
}
