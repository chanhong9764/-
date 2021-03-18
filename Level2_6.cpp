#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void swap(char & a, char & b)
{
    char temp = a;
    a = b;
    b = temp;
}

void permutation(char data [], int depth, int n, int r, int *answer, vector<int> &v)
{
    if (depth == r)
    {
        string temp = "";
        int count = 0;
        int total = 0;
        for(int i = 0; i < r; i++)
        {
            temp += data[i];
        }
        total = stoi(temp);                     // 조합된 수를 문자열에서 int로 변환
        for(int i = 1; i <= total; i++){        // 소수 판별
            if(total % i == 0)
                count++;
            if(count > 2)
                break;
        }
        if(count == 2){                         // 소수 판별
            if(v.empty())                       // 백터쓰는 이유는 같은 값이 만들어질 수 있어서
            {
                v.push_back(total);
                *answer = *answer + 1;
            }
            else
            {
                auto it = find(v.begin(),v.end(),total);    // 백터안에 존재하지 않으면 처음 만들어지는 수
                if(it == v.end())
                {
                    v.push_back(total);
                    *answer = *answer + 1;
                } 
            }
        }
        return;
    }
    
    for(int i = depth; i < n; i++)
    {
        swap(data[depth], data[i]);   // 스왑
        permutation(data, depth + 1, n, r, answer,v);  // 재귀
        swap(data[depth], data[i]);  // 다시 원래 위치로 되돌리기
    }
}

int solution(string numbers) {
    int answer = 0;
    char arr[numbers.size()];
    vector<int> v;
    for(int i = 0; i < numbers.size(); i++)                 
    {
        arr[i] = numbers[i];
    }
    for(int i = 0; i < numbers.size(); i++)
    {
        permutation(arr,0,numbers.size(),i+1,&answer,v);        // 순열 이용
    }
    
    
    return answer;
}
