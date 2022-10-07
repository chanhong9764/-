#include <string>
#include <algorithm>
#include <unordered_map>

using namespace std;

int solution(string str1, string str2) {
    int answer = 0;
    int count = 0;
    string temp = "";
    unordered_map<string, int> m;
    unordered_map<string, int> m1;
    
    transform(str1.begin(),str1.end(),str1.begin(), ::tolower);     // 소문자 변환
    transform(str2.begin(),str2.end(),str2.begin(), ::tolower); 
     
    for(int i = 0; i < str1.size() - 1; i++)                        // str1을 2글자씩 끊어 m에 입력
    {
        if((str1[i] >= 'a' && str1[i] <= 'z') && (str1[i+1] >= 'a' && str1[i+1] <= 'z')) // 2글자는 오직 영어로만 이루어져 있어야 하는 조건
        {
            temp = "";
            temp += str1[i];
            temp += str1[i+1];
            m[temp]++;
        }
    }
    
    for(int i = 0; i < str2.size() - 1; i++)                        // str2를 2글자씩 끊어 m1에 입력
    {
        if((str2[i] >= 'a' && str2[i] <= 'z') && (str2[i+1] >= 'a' && str2[i+1] <= 'z')) // 2글자는 오직 영어로만 이루어져 있어야 하는 조건
        {
            temp = "";
            temp += str2[i];
            temp += str2[i+1];
            m1[temp]++;
        }
    }
    
    for(auto c: m)
    {
        if(m1.find(c.first) == m1.end())                            // m1에 m의 원소가 없다면 합집합 answer에 값 추가
            answer += c.second;
        else
        {
            if(c.second >= m1.find(c.first)->second){               // m1에 m의 원소가 있다면 합집합과 교집합에 값 추가
                answer += c.second;
                count += m1.find(c.first)->second;
            }
            else{
                answer += m1.find(c.first)->second;
                count += c.second;
            }
        }
    }
    
    for(auto c : m1)                                                // m1의 원소가 m에 없는 경우도 고려하여 합집합에 값 추가 
    {
        if(m.find(c.first) == m.end())
            answer += c.second;
    }
    
    if(answer != 0)                                                 
        answer = (count * 65536) / answer;   
    else
        answer = 65536;
    
    return answer;
}
