#include <iostream>
#include <string>

using namespace std;

int main(int argc, char **argv)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, k, s, y, room = 0, count[2][6] = {0,};
    
    cin >> n >> k;
    
    for(int i=0; i < n; i++)
    {
        cin >> s >> y;
        
        if(s==0)
        {
            switch(y){
               	case 1: count[0][0]++; break;
               	case 2: count[0][1]++; break;
               	case 3: count[0][2]++; break;
               	case 4: count[0][3]++; break;
               	case 5: count[0][4]++; break;
               	case 6: count[0][5]++; break;
            }
        }
        else
        {
            switch(y) {
                case 1: count[1][0]++; break;
              	case 2: count[1][1]++; break;
               	case 3: count[1][2]++; break;
               	case 4: count[1][3]++; break;
               	case 5: count[1][4]++; break;
               	case 6: count[1][5]++; break;
            }
        }
    }
    for(int i=0; i < 2; i++)
    {
        for(int j=0; j < 6; j++)
        {
            if(count[i][j] % k == 0)
                room += count[i][j] / k;
            else
                room += (count[i][j] / k)+1;
        }
    }
    cout << room;
    
    return 0;
}