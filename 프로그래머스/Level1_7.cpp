#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    int i, j, k;
    for(auto c : commands)
    {
        vector<int> temp;
        i = c[0];
        j = c[1];
        k = c[2];
        for(int m = i - 1; m < j; m++)
        {
            temp.push_back(array[m]);
        }
        sort(temp.begin(),temp.end());
        answer.push_back(temp[k-1]);
    }
    
    return answer;
}
