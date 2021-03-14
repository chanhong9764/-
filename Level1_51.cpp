#include <string>
#include <iostream>
#include <cmath>


using namespace std;

int solution(string dartResult) {
    int answer = 0;
    int i = 0;
    
    while(!(dartResult.size() <= i))
    {
        int num = 0;
        int pre = 0;
        if(dartResult[i] == '1' && dartResult[i+1] == '0')                  // 10점 판별
        {
            num = 10;
            i += 2;
        }
        else if(dartResult[i] >= '0' && dartResult[i] <= '9')               // 0 ~ 9점 판별
        {
            num = dartResult[i] - '0';
            i++;
        }
        
        switch(dartResult[i])                                               // 보너스 판별
        {
            case 'S':
                num = pow(num,1);
                answer += num;
                i++;
                break;
            case 'D':
                num = pow(num,2);
                answer += num;
                i++;
                break;
            case 'T':
                num = pow(num,3);
                answer += num;
                i++;
                break;
        }
        if((dartResult[i] == '*') && (i != dartResult.size() - 1))          // 옵션 처리
        {
            answer *= 2;
            i++;
        }
        else if(dartResult[i] == '#')
        {
            answer += -2*num;
            i++;
        }
        else if((dartResult[i] == '*') && (i == dartResult.size() - 1))     // 위에 옵션 처리로는 오류나므로 따로 처리
        {
            int tmp = 0;
            int index = 0;
            char tmp_c;
            if((dartResult[2] == '1' && dartResult[3] == '0'))              //  첫번째 다트가 옵션이 없고 0 ~ 9점일 때 두번째 다트가 10점일 경우 
            {
                tmp = 10;
                tmp_c = dartResult[4];
                if(dartResult[5] == '*' || dartResult[5] == '#')            // 두번째 다트 옵션 체크
                    index = 5;
            }
            else if(dartResult[3] == '1' && dartResult[4] == '0')           // 첫번째 다트가 옵션이 존재 또는 10점일 때 두번째 다트가 10점일 경우
            {
                tmp = 10;
                tmp_c = dartResult[5];
                if(dartResult[6] == '*' || dartResult[6] == '#')            // 두번째 다트 옵션 체크
                    index = 6;
            }
            else if(dartResult[4] == '1' && dartResult[5] == '0')           // 첫번째 다트가 옵션이 존재하고 10점일 때 두번째 다트가 10점일 경우
            {
                tmp = 10;
                tmp_c = dartResult[6];
                if(dartResult[7] == '*' || dartResult[7] == '#')            // 두번째 다트 옵션 체크
                    index = 7;
            }
            else if(dartResult[2] >= '0' && dartResult[2] <= '9')           // 첫번째 다트가 옵션이 없고 0 ~ 9점일 때 두번째 다트가 0 ~ 9점일 경우 
            {
                tmp = dartResult[2] - '0';
                tmp_c = dartResult[3];
                if(dartResult[4] == '*' || dartResult[4] == '#')            // 두번째 다트 옵션 체크
                    index = 4;
            }
            else if(dartResult[3] >= '0' && dartResult[3] <= '9')           // 첫번째 다트가 옵션이 존재 또는 10점일 때 두번째 다트가 0 ~ 9점일 경우
            {
                tmp = dartResult[3] - '0';
                tmp_c = dartResult[4];
                if(dartResult[5] == '*' || dartResult[5] == '#')            // 두번째 다트 옵션 체크
                    index = 5;
            }
            else if(dartResult[4] >= '0' && dartResult[4] <= '9')           // 첫번째 다트가 옵션이 존재하고 10점일 때 두번째 다트가 0 ~ 9점일 경우
            {
                tmp = dartResult[4] - '0';
                tmp_c = dartResult[5];
                if(dartResult[6] == '*' || dartResult[6] == '#')            // 두번째 다트 옵션 체크
                    index = 6;
            }
            
            switch(tmp_c)                                                   // 보너스 체크
            {
                case 'S':
                    tmp = pow(tmp,1);
                    break;
                case 'D':
                    tmp = pow(tmp,2);
                    break;
                case 'T':
                    tmp = pow(tmp,3);
                    break;
            }
            
            if(dartResult[index] == '*'){                                   // 두번째 다트 옵션 처리
                tmp *= 2;
                answer -= tmp;
            }
            else if(dartResult[index] == '#'){
                tmp *= -1;
                answer += -1*tmp;
            }
            else
            {
                answer -= tmp;
            }
            answer -= num;
            answer += num * 2;
            answer += tmp * 2;
            i++;
        }
    }
    
    
    return answer;
}