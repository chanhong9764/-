#include <iostream>

using namespace std;

int main(int argc, char **argv)
{
    int num, up = 1;
    
    cin >> num;
    
    for(int i = 0; i < num; i++)
    {
        for(int j = 0; j < num - i - 1; j++)
            cout << " ";
        for(int k = 0; k < up; k++)
            cout << "*";
        up += 2;
        cout << endl;
    }
    return 0;
}