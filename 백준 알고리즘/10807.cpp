#include <iostream>
#define MAX_LEN 100

using namespace std;

int main(int argc, char **argv)   
{
    
    int n, v, input[MAX_LEN] = {0,}, answer = 0;
    
    cin >> n;
    for(int i=0; i < n; i++)
        cin >> input[i];
    cin >> v;
    
    for(int i=0; i < n; i++)
        if(input[i] == v)
            answer++;
    cout << answer;
    return 0;
}