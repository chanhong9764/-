#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    
    for(int i = 0; i < prices.size(); i++)
    {
        int count = 0;
        for(int j = i+1; j < prices.size(); j++)
        {
            count++;
            if(prices[i] > prices[j])                   // 가격이 떨어지면 중단
                break;
        }
        answer.push_back(count);                        // 몇 초 동안 안 떨어졌는지 count를 답에 push
    }
    
    return answer;
}
