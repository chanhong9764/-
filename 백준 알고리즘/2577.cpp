#include <iostream>
#include <string>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

  	int a,b,c;
    int number[10] = {'0','1','2','3','4','5','6','7','8','9'};
    int answer_num[10] = {0,};
    string answer;
    cin >> a >> b >> c;
    
    answer = to_string(a*b*c);
    
    for(int i=0; i < answer.size(); i++){
        for(int j=0; j < 10; j++){
            if(answer[i] == number[j])
                answer_num[j]++;
        }
    }
    for(int i=0; i < 10; i++)
        cout << answer_num[i] <<endl;
    return 0;
}