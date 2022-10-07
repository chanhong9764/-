#include <string>
#include <vector>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    bool check = true;
    string skill_t;
    
    for(auto c : skill_trees)
    {
        skill_t = skill;
        check = true;
        for(int i = 0; i < c.size(); i++)
        {
            if(skill_t.front() == c[i])             // 가장 앞의 스킬을 스킬트리와 순차적으로 비교
            {
                skill_t.erase(skill_t.begin());     // 만약 가장 앞의 스킬이 순차적 비교에서 스킬트리와 같은 원소가 있을 시 제거
            }
        }
        for(auto d : skill_t)
        {
            if(c.find(d) != string::npos)           // 제거되지 않고 남아있는 스킬들이 스킬트리 안에 존재할 시 스킬트리는 불가능
            {
                check = false;
                break;
            }
        }
        if(check == true){
            answer++;
        }
    }
    
    return answer;
}
