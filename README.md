@ dp - 바닥공사.py

def bottom_up(n):
    table = [0] * (n + 1)
    table[1] = 1
    if n >= 2:
        table[2] = 3

    for i in range(3, n + 1):
        table[i] = table[i - 1] + 2 * table[i - 2]

    return table[n] % 796796


# 메모이제이션용 배열
memo = [0] * 1001

def top_down(n):
    if n == 1:
        return 1
    if n == 2:
        return 3
    if memo[n] != 0:
        return memo[n]

    memo[n] = top_down(n - 1) + 2 * top_down(n - 2)
    return memo[n]


# 입력 받기
n = int(input("n 입력 : "))
print("bottomUp :", bottom_up(n))
print("topDown :", top_down(n) % 796796)
