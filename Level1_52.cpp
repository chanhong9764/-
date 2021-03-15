#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    stack<int> boards[board.size()];
    stack<int> basket;
    
    for(int i = board.size() - 1; i >= 0; i--)              // 보드판 만들기
    {
        for(int j = 0; j < board.size(); j++)
        {
            if(board[i][j] != 0)
                boards[j].push(board[i][j]);
        }
    }
    
    for(int i = 0; i < moves.size(); i++)                   // 뽑기
    {
        int c = moves[i] - 1;
        if(basket.empty()){                                 // 장바구니 비어있는지 체크
            if(boards[c].empty()){                          // 보드안에 인형이 있는지 체크 
                continue;
            }
            else
            {
                basket.push(boards[c].top());
                boards[c].pop();
            }
        }
        else
        {
            if(boards[c].empty()){                           // 보드안에 인형이 있는지 체크
                continue;
            }
            else if(basket.top() == boards[c].top())         // 장바구니 인형과 뽑은 인형이 같으면 제거
            {
                basket.pop();
                boards[c].pop();
                answer += 2;
            }
            else                                              // 장바구니 인형과 뽑은 인형이 같지 않으면 장바구니에 추가
            {
                basket.push(boards[c].top());
                boards[c].pop();
            }
        }
    }
    return answer;
}
