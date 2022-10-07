#include <iostream>
#include <string.h>
#define MAX_LEN 100

using namespace std;

int main(int argc, char **argv)
{
    char input[MAX_LEN];
    char alphabet[26] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    int answer[26] = {0,};
    int length = 0;
    
    cin >> input;
    
    for(int i = 0; i < strlen(input); i++)
        for(int j=0; j < 26; j++)
            if(input[i] == alphabet[j])
                answer[j]++;
    for(int i=0; i < 26; i++)
        cout << answer[i] <<" ";
    return 0;
}