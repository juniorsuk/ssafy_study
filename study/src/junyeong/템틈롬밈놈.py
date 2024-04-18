# 파이썬 감을 잃지 않기 위해 오랜만에 파이썬으로 푼 문제입니다 ^_^
from collections import deque
import sys

n, m = map(int, sys.stdin.readline().split())

fld = []

for _ in range(n):
    fld.append(list(map(int, sys.stdin.readline().split())))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs():
    while queue:
        x, y, s, c, v = queue.popleft()
        if c == 4:
            sums.append(s)
            continue
        if c == 2:
            iv = []
            for l in range(4):
                lx = x + dx[l]
                ly = y + dy[l]
                if 0<=lx<m and 0<=ly<n and (lx, ly) not in v:
                    iv.append((lx, ly))
            if len(iv)>1:
                ls = []
                for ll in iv:
                    ls.append(fld[ll[1]][ll[0]])
                if len(ls)>1:
                    if len(ls)>2:
                        ls.remove(min(ls))
                    sums.append(s+sum(ls))
        for k in range(4):
            ax = x + dx[k]
            ay = y + dy[k]
            if 0<=ax<m and 0<=ay<n and (ax, ay) not in v:
                nv = v + [(ax, ay)]
                queue.append((ax, ay, s+fld[ay][ax], c+1, nv))

ans = 0

for i in range(n):
    for j in range(m):
        queue = deque([(j, i, fld[i][j], 1, [(j, i)])])
        sums = []
        bfs()
        ans = max(ans, max(sums))

print(ans)



