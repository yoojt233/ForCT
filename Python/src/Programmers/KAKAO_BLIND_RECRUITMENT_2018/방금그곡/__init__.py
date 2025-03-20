def transTime(time):
    hour, minute = time.split(":")

    return int(hour) * 60 + int(minute)


def replace(line):
    line = line.replace('C#', 'c') \
        .replace('D#', 'd') \
        .replace('F#', 'f') \
        .replace('G#', 'g') \
        .replace('A#', 'a') \
        .replace('B#', 'b')

    return line


def solution(m, musicinfos):
    ans = ''
    temp = 0

    for music in musicinfos:
        op, ed, title, melody = music.split(",")
        op, ed = transTime(op), transTime(ed)

        m = replace(m)
        melody = replace(melody)

        played = melody * ((ed - op) // len(melody)) + melody[:(ed - op) % len(melody)]

        if m in played and (ed - op) > temp:
            ans = title
            temp = ed - op

    return ans if ans else '(None)'


m = "ABC"
musicinfos = ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]

print(solution(m, musicinfos))
