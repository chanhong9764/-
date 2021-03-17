#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;
    
    sort(A.begin(),A.end());                    // A 오름차순으로 정렬
    sort(B.rbegin(),B.rend());                  // B 내림차순으로 정렬
    
    for(int i = 0; i < A.size(); i++)
    {
        answer += A[i] * B[i];                  // A에서 가장 작은 수와 B에서 가장 큰 수 곱하여 최소값을 만듦 
    }
    
    return answer;
}
