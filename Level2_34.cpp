#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    vector<int> temp;

    for (int i = 0; i < arr1.size(); i++)
    {
        for(int j = 0; j < arr2[0].size(); j++)     // arr2[0]은 arr2 열의 크기
        {
            int total = 0;                          
            for(int k = 0; k < arr2.size(); k++)    // arr2의 한 행의 원소 하나씩
            {
                total += arr1[i][k] * arr2[k][j];   // arr1의 1행과 arr2의 1열의 곱
            }
            temp.push_back(total);
        }
        answer.push_back(temp);
        temp.clear();
    }


    return answer;
}
