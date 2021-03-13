#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    int a = 0, b = 0, c = 0;
    int count_a = 0, count_b = 0, count_c = 0;
    for(int i = 0; i < answers.size(); i++)
    {
        a++;                        // 1번
        if(a > 5) a = 1;
        if(answers[i] == a)
            count_a++;
        
        if(i % 2 != 0)              // 2번
        {
            b++;
            if(b == 2) b = 3;
            if(b > 5) b = 1;
            if(answers[i] == b)
                count_b++;
        }
        else
        {
            if(answers[i] == 2)
                count_b++;
        }
        
        int three[10] = {3,3,1,1,2,2,4,4,5,5};
        if(three[i%10] == answers[i])
            count_c++;
    }
    if(count_a > count_b && count_a > count_c) answer.push_back(1);
    else if(count_b > count_a && count_b > count_c) answer.push_back(2);
    else if(count_c > count_a && count_c > count_b) answer.push_back(3);
    else if(count_a == count_b && count_a > count_c) { answer.push_back(1); answer.push_back(2); }
    else if(count_b == count_c && count_b > count_a) { answer.push_back(2); answer.push_back(3); }
    else if(count_a == count_c && count_a > count_b) { answer.push_back(1); answer.push_back(3); }
    else
    {
        answer.push_back(1);
        answer.push_back(2);
        answer.push_back(3);
    }
    return answer;
}
