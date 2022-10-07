#include <iostream>

using namespace std;

int main(int argc, char **argv)
{
    int n, m = 1,tmp;
    
    cin >> n;
    
    for(int i = 1; i < n*2; i++)
    {
        if(i > n)
        {
            tmp = i - m - 1;
            m +=2;
        }
        else
            tmp = i;
        for(int j=0; j < tmp; j++)
            cout << "*";
        for(int k=0; k < n*2 - tmp*2; k++)
            cout << " ";
        for(int j=0; j < tmp; j++)
            cout << "*";
        cout<<endl;
    }
    return 0;
}