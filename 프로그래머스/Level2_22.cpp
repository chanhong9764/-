#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int count = 0;                      // 제거된 0의 개수
    int count2 = 0;                     // 변환 횟수
    
    while(s.size() != 1)
    {
        string temp = "";
        for(auto c : s)
        {
            if(c == '1')                // 문자 1만 저장
                temp += c;
            else
                count++;
        }
        string temp_c = "";             // 이진 변환 결과
        int temp_i = temp.size();
        while(temp_i != 0)              // 이진 변환 과정
        {
            temp_c += to_string(temp_i % 2);
            temp_i /= 2;
        }
        s = temp_c;                     
        count2++;
    }
    answer.push_back(count2);
    answer.push_back(count);
    
    return answer;
}
