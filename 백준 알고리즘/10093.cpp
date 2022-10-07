#include <iostream>

using namespace std;

int main(int argc, char **argv)
{
    long long A,B;
    
    cin >> A >> B;
    
    if(A>B) {
        cout << A-B-1 << endl;
    	for(long long i = B+1; i < A; i++) {
        	cout << i << " ";
    	}
        cout << endl;
    }
    else if(A<B)
    {
        cout << B-A-1 << endl;
        for(long long i = A+1; i < B; i++) {
            cout << i << " ";
        }
        cout << endl;
    }
    else
        cout << 0 << endl;
    
    return 0;
}