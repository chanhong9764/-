#include <string>
#include <vector>
#include <map>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    string prev = "";
    map<string,int> m;
    

    for(int i = 0; i < phone_book.size(); i++)
    {
        m.insert(make_pair(phone_book[i],i));                           // map에 입력하면 정렬되어 들어감
    }                                                                   
    
    for(auto c : m)
    {
        if(prev == c.first.substr(0,prev.size()) && !prev.empty())      // 정렬되어 들어가서 각 문자 앞뒤만 비교하면 됨
           return answer = false;
        prev = c.first;
    }
    
    return answer;
}
