#include <iostream>
#include <string>
#include <deque>
#include <stdlib.h>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    deque <int> q;
    
    cin >>t;
    for(int i=0; i<t; i++)
    {
        int n, m=1, reverse =0;
        bool f=true;
        string p, input;
        cin >> p >> n >> input;
        int x[n];
        
        for(int k=0; k<n; k++)
        {
            int a=0;
            char temp[3] = {0,};
            while(input[m] != ',' && input[m] != ']')
            {
                temp[a++] = input[m++];
            }
            m++;
            x[k] = atoi(temp);
            q.push_back(x[k]);
        }
        for(int j=0; j<p.size(); j++)
        {
            switch(p[j])
            {
                case 'R':
                    {
                        reverse= 1 - reverse;
                        break;
                    }
                case 'D':
                    {
                        if(q.empty())
                        {
                            f=false;
                            break;
                        }
                        else
                        {
                            if(reverse == 0)
                            {
                                q.pop_front();
                                break;
                            }
                            else
                            {
                                q.pop_back();
                                break;
                            }
                        }
                    }
            }
        }
        if(f != false)
        {
            int size_b=q.size();
        	cout << '[';
            if(reverse == 0)
            {
                for(int b=0; b<size_b; b++)
                {
                    if(b == size_b - 1)
                    {
                        cout << q.front();
                        q.pop_front();
                    }
                    else
                    {
                    	cout << q.front() << ',';
                    	q.pop_front();
                    }
                }              
            }
            else
            {
                for(int b=0; b<size_b; b++)
                {
                    if(b == size_b-1)
                    {
                        cout << q.back();
                        q.pop_back();
                    }
                    else
                    {
                    	cout << q.back() << ',';
                    	q.pop_back();
                    }
                }
            }
        	cout << ']' << '\n';
        }
        else
        {
            cout << "error" << '\n';
        }
    }
    return 0;
}