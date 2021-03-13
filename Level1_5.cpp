#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    map<string, int> m;
    
    for(auto c : completion)
    {
        m[c] += 1;
    }
    for(auto p : participant)
    {
        m[p] -= 1;
        if(m[p] < 0)
            answer = p;
    }
    
    return answer;
}
