#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    vector<int> array;
    
    for(int i = 0; i < s.size(); i++)
    {
        string temp;
        if(s[i] == ' ')                             // 공백 패스
            continue;
        else if(s[i] == '-')                        // 음수일 경우
        {
            i++;
            while(s[i] != ' ')                      // 공백을 만나기전까지 문자로 나타낸 숫자를 temp에 넣는다
            {
                temp += s[i];
                i++;
            }
            array.push_back(-1 * stoi(temp));       // 문자로 이루어진 숫자를 int형으로 바꾼다
        }
        else
        {
            while(s[i] != ' ')                      // 공백을 만나기전까지 문자로 나타낸 숫자를 temp에 넣는다
            {
                temp += s[i];
                i++;
            }
            array.push_back(stoi(temp));            // 문자로 이루어진 숫자를 int형으로 바꾼다
        }
    }
    sort(array.begin(),array.end());                // 오름차순 정렬
    answer += to_string(array[0]) + " " + to_string(array[array.size() - 1]); // 가장 첫번째와 마지막 선택
    return answer;
}
