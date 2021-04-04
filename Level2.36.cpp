#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

typedef pair<int,int> ii;

vector<int> solution(string s) {
    vector<int> answer;
    unordered_map<int,int> m;
    string temp = "";
    
    for(int i = 0; i < s.size(); i++)
    {
        while(s[i] >= 48 && s[i] <= 57)         // 숫자 파싱
        {
            temp += s[i];
            ++i;
            if(!(s[i] >= 48 && s[i] <= 57))     // 다음 원소가 숫자가 아닐 시 숫자의 끝이므로 map에 입력
            {
                m[stoi(temp)]++;
            }
        }
        temp = "";
    }
    
    vector<pair<int,int>> v(m.begin(),m.end());
    sort(v.begin(),v.end(), [](pair<int,int> a, pair<int,int> b){   // 가장 처음 원소는 가장 적게 나오는 것을 이용
        return a.second > b.second;
    });
    for(auto c : v)
    {
        answer.push_back(c.first);
    }
    return answer;
}
