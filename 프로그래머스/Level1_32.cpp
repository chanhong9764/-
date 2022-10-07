#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> answer(arr);
    if(arr.size() != 1 && arr.size() != 0)
    {
        sort(arr.begin(),arr.end());
        for(vector<int>::iterator iter = answer.begin(); iter != answer.end(); iter++)
        {
            if(arr[0] == *iter)
            {
                answer.erase(iter);
                break;
            }
        }
    }
    else
    {
        answer.clear();
        answer.push_back(-1);
    }
    return answer;
}
