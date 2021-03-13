#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    vector<int>::iterator iter;
    int temp=arr[0];
    for(iter=arr.begin()+1; iter != arr.end(); iter++)
    {
        if(temp != *iter)
        {
            answer.push_back(temp);
            temp=*iter;
        }
    }

    return answer;
}
