#include <string>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    
    vector<int>::iterator iter=numbers.begin();
    vector<int>::iterator iter2=numbers.begin();
    int temp=0;
    
    for(iter = numbers.begin(); iter != numbers.end(); iter++)
    {
        for(iter2 = iter+1; iter2 != numbers.end(); iter2++)
        {
            temp = *iter + *iter2;
            answer.push_back(temp);
        }
    }
    sort(answer.begin(),answer.end());
    answer.erase(unique(answer.begin(),answer.end()),answer.end());
    
    return answer;
}
