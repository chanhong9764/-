#include <string>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;

string solution(string s) {
    string answer = "";
    transform(s.begin(),s.end(),s.begin(),::tolower);       // 모두 소문자로 변환
    
    s[0] = toupper(s[0]);                                   // 첫번째 문자열의 첫 글자 숫자가 아니면 대문자로 변환
    
    for(int i = 0; i < s.size(); i++)                       // 공백 다음에 단어가 시작되니 대문자로 변환
    {
        if(s[i] == ' ')
            s[i+1] = toupper(s[i+1]);
    }
    answer = s;
    return answer;
}
