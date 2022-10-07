#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    int max = nums.size() / 2;									// 폰켓몬 최대 선택 가능 값
    
    sort(nums.begin(),nums.end());								// 중복 제거 
    nums.erase(unique(nums.begin(),nums.end()),nums.end());
    
    if(nums.size() >= max)
        answer = max;
    else
        answer = nums.size();
    
    return answer;
}
