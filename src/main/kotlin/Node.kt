class Node(
    var keysCount: Int = 0,
    var keys: ArrayList<Int> = ArrayList(),
    var isLeaf: Boolean = true,
    var nodesCount: Int = 0,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node

        if (keysCount != other.keysCount) return false
        if (keys != other.keys) return false
        if (isLeaf != other.isLeaf) return false
        if (nodesCount != other.nodesCount) return false
        if (nodes != other.nodes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = keysCount
        result = 31 * result + keys.hashCode()
        result = 31 * result + isLeaf.hashCode()
        result = 31 * result + nodesCount
        result = 31 * result + nodes.hashCode()
        return result
    }

}