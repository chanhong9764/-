using namespace std;

int gcd(int w, int h)                   // 유클리드 호제법을 이용한 최대공약수 구하기
{
    int t;
    while(h != 0)
    {
        t = w % h;
        w = h;
        h = t;
    }
    return w;
}

long long solution(int w,int h) {
    long long answer = 1;
    
    int g = gcd(w,h);
    
    answer = (long long)w * (long long)h - (w + h - g); // gcd 만큼의 동일한 규칙을 가진 블록이 생기고 하나의 블록에서 잘리는 정사각형의 개수는 (w / gcd + h / gcd - 1)이므로 전체 사라지는 정사각형은 저 수식에 gcd만 곱하면 되므로 w+h-g 수식이 나온다.
    
    return answer;
}
