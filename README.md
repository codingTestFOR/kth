# dp - 바닥공사.py

📌 바닥 공사 (Dynamic Programming)

이 문제는 가로의 길이가 n이고 세로의 길이가 2인 바닥을 1×2, 2×1, 2×2 타일로 채워내는 경우의 수를 구하는 전형적인 DP 문제입니다.

타일링 규칙에 따른 점화식은 다음과 같습니다:f(n) = f(n-1) + 2 * f(n-2)

💡 해결 방법

✅ Bottom-Up 방식 (반복문 기반)

def bottom_up(n):
    table = [0] * (n + 1)
    table[1] = 1
    if n >= 2:
        table[2] = 3

    for i in range(3, n + 1):
        table[i] = table[i - 1] + 2 * table[i - 2]

    return table[n] % 796796

✅ Top-Down 방식 (재귀 + 메모이젠션)

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

🔍 실행 예시

n = int(input("n 입력 : "))
print("bottomUp :", bottom_up(n))
print("topDown :", top_down(n) % 796796)

🧠 메모

시간 범위도

Top-down: O(n)

Bottom-up: O(n)

모듈러 연산 % 796796은 숫자가 크게 되는 것을 방지하기 위해 가지고 가는 조건입니다.
