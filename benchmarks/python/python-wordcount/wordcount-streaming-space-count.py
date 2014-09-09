import sys
import time
import io

mode = sys.argv[1]

start = time.clock()
file = io.open("../../../fixtures/war_and_peace.txt", "rb")
count = 1

if mode == "RUN":
    while file.readable():
        buff = file.read(2048)
        if len(buff) == 0:
            break
        for i in buff:
            if i == 0x20:
                count += 1
else:
    count = 514908

end = time.clock()

if count != 514908:
    sys.stderr.write("Got wrong count! Expected " + str(514908) + " got " + str(count))
    exit(1)

dur = (end - start)
score = dur * 10000
print("time " + str(dur))
print("score " + str(int(score)))

