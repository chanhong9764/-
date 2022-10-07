#include <string>
#include <algorithm>
#include <regex>

using namespace std;

string solution(string new_id) {
    string answer = "";
    regex reg("/[^a-z0-9-_.]/gi");
    for(int i = 0; i < new_id.size(); i++)      // 1단계
        new_id[i] = tolower(new_id[i]);
    
    new_id = regex_replace(new_id,regex("[^a-z0-9-_.]") ,"");   // 2단계

    new_id = regex_replace(new_id,regex("[.]+"),".");
    if(new_id[0] == '.')                                    // 4단계
    {
        new_id.erase(new_id.begin());
    }
    if(new_id[new_id.size()-1] == '.')
    {
        new_id.erase(new_id.end()-1);
    }
    
    if(new_id.empty())                                      // 5단계
    {
        new_id = 'a';
    }
    
    if(new_id.size() >= 16)                                 // 6단계
    {
        new_id.erase(15);
        if(new_id[new_id.size()-1] == '.')
            new_id.erase(new_id.end()-1);
    }
    
    if(new_id.size() <= 2)                                  // 7단계
    {
        while(new_id.size() != 3)
        {
            new_id.push_back(new_id[new_id.size()-1]);
        }
    }
    
    answer = new_id;
    return answer;
}
