#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(string msg) {
    vector<int> answer;
    int i = 1;
    unordered_map<string, int> m;
    
    for(i = 1; i <= 26; i++)                    // 결정되어 있는 색인과 단어 등록
    {
        string temp_s = "";
        temp_s = (char)i+64;
        m[temp_s] = i;
    }
    
    for(int j = 0; j < msg.size();)
    {
        string w = "";
        string prev = "";
        w += msg[j];
        while(m.find(w) != m.end())             
        {
            prev = w;                           // 검색된 단어를 답에 넣기 위해 prev 변수 설정
            w += msg[j+1];                      // 단어 검색이 안될 때까지 계속 검색
            j++;
            if(m.find(w) == m.end())            // 다음 글자를 추가하기 전에 검색된 단어를 답에 입력 
                answer.push_back(m[prev]);
        }
        m[w] = i++;                             // 검색이 안된 단어 사전에 추가
    }
    
    return answer;
}
