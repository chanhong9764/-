#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

int temp;

using namespace std;

bool cmp(string a, string b)
{
    if(a[temp] != b[temp])
    {
        return a[temp] < b[temp];
    }
    else
    {
        return a < b;
    }
}

vector<string> solution(vector<string> strings, int n) {
    temp = n;
    sort(strings.begin(),strings.end(),cmp);
    
    return strings;
}
