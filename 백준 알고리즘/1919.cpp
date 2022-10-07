#include <iostream>
#include <string>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    string input, input_s;
    char alphabet[26] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    int same[2][26]={0,}, count=0;
    
    cin >> input >> input_s;
    
    for(int i=0; i < input.size(); i++)
        for(int j=0; j < 26; j++)
            if(input[i] == alphabet[j])
                same[0][j]++;
    
    for(int i=0; i < input_s.size(); i++)
        for(int j=0; j < 26; j++)
            if(input_s[i] == alphabet[j])
                same[1][j]++;
    
    for(int i=0; i < 26; i++)
    {
        if(same[0][i] != same[1][i])
        {
            if(same[0][i] > same[1][i])
                count = count + same[0][i] - same[1][i];
            else
                count = count + same[1][i] - same[0][i];
        }
    }
    cout << count;
    return 0;
}