#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(int n, int t, int m, int p) {
    string answer = "";
    int i = 0;
    int count = 0;                                  // 내가 말한 횟수
    int count2 = 1;                                 // 전체가 말한 횟수
    
    while(!(count > t))                             // n진법으로 수를 나누어 temp_s에 저장
    {
        int temp = i;
        string temp_s = "";
        if(temp == 0)
        {
            temp_s += to_string(temp);
        }
        else
        {
            while(temp != 0)
            {
                if(temp % n >= 0 && temp % n <= 9)
                    temp_s += to_string(temp % n);
                else if(temp % n == 10)
                    temp_s += 'A';
                else if (temp % n == 11)
                    temp_s += 'B';
                else if (temp % n == 12)
                    temp_s += 'C';
                else if (temp % n == 13)
                    temp_s += 'D';
                else if (temp % n == 14)
                    temp_s += 'E';
                else if (temp % n == 15)
                    temp_s += 'F';
                temp /= n;
            }
        }
        reverse(temp_s.begin(),temp_s.end());               // n진법을 나눈 수는 거꾸로 들어갔으므로 reverse 
        for(auto c : temp_s)
        {
            if(count2 % m == p % m)                         // 내 차례가 오면 추가
            {
                answer += c;
                count++;
                if(count == t)                              // 외친 횟수가 t와 같으면 종료 
                    return answer;
            }
            count2++;   
        }
        i++;
    }
    
    return answer;
}
