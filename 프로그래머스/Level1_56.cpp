#include <string>
#include <vector>
#include <cstdlib>
#include <iostream>

using namespace std;



string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    int left = 10;
    int right = 12;
    int leftdistance = 0;
    int rightdistance = 0;
    
    for(int i = 0; i < numbers.size(); i++)
    {
        if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7)       // 1,4,7 일 경우 왼손
        {
            answer.push_back('L');
            left = numbers[i];
        }
        else if(numbers[i] == 3 || numbers[i] == 6 ||numbers[i] == 9)   // 3,6,9 일 경우 오른손
        {
            answer.push_back('R');
            right = numbers[i];
        }    
        else
        {
            if(numbers[i] == 0)                                         // 0의 경우 11로 치환
                numbers[i] = 11;
            
            int temp_l = abs(left - numbers[i]);                        // 왼손과의 거리
            int temp_r = abs(right - numbers[i]);                       // 오른손과의 거리
            
            leftdistance = (temp_l / 3) + (temp_l % 3);                 // 누를 숫자까지의 행과 열 구하는 식
            rightdistance = (temp_r / 3) + (temp_r % 3);                
            
            if(leftdistance == rightdistance)                           // 같으면 주로 사용하는 손으로 클릭
            {
                if(hand == "right")
                {
                    answer.push_back('R');
                    right = numbers[i];
                }
                else
                {
                    answer.push_back('L');
                    left = numbers[i];
                }
            }
            else if(leftdistance < rightdistance)
            {
                answer.push_back('L');
                left = numbers[i];
            }
            else
            {
                answer.push_back('R');
                right = numbers[i];
            }
        }
    }
    return answer;
}
