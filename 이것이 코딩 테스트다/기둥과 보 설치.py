def possible(answer):
    for x, y, type in answer:
        # 기둥인 경우
        if type == 0:
            # 바닥이거나 다른 기둥 위거나 좌측이나 현재 위치에 보가 있다면 괜춘
            if y == 0 or [x, y - 1, type] in answer or [x - 1, y, 1] in answer or [x, y, 1] in answer:
                continue
            else:
                return False
        # 보인 경우
        else:
            # 한쪽 끝이 기둥 위거나 양쪽 끝이 다른 보와 같이 연결 되있으면 괜춘
            if [x, y - 1, 0] in answer or [x + 1, y - 1, 0] in answer or [x - 1, y, 1] in answer and [x + 1, y, 1] in answer:
                continue
            else:
                return False
    return True

def solution(n, build_frame):
    answer = []
    for frame in build_frame:
        x, y, type, action = frame
        # 설치인 경우
        if action == 1:
            answer.append([x, y, type])
            if not possible(answer):
                answer.remove([x, y, type])
            continue
        # 삭제인 경우
        else:
            answer.remove([x, y, type])
            if not possible(answer):
                answer.append([x, y, type])
            continue
    return sorted(answer)