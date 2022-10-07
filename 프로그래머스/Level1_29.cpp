#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(long long n) {
    vector<int> answer;
    string tmp = to_string(n);
    
    for(int i = tmp.size() - 1; i >= 0; i--)
        answer.push_back(tmp[i]-'0');
    return answer;
}
