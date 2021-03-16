#include <vector>
#include <iostream>

using namespace std;

void Combination(vector<int> arr, vector<int> comb, int r, int index, int depth, int* answer)       // 조합
{
    if (r == 0)                                     // r 이 0이되면 더 이상 뽑을 숫자가 없으므로 출력
    {
        int total = 0;
        int count = 0;
        for (int i = 0; i < comb.size(); i++)       // 3개의 숫자를 total로 합침
        {
            total += comb[i];
        }
        for (int i = 1; i <= total; i++)            // 소수 구하는 과정
        {
            if (total % i == 0)
                count++;
        }
        if (count == 2)
            *answer = *answer + 1;
    }
    else if (depth == arr.size())                   // 더 이상 nums에 가리킬 수가 없으므로 함수 종료
    {
        return;
    }
    else
    {
        comb[index] = arr[depth];                   // 하나의 숫자를 뽑은 경우 
        Combination(arr, comb, r - 1, index + 1, depth + 1, answer);
                                                        
        Combination(arr, comb, r, index, depth + 1, answer); // 하나의 숫자를 뽑지 않은 경우
    }
}

int solution(vector<int> nums) {
    int answer = 0;
    vector<int> comb(3);                            // 3개 선택
    
    Combination(nums, comb, 3, 0, 0, &answer);      // 조합 이용
    
    return answer;
}
