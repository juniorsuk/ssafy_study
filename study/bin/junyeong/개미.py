w, h = map(int, input().split())
x, y = map(int, input().split())
t = int(input())

tx = t%(2*w)
ty = t%(2*h)

if tx<=w-x:
    x += tx
elif tx+x <2*w:
    x = 2*w-x-tx
else:
    x = x+tx-2*w

if ty<=h-y:
    y += ty
elif ty+y <2*h:
    y = 2*h-y-ty
else: y = y+ty-2*h

print(str(x)+" "+str(y))
