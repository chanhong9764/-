#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    vector<int> people;
    unordered_map<string, int> m;
    bool check = true;                              
    string prev = "";
    int i = 0;
    
    for(int i = 0; i < n; i++)
        people.push_back(1);                        // 모두 첫번째 순서로 셋팅
    
    for(i = 0; i < words.size(); i++)
    {
        if(!m.empty())
        {
            if(m.find(words[i]) == m.end())         // 전에 말했던 단어인지 체크
            {
                if(prev.back() != words[i].front())     // 앞 단어 끝과 뒷 단어 앞이 다를시 종료
                {
                    check = false;
                    break;
                }
                m[words[i]] = i;                    // 단어 push
                people[i%n]++;                      // 차례 증가
            }
            else
            {
                check = false;
                break;
            }   
        }
        else
        {
            m[words[i]] = i;
            people[i%n]++;
        }
        prev = words[i];
    }
    
    if(check)                                       // 끝말잇기를 탈락자 없이 완료했을 경우
    {
        answer.push_back(0);
        answer.push_back(0);
    }
    else
    {
        answer.push_back(i%n+1);
        answer.push_back(people[i%n]);
    }
    
    return answer;
}
