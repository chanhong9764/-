#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool compare(string a, string b)
{
    string head[2] = {"",""};
    string num[2] = {"",""};
    bool check[2] = {false, false};                             
    bool check_2[2] = {false, false};
    for(int i = 0; i < a.size(); i++)
    {
        while(!(a[i] >= '0' && a[i] <= '9') && !check[0])               // a의 head 부분 추출
        {
            head[0] += tolower(a[i++]);
        }
        check[0] = true;
        while((a[i] >= '0' && a[i] <= '9') && !check_2[0])              // a의 num 부분 추출
        {
            num[0] += a[i++];
        }
        check_2[0] = true;
    }
    for(int i = 0; i < b.size(); i++)
    {
        while(!(b[i] >= '0' && b[i] <= '9') && !check[1])               // b의 head 부분 추출
        {
            head[1] += tolower(b[i++]);
        }
        check[1] = true;
        while((b[i] >= '0' && b[i] <= '9') && !check_2[1])              // b의 num 부분 추출
        {
            num[1] += b[i++];
        }
        check_2[1] = true;
    }
    if(head[0] == head[1])                                              // head가 같으면 num을 이용하여 비교
        return stoi(num[0]) < stoi(num[1]);
    else
        return head[0] < head[1];                                       // 다르면 head 문자열 비교
    
}

vector<string> solution(vector<string> files) {
    vector<string> answer;
    
    stable_sort(files.begin(),files.end(),compare);             // 일반 sort로는 안풀림 stable_sort 사용 필수
    answer = files;
    
    return answer;
}
