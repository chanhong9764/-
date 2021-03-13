#include <string>
#include <vector>

using namespace std;

double solution(vector<int> arr) {
    double answer = 0;
    for(int tmp : arr)
    {
        answer += tmp;
    }
    answer /= arr.size();
    return answer;
}
