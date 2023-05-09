package Programmers.KAKAO_BLIND_RECRUITMENT_2023.표병합

fun main() {
    val commands = arrayOf(
        "UPDATE 1 1 A",
        "UPDATE 2 2 B",
        "UPDATE 3 3 C",
        "UPDATE 4 4 D",
        "MERGE 1 1 2 2",
        "MERGE 3 3 4 4",
        "MERGE 1 1 4 4",
        "UNMERGE 3 3",
        "PRINT 1 1",
        "PRINT 2 2",
        "PRINT 3 3",
        "PRINT 4 4"
    );
    val res = solution(commands);
    res.forEach { print("$it\n") };
}

fun solution(commands: Array<String>): Array<String> {
    val ans = ArrayList<String>();
    val cell = Array(50 * 50) { "EMPTY" };
    val parent = IntArray(50 * 50) { it };

    for (c in commands) {
        val cmd = c.split(" ");
        when (cmd[0]) {
            "UPDATE" -> {
                if (cmd.size == 4) {
                    val root = find(parent, dim2to1(cmd[1].toInt() - 1, cmd[2].toInt() - 1));
                    cell[root] = cmd[3];
                } else {
                    for (i in parent) {
                        val root = find(parent, i);
                        if (cell[root] == cmd[1]) cell[root] = cmd[2];
                    }
                }
            }
            "MERGE" -> {
                val first = dim2to1(cmd[1].toInt() - 1, cmd[2].toInt() - 1);
                val second = dim2to1(cmd[3].toInt() - 1, cmd[4].toInt() - 1);
                if (cell[find(parent, first)] == "EMPTY")
                    union(parent, second, first)
                else union(parent, first, second);
            }
            "UNMERGE" -> {
                val cur = dim2to1(cmd[1].toInt() - 1, cmd[2].toInt() - 1);
                val root = find(parent, cur);
                val v = cell[root];

                val group = HashSet<Int>();
                for (i in parent.indices) {
                    if (find(parent, parent[i]) == root) {
                        cell[i] = "EMPTY";
                        group.add(i);
                    }
                }
                cell[cur] = v;
                for(i in group) parent[i] = i;
            }
            "PRINT" -> {
                val root = find(parent, dim2to1(cmd[1].toInt() - 1, cmd[2].toInt() - 1));
                ans.add(cell[root]);
            }
        }
    }

    return ans.toTypedArray();
}


fun dim2to1(r: Int, c: Int): Int {
    return r * 50 + c;
}

fun union(parent: IntArray, first: Int, second: Int) {
    val fRoot = find(parent, first);
    val sRoot = find(parent, second);

    parent[sRoot] = fRoot;
}

fun find(parent: IntArray, where: Int): Int {
    if (parent[where] == where) return where;

    parent[where] = find(parent, parent[where]);
    return parent[where];
}