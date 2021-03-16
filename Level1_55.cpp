#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    int count = 0;

    vector<int>::iterator iter;
    for(int i = 0; i < lost.size(); i++)                            // 여벌 체육복을 가져온 학생이 도난 당했을 경우 체크
    {
        while(1){
            iter = find(reserve.begin(),reserve.end(),lost[i]);
            if(iter != reserve.end())
            {
                reserve.erase(iter);
                lost.erase(lost.begin()+i);
            }
            else
            {
                break;
            }
        }
    }
    
    for(int i = 0; i < lost.size(); i++)                            
    {
        iter = find(reserve.begin(),reserve.end(),lost[i]-1);       // lost - 1 찾기
        if(iter != reserve.end()){
            count++;
            reserve.erase(iter);
        }
        else                                                        // 없으면 
        {
            iter = find(reserve.begin(), reserve.end(), lost[i]+1); // lost + 1 찾기
            if(iter != reserve.end()){
                count++;
                reserve.erase(iter);
            }
        }
    }
    answer = n - lost.size() + count;
    return answer;
}
