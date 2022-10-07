#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;

typedef pair<string, string> ll;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    map<string, string> m;
    vector<ll> v;
    string state = "";
    string uid = "";
    string name = "";
    int i = 0;
    
    for (auto c : record)
    {
        if (c[0] == 'E')                // Enter일 경우
            state = "Enter";
        else if (c[0] == 'L')           // Leave일 경우
            state = "Leave";
        else
            state = "Change";           // Change일 경우
        i = c.find(' ');                // 유저 id의 위치
        c = c.substr(i+1);              // 유저 id부터 끝까지 문장 자르기
        if(state != "Leave")            // Leave가 아닐 경우
        {
            i = c.find(' ');            // 닉네임의 위치
            uid = c.substr(0,i);        // 유저 id만 추출
            c = c.substr(i+1);          // 닉네임 추출
            name = c;
        }
        else
        {
            uid = c;                    // 닉네임이 없을 경우
        }
        if (state == "Enter")           
        {
            if(m.find(uid) != m.end())  // 해당 유저가 전에 들어왔던 적이 있으면
            {
                m[uid] = name;
                v.push_back(make_pair(uid, name + "님이 들어왔습니다."));
                for(int k = 0; k < v.size(); k++)
                {
                    if(v[k].first == uid)
                    {
                        v[k].second = name+v[k].second.substr(v[k].second.find("님이")); // 닉네임 바꾸기
                    }
                }
            }
            else
            {
                m.insert(make_pair(uid, name));
                v.push_back(make_pair(uid, name + "님이 들어왔습니다."));   
            }
        }
        else if (state == "Leave")
        {
            v.push_back(make_pair(uid, m[uid] + "님이 나갔습니다."));
        }
        else if (state == "Change")
        {
            m[uid] = name;
            for(int k = 0; k < v.size(); k++)
                {
                    if(v[k].first == uid)
                    {
                        v[k].second = name+v[k].second.substr(v[k].second.find("님이")); // 닉네임 바꾸기
                    }
                }
        }
    }
   
    for(auto c : v)
    {
        answer.push_back(c.second);
    }
    return answer;
}
