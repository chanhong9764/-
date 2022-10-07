#include <iostream>
#include <string>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    string input;
    long long count[9] = {0,}, max=0, sixnine=0;
    
    cin >> input;
    
    for(long long i=0; i < input.size(); i++)
    {
        switch(input[i])
        {
            case '0': count[0]++; break;
            case '1': count[1]++; break;
            case '2': count[2]++; break;
            case '3': count[3]++; break;
            case '4': count[4]++; break;
            case '5': count[5]++; break;
            case '6': count[8]++; break;
            case '7': count[6]++; break;
            case '8': count[7]++; break;
            case '9': count[8]++; break;
        }
    }
    for(int i=0; i < 8; i++)
    {
        if(max < count[i])
            max = count[i];
    }
    if(count[8] % 2 == 0)
        sixnine = count[8] / 2;
    else
        sixnine = (count[8]/2)+1;
    if(sixnine > max)
        cout << sixnine;
    else
        cout << max;
    return 0;
}