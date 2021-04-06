#include <string>
#include <vector>

using namespace std;

int lcd(int a, int b)                   // 유클리드 호제법을 이용하여 최소공배수 구하기
{
    int c;
    int temp_a = a;
    int temp_b = b;
    while(b != 0)
    {
        c = a % b;
        a = b;
        b = c;
    }
    return (temp_a * temp_b) / a;
}

int solution(vector<int> arr) {
    int answer = 0;
    
    answer = lcd(arr[0],arr[1]);                // 초기 최소공배수
    for(int i = 1; i < arr.size() - 1; i++)
    {
        answer = lcd(answer,arr[i+1]);          // 앞서 계산되는 최소공배수를 인자로 넣어 계속해서 최소공배수 구하기
    }

    return answer;
}
