#include <iostream>
#include <deque>

using namespace std;

int find_f(deque<int> dq, int sel, int n)
{
    int count_f = 0, i=0;
    
    while(dq[i] != sel)
    {
        count_f++;
        i++;
    }
    return count_f;
}
int find_b(deque<int> dq, int sel, int n)
{
    int count_b = 0, i=n-1;
    
    while(dq[i] != sel)
    {
        count_b++;
        i--;
    }
    return count_b;
}

int main(int argc, char ** argv)
{
    int n, m, count = 0, total = 0;
    deque<int> dq;
    
    cin >>n >>m;
    int select[m];
    int copy_n=n;
    for(int i=0; i < m; i++)
        cin >> select[i];
    
    for(int i=1; i <= n; i++) {
        if(i == 1) dq.push_front(i);
        else dq.push_back(i);
    }

    for(int i=0; i < m; i++)
    {
        count = 0;
        if(find_f(dq,select[i],copy_n) <= find_b(dq,select[i],copy_n))
        {
            while(dq[0] != select[i])
            {
                dq.push_back(dq.front());
                dq.pop_front();
                count += 1;
            }
            dq.pop_front();
            copy_n--;
        }
        else
        {
            while(dq[0] != select[i])
            {
                dq.push_front(dq.back());
                dq.pop_back();
                count +=1;
            }
            dq.pop_front();
            copy_n--;
        }
        total += count;
    }
    
    cout << total;
    
    return 0;
}