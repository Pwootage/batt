import sys
import time
import io

mode = sys.argv[1]

start = time.clock()
file = io.open("../../../fixtures/war_and_peace.txt", mode="r", encoding="utf-8")
wap = file.read()
file.close()

count = 0

if mode == "RUN":
    count = len(wap.split(" "))
else:
    count = 514908
end = time.clock()

dur = (end - start)
score = 10000 / dur

if count != 514908:
    sys.stderr.write("Got wrong count! Expected " + str(514908) + " got " + str(count))
    exit(1)

print("time " + str(dur))
print("score " + str(int(score)))

