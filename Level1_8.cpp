#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(int a, int b) {
    string answer = "";
    string day[] = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    int month[] = {31,29,31,30,31,30,31,31,30,31,30,31};
    int total_days=0;
    
    for(int i = 0; i < a-1; i++)
    {
        total_days += month[i];
    }
    total_days += b;
    answer = day[total_days%7];
    return answer;
}
