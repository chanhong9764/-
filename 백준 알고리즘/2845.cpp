#include <iostream>

using namespace std;

int main(void)
{
    int L, P;
    int person[5];

    cin >> L >> P;

    for(int i = 0; i < 5; i++)
    {
        cin >> person[i];
        cout << person[i] - L*P << " ";
    }
    return 0;
}
