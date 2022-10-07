#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    
    
    for(int i = 0; i < n; i++)
    {
        string arr1_t = "";
        string arr2_t = "";
        string input = "";
        
        while(arr1[i] != 0)                         // 10진법 -> 2진번 변환
        {
            arr1_t += to_string(arr1[i] % 2);
            arr1[i] /= 2;
        }
        
        while(arr1_t.size() != n)                   // 지도 크기에 맞추기
            arr1_t += '0';
        
        reverse(arr1_t.begin(),arr1_t.end());       // 10진법 -> 2진법 변환 
        
        while(arr2[i] != 0)                         // 10진법 -> 2진법 변환
        {
            arr2_t += to_string(arr2[i] % 2);
            arr2[i] /= 2;
        }
        
        while(arr2_t.size() != n)                   // 지도 크기에 맞추기
            arr2_t += '0';
        
        reverse(arr2_t.begin(),arr2_t.end());       // 10진법 -> 2진법 변환
        
        for(int j = 0; j < n; j++)                  // 2개의 지도 중 하나라도 1이라면 # 아니면 공백
        {
            if(arr1_t[j] == '1' || arr2_t[j] == '1')
                input += '#';
            else
                input += ' ';
        }
        answer.push_back(input);                    // 한 행씩 2개의 지도를 합쳐서 정답에 입력
    }
    
    return answer;
}
