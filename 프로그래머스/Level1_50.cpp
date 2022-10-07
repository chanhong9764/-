#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

typedef pair<int,double> ii;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    int i = 1;
    map<int, double> fail;

    while(N+1 != i)
    {
        int count = 0;
        int j = 0;
        int size = stages.size();
        
        while(!(j >= stages.size()))                // 실패율 구하는 부분
        {
            while(stages[j] == i && j != stages.size())
            {
                stages.erase(stages.begin()+j);
                count++;
            }
            j++;
        }
        
        if(count == 0 && size == 0)                 // 0 / 0 예외처리 필수 
        {
            fail[i] = 0;
        }
        else
        {
            fail[i] = (double)count / size;
        }
        i++;
    }
    
    vector<ii> v(fail.begin(),fail.end());
    
    sort(v.begin(),v.end(),[] (ii a, ii b){
        if(a.second == b.second)                    // 실패율이 같으면 스테이지 순서대로 출력
            return a.first < b.first;
        else
            return a.second > b.second;
    });
    
    for(ii it : v)
    {
        answer.push_back(it.first);
    }
    return answer;
}
