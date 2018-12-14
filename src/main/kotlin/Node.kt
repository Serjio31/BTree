class Node(
    var keysCount: Int = 0,
    var keys: ArrayList<Int> = ArrayList(),
    var isLeaf: Boolean = true,
    var nodes: ArrayList<Node> = ArrayList()
) {

    fun search(key: Int): Pair<Node, Int>? {
        var i = 0
        while (i < keysCount && key > keys[i]) {
            i++
        }
        if (i < keysCount && key == keys[i]) {
            return Pair(this, i)
        }
        return if (isLeaf) {
            null
        } else {
            nodes[i].search(key)
        }
    }

    fun splitChild(x: Node, i: Int, t: Int) {
        val z = Node()
        z.isLeaf = this.isLeaf
        z.keysCount = t - 1
        for (j in 0 until t - 1) {
            z.keys.add(this.keys[j + t])
        }
        if (!this.isLeaf) {
            for (j in 0 until t) {
                z.nodes[j] = this.nodes[j]
            }
        }
        for (j in t until keysCount) {
            this.keys.removeAt(t)
        }
        this.keysCount = t - 1

        for (j in x.keysCount downTo i + 1) {
            if (j + 1 > x.keysCount) {
                x.nodes.add(x.nodes[j])
            } else {
                x.nodes[j + 1] = x.nodes[j]
            }
        }
        x.nodes[i + 1] = z
        for (j in x.keysCount - 1 downTo i) {
            if (j + 1 >= x.keysCount) {
                x.keys.add(x.keys[j])
            } else {
                x.keys[j + 1] = x.keys[j]
            }
        }
        x.keys[i] = this.keys[t - 1]
        this.keys.removeAt(t - 1)
        x.keysCount++
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (keysCount != other.keysCount) return false
        if (keys != other.keys) return false
        if (isLeaf != other.isLeaf) return false
        if (nodes != other.nodes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = keysCount
        result = 31 * result + keys.hashCode()
        result = 31 * result + isLeaf.hashCode()
        result = 31 * result + nodes.hashCode()
        return result
    }

}